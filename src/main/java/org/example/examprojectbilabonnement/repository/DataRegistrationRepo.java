package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataRegistrationRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCar(Car car) {
        final String INSERT_SQL = "INSERT INTO car( model, brand, frameNumber) VALUES(?,?,?)";
        jdbcTemplate.update(INSERT_SQL, car.getModel(), car.getBrand(), car.getFrameNumber());


    }


}
