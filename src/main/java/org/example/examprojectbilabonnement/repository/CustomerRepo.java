package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.customer";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void addCustomer(Customer customer) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.customer(name, adress, mail, phoneNumber) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(INSERT_SQL, customer.getName(), customer.getAdress(), customer.getMail(), customer.getPhoneNumber());

    }

    public void deleteCustomerByCustomerID(int customerID) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.customer WHERE customerID = ?";
        jdbcTemplate.update(DELETE_SQL, customerID);
    }

    public Customer findByID(int customerID) {
        final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.customer where customerID = ?";
        return jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(Customer.class), customerID);
    }

    public void updateByID(Customer customer) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.customer SET name = ?, adress = ?, mail = ?, phoneNumber = ? WHERE customerID = ?";
        jdbcTemplate.update(UPDATE_SQL, customer.getName(), customer.getAdress(), customer.getMail(), customer.getPhoneNumber(), customer.getCustomerID());
    }


}
