package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.model.Location;
import org.example.examprojectbilabonnement.model.RentalContract;
import org.example.examprojectbilabonnement.model.RentalContractView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalContractRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RentalContractView> findAll() {
        final String SELECT_SQL = "SELECT rc.*, c.name customerName, s.name subscriptionName,  ca.model carModelName, \n" +
                "ca.frameNumber carFrameNumber, l1.name pickupLocationName,  l2.name deliveryLocationName\n" +
                "FROM bilabonnementhamsa.rentalcontract rc\n" +
                "join bilabonnementhamsa.customer c on c.customerId = rc.customerId\n" +
                "join bilabonnementhamsa.subscription s on s.subscriptionID = rc.subscriptionID\n" +
                "join bilabonnementhamsa.car ca on ca.carNumberID = rc.carNumberID\n" +
                "join bilabonnementhamsa.location l1 on l1.locationID = rc.pickupLocationID\n" +
                "join bilabonnementhamsa.location l2 on l2.locationID = rc.deliveryLocationID";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(RentalContractView.class));
    }

    public void addRentalContract(RentalContract rentalContract) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.rentalcontract (startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(INSERT_SQL, rentalContract.getStartDate(), rentalContract.getEndDate(), rentalContract.getPrice(), rentalContract.getCustomerID(), rentalContract.getSubscriptionID(),
                rentalContract.getCarNumberID(), rentalContract.getPickupLocationID(), rentalContract.getDeliveryLocationID());
    }

    public void deleteRentalContractBYRentalID(int rentalContractID){
        final String DELETE_SQL ="DELETE FROM bilabonnementhamsa.rentalContract WHERE rentalContractID = ?";
        jdbcTemplate.update(DELETE_SQL, rentalContractID );
    }


    public RentalContract findByID(int rentalContractID) {
        final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.rentalcontract WHERE rentalContractID = ?";
        return jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(RentalContract.class), rentalContractID);
    }

    public void updateByID(RentalContract rentalContract) {
        System.out.println(rentalContract);
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.rentalContract SET startDate = ?, endDate = ?, price = ?, customerID = ?, subscriptionID = ?, carNumberID =?, pickupLocationID = ?, deliveryLocationID = ? WHERE rentalContractID = ?";
        jdbcTemplate.update(UPDATE_SQL, rentalContract.getStartDate(), rentalContract.getEndDate(), rentalContract.getPrice(), rentalContract.getCustomerID(), rentalContract.getSubscriptionID(), rentalContract.getCarNumberID(), rentalContract.getPickupLocationID(), rentalContract.getDeliveryLocationID(), rentalContract.getRentalContractID());
    }

    public List<RentalContractView> getEndedRentalContract() {
        final String SELECT_ENDED_SQL = "SELECT rc.*, c.name customerName, ca.model carModelName, ca.frameNumber carFrameNumber\n" +
                "FROM bilabonnementhamsa.rentalcontract rc\n" +
                "join bilabonnementhamsa.customer c on c.customerId = rc.customerId\n" +
                "join bilabonnementhamsa.car ca on ca.carNumberID = rc.carNumberID\n" +
                "where rc.endDate <= now()\n";
        return jdbcTemplate.query(SELECT_ENDED_SQL, new BeanPropertyRowMapper<>(RentalContractView.class));
    }




}
