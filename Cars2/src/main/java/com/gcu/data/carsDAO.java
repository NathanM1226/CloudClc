package com.gcu.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
@Primary
@Slf4j 
public class carsDAO implements carsInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public carsDAO(DataSource dataSource){
        this.dataSource =dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<carsModel> getCars() {
        log.info("Fetching all cars from the database"); // Log a message indicating that all cars are being fetched
        return jdbcTemplate.query("select * from cars", new carsMapper());
    }

    @Override
    public long addOne(carsModel car) {
        log.info("Adding a new car to the database: {}", car); // Log the details of the car being added
        return jdbcTemplate.update("insert into cars ( make, model, year, miles, price) values (?,?,?,?,?)",
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getMiles(),
                car.getPrice());
    }

    @Override
    public boolean deleteOne(long id) {
        log.info("Deleting car with ID: {}", id); // Log the ID of the car being deleted
        int updateResult = jdbcTemplate.update("delete from cars where id = ?", new Object[]{id});
        return (updateResult > 0);
    }

    @Override
    public carsModel updateOne(long idToUpdate, carsModel updateCar) {
        log.info("Updating car with ID: {}", idToUpdate); // Log the ID of the car being updated
        int result = jdbcTemplate.update("update cars set make = ?, model = ?, year = ?, miles = ?, price = ?",
                updateCar.getMake(),
                updateCar.getModel(),
                updateCar.getYear(),
                updateCar.getMiles(),
                updateCar.getPrice());

        if (result > 0) {
            log.info("Car with ID {} updated successfully", idToUpdate); // Log a success message if the update was successful
            return updateCar;
        } else {
            log.error("Failed to update car with ID {}", idToUpdate); // Log an error message if the update failed
            return null;
        }
    }
}
