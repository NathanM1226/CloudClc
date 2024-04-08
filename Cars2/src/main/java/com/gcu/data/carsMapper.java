package com.gcu.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

@Slf4j 
public class carsMapper implements RowMapper<carsModel> {
    public carsModel mapRow(ResultSet resultSet, int i) throws SQLException {
        log.debug("Mapping ResultSet row to carsModel object");
        carsModel car = new carsModel(
            resultSet.getInt("iD"),
            resultSet.getString("make"),
            resultSet.getString("model"),
            resultSet.getInt("year"),
            resultSet.getInt("miles"),
            resultSet.getFloat("price"));
        
        log.debug("Mapped carsModel object: {}", car);
        return car;
    }
}
