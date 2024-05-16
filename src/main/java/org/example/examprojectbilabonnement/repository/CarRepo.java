package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Car> findAll(){
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.car";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(Car.class));
    }
    public void addCar(Car car) {
        final String INSERT_SQL = "INSERT INTO car( model, brand, frameNumber) VALUES(?,?,?)";
        jdbcTemplate.update(INSERT_SQL, car.getModel(), car.getBrand(), car.getFrameNumber());
    }
}
