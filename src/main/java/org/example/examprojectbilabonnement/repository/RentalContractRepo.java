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
    private JdbcTemplate jdbcTemplate; // Spring leverer automatisk en instans af JdbcTemplate

    // Henter alle lejekontrakter med tilhørende detaljer fra databasen

    public List<RentalContractView> findAll() {
        // SQL-sætning der henter lejekontrakter og joiner med kunder, abonnementer, biler og lokationer
        final String SELECT_SQL = "SELECT rc.*, " +
                "c.name AS customerName, " + // Kunde navn
                "s.name AS subscriptionName, " + // Abonnement navn
                "ca.model AS carModelName, " + // Bil model navn
                "ca.frameNumber AS carFrameNumber, " + // Bilens stelnummer
                "l1.name AS pickupLocationName, " + // Afhentningslokationens navn
                "l2.name AS deliveryLocationName " + // Leveringslokationens navn
                "FROM bilabonnementhamsa.rentalcontract rc " +
                "JOIN bilabonnementhamsa.customer c ON c.customerId = rc.customerId " + // Join med kunde for at få kundeoplysninger
                "JOIN bilabonnementhamsa.subscription s ON s.subscriptionID = rc.subscriptionID " + // Join med abonnement for at få abonnementsoplysninger
                "JOIN bilabonnementhamsa.car ca ON ca.carNumberID = rc.carNumberID " + // Join med bil for at få biloplysninger
                "JOIN bilabonnementhamsa.location l1 ON l1.locationID = rc.pickupLocationID " + // Join med lokation for at få afhentningslokationens oplysninger
                "JOIN bilabonnementhamsa.location l2 ON l2.locationID = rc.deliveryLocationID"; // Join med lokation for at få leveringslokationens oplysninger

        // Udfører SQL-sætningen og mapper resultatet til en liste af RentalContractView objekter
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(RentalContractView.class));
    }


    // Tilføjer en ny lejekontrakt til databasen
    public void addRentalContract(RentalContract rentalContract) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.rentalcontract (startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT_SQL, rentalContract.getStartDate(), rentalContract.getEndDate(), rentalContract.getPrice(),
                rentalContract.getCustomerID(), rentalContract.getSubscriptionID(), rentalContract.getCarNumberID(),
                rentalContract.getPickupLocationID(), rentalContract.getDeliveryLocationID());
    }

    // Sletter en lejekontrakt fra databasen ved hjælp af lejekontraktens ID
    public void deleteRentalContractBYRentalID(int rentalContractID) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.rentalcontract WHERE rentalContractID = ?";
        jdbcTemplate.update(DELETE_SQL, rentalContractID);
    }

    // Finder en lejekontrakt i databasen ved hjælp af lejekontraktens ID
    public RentalContract findByID(int rentalContractID) {
        final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.rentalcontract WHERE rentalContractID = ?";
        return jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(RentalContract.class), rentalContractID);
    }

    // Opdaterer oplysningerne om en lejekontrakt i databasen
    public void updateByID(RentalContract rentalContract) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.rentalcontract SET startDate = ?, endDate = ?, price = ?, customerID = ?, subscriptionID = ?, carNumberID = ?, pickupLocationID = ?, deliveryLocationID = ? WHERE rentalContractID = ?";
        jdbcTemplate.update(UPDATE_SQL, rentalContract.getStartDate(), rentalContract.getEndDate(), rentalContract.getPrice(),
                rentalContract.getCustomerID(), rentalContract.getSubscriptionID(), rentalContract.getCarNumberID(),
                rentalContract.getPickupLocationID(), rentalContract.getDeliveryLocationID(), rentalContract.getRentalContractID());
    }

    // Henter alle afsluttede lejekontrakter med tilhørende detaljer fra databasen
    public List<RentalContractView> getEndedRentalContract() {
        // SQL-sætning der henter afsluttede lejekontrakter og joiner med kunder og biler
        final String SELECT_ENDED_SQL = "SELECT rc.*, " +
                "c.name AS customerName, " + // Kunde navn
                "ca.model AS carModelName, " + // Bil model navn
                "ca.frameNumber AS carFrameNumber " + // Bilens stelnummer
                "FROM bilabonnementhamsa.rentalcontract rc " +
                "JOIN bilabonnementhamsa.customer c ON c.customerId = rc.customerId " + // Join med kunde for at få kundeoplysninger
                "JOIN bilabonnementhamsa.car ca ON ca.carNumberID = rc.carNumberID " + // Join med bil for at få biloplysninger
                "WHERE rc.endDate <= NOW() AND rc.purchaseOptional IS NULL"; // Filtrerer for at få afsluttede lejekontrakter uden købsoption

        // Udfører SQL-sætningen og mapper resultatet til en liste af RentalContractView objekter
        return jdbcTemplate.query(SELECT_ENDED_SQL, new BeanPropertyRowMapper<>(RentalContractView.class));
    }

    // Opdaterer købsmulighedsstatussen for en lejekontrakt i databasen
    public void updatePurchaseOptionalStatus(int rentalContractID, int purchaseOptional) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.rentalcontract SET purchaseOptional = ? WHERE rentalContractID = ?";
        jdbcTemplate.update(UPDATE_SQL, purchaseOptional, rentalContractID);
    }
}

