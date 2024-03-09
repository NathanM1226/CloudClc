package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@Primary
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
        return jdbcTemplate.query("select * from cars", new carsMapper());
    }

    @Override
    public long addOne(carsModel car) {
        return jdbcTemplate.update("insert into cars ( make, model, year, miles, price) values (?,?,?,?,?)",
        car.getMake(),
        car.getModel(),
        car.getYear(),
        car.getMiles(),
        car.getPrice());
    }

    @Override
    public boolean deleteOne(int id) {
        int updateResult = jdbcTemplate.update("delete from cars where id = ?", 
        new Object[]{id});
        return (updateResult > 0);
    }

    @Override
    public carsModel updateOne(int idToUpdate, carsModel updateCar) {
        int result = jdbcTemplate.update("update cars set make = ?, model = ?, year = ?, miles = ?, price = ?", 
        updateCar.getMake(),
        updateCar.getModel(),
        updateCar.getYear(),
        updateCar.getMiles(),
        updateCar.getPrice());

        if (result > 0)
        return updateCar;
        else
        return null;
    }
    
}
