package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.PurchaseAgrementDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PurchaseAgreementRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Spring leverer automatisk en instans af JdbcTemplate

    // Tilføjer en ny købsaftale til databasen og returnerer det genererede ID
    public int addPurchaseAgreement(int customerID, int rentalContractID) { // denne metode er taget fra chat gpt
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.purchaseagreement(customerId, rentalContractID) VALUES(?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerID);
            ps.setInt(2, rentalContractID);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    // Henter alle skadetyper tilknyttet en købsaftale fra databasen
    public List<PurchaseAgrementDamage> getAllPurchaseAgreementDamageByPurchaseAgreementID(int purchaseAgreementID) {
        final String SELECT_SQL = "SELECT pd.purchaseAgreement_damageTypeID, pd.purchaseAgreementID, d.name, d.price " +
                "FROM bilabonnementhamsa.purchaseagreement_damagetype pd " +
                "JOIN damagetype d ON d.damageTypeID = pd.damageTypeID " +
                "WHERE pd.purchaseAgreementID = ?";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(PurchaseAgrementDamage.class), purchaseAgreementID);
    }

    // Sletter en skadestype fra en købsaftale i databasen ved hjælp af ID
    public void deletePurchaseAgreementDamageType(int purchaseAgreementDamageTypeID) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.purchaseagreement_damagetype WHERE purchaseAgreement_damageTypeID = ?";
        jdbcTemplate.update(DELETE_SQL, purchaseAgreementDamageTypeID);
    }

    // Tilføjer en skadestype til en købsaftale i databasen
    public void addDamageTypeToPurchaseAgreement(int purchaseAgreementID, int damageTypeID) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.purchaseagreement_damagetype (purchaseAgreementID, damageTypeID) VALUES (?, ?)";
        jdbcTemplate.update(INSERT_SQL, purchaseAgreementID, damageTypeID);
    }

    // Henter en købsaftale ved hjælp af lejekontraktens ID
    public int getPurchaseAgreementByRentalContractId(int rentalContractID) {
        try {
            final String SELECT_SQL = "SELECT purchaseAgreementID FROM bilabonnementhamsa.purchaseagreement WHERE rentalContractID = ?";
            return jdbcTemplate.queryForObject(SELECT_SQL, Integer.class, rentalContractID);
        } catch (EmptyResultDataAccessException ex) {
            return 0; // Returnerer 0 hvis ingen købsaftale findes
        }
    }

    // Opdaterer antallet af overskredne kilometer i en købsaftale
    public void updateExceedKmByPurchaseAgreementID(int exceedKm, int purchaseAgreementID) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.purchaseagreement SET exceedKm = ? WHERE purchaseAgreementID = ?";
        jdbcTemplate.update(UPDATE_SQL, exceedKm, purchaseAgreementID);
    }
}
