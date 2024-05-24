package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Location;
import org.example.examprojectbilabonnement.model.PurchaseAgrementDamage;
import org.example.examprojectbilabonnement.model.RentalContractView;
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
    private JdbcTemplate jdbcTemplate;

    public int addPurchaseAgreement(int CustomerID, int rentalContractID) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.purchaseagreement(customerId, rentalContractID) VALUES(?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, CustomerID);
            ps.setInt(2, rentalContractID);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<PurchaseAgrementDamage> getAllPurchaseAgreementDamageByPurchaseAgreementID(int purchaseAgreementID){
        final String SELECT_SQL = "SELECT pd.purchaseAgreement_damageTypeID,pd.purchaseAgreementID,d.name,d.price \n" +
                "FROM bilabonnementhamsa.purchaseagreement_damagetype pd\n" +
                "join damagetype d on d.damageTypeID = pd.damageTypeID\n" +
                "where pd.purchaseAgreementID = ?";
       return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(PurchaseAgrementDamage.class), purchaseAgreementID);
    }

    public void deletePurchaseAgreementDamageType(int purchaseAgreementDamageTypeID) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.purchaseagreement_damagetype WHERE purchaseAgreement_damageTypeID = ?";
        jdbcTemplate.update(DELETE_SQL, purchaseAgreementDamageTypeID);
    }

    public void addDamageTypeToPurchaseAgreement(int purchaseAgreementID, int damageTypeID) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.purchaseagreement_damagetype (purchaseAgreementID, damageTypeID) VALUES (?, ?)";
        jdbcTemplate.update(INSERT_SQL, purchaseAgreementID, damageTypeID);
    }

    public int getPurchaseAgreementByRentalContractId(int rentalContractID){
        try {
            final String SELECT_SQL = "SELECT purchaseAgreementID FROM bilabonnementhamsa.purchaseagreement WHERE rentalcontractID = ?";
            return jdbcTemplate.queryForObject(SELECT_SQL, Integer.class, rentalContractID);
        }catch(EmptyResultDataAccessException ex){
            return 0;
        }
    }

    public void updateExceedKmByPurchaseAgreementID(int exccedKm, int purchaseAgreementID){
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.purchaseagreement SET exceedKm = ? where purchaseagreementId = ?;";
        jdbcTemplate.update(UPDATE_SQL, exccedKm, purchaseAgreementID);
    }
}
