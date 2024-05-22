package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class PurchaseAgreementRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addPurchaseAgreement(int CustomerID) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.purchaseagreement(customerId) VALUES(?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, CustomerID);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}
