package org.example.examprojectbilabonnement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseAgreementRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
