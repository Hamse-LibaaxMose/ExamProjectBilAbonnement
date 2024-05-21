package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Location> findAll(){
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.location";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(Location.class));
    }
    public void addLocation(Location location) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.location( name, city, zipcode, adress) VALUES(?,?,?,?)";
        jdbcTemplate.update(INSERT_SQL, location.getName(),location.getCity(),location.getZipCode(), location.getAdress());
    }

    public void deleteLocationBYLocationID(int locationID) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.location WHERE locationID = ?";
        jdbcTemplate.update(DELETE_SQL, locationID);
    }

    public Location findByID (int locationID){
        final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.location WHERE locationID = ?";
        return jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(Location.class), locationID);
    }

    public void updateByID(Location location){
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.location SET name = ?, city = ?, zipCode = ?, adress = ? WHERE locationID = ?";
        jdbcTemplate.update(UPDATE_SQL, location.getName(), location.getCity(),location.getZipCode(), location.getAdress(), location.getLocationID());
    }




}
