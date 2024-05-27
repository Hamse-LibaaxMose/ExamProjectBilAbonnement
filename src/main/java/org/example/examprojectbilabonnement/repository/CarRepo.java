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
    private JdbcTemplate jdbcTemplate; // Spring leverer automatisk en instans af JdbcTemplate

    public List<Car> findAll() {
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.car";
        // Henter alle biler fra databasen
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(Car.class));
    }

    public void addCar(Car car) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.car(model, brand, frameNumber) VALUES(?,?,?)";
        // Tilføjer en ny bil til databasen
        jdbcTemplate.update(INSERT_SQL, car.getModel(), car.getBrand(), car.getFrameNumber());
    }

    public void deleteCarByCarNumberID(int carNumberId) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.car WHERE carNumberID = ?";
        // Sletter en bil fra databasen ved hjælp af bilens ID
        jdbcTemplate.update(DELETE_SQL, carNumberId);
    }

    public Car findByID(int carNumberID) {
        final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.car WHERE carNumberID = ?";
        // Finder en bil i databasen ved hjælp af bilens ID
        return jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(Car.class), carNumberID);
    }

    public void updateByID(Car car) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.car SET model = ?, brand = ?, frameNumber = ? WHERE carNumberID = ?";
        // Opdaterer oplysningerne om en bil i databasen
        jdbcTemplate.update(UPDATE_SQL, car.getModel(), car.getBrand(), car.getFrameNumber(), car.getCarNumberID());
    }
}
