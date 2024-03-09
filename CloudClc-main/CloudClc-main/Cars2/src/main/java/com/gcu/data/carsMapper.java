package com.gcu.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class carsMapper implements RowMapper<carsModel> {
    public carsModel mapRow(ResultSet resultSet, int i) throws SQLException{
        carsModel car = new carsModel(
            resultSet.getInt("iD"),
            resultSet.getString("make"),
            resultSet.getString("model"),
            resultSet.getInt("year"),
            resultSet.getInt("miles"),
            resultSet.getFloat("price"));

            return car;
    }
}
