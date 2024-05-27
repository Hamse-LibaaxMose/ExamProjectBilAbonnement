package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.DamageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DamageTypeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate; // Spring leverer automatisk en instans af JdbcTemplate

    // Henter alle skadestyper fra databasen
    public List<DamageType> findAll() {
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.damagetype";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(DamageType.class));
    }

    // Tilføjer en ny skadestype til databasen
    public void addDamageType(DamageType damageType) {
        final String INSERT_SQL = "INSERT INTO bilabonnementhamsa.damagetype (name, price) VALUES (?, ?)";
        jdbcTemplate.update(INSERT_SQL, damageType.getName(), damageType.getPrice());
    }

    // Sletter en skadestype fra databasen ved hjælp af skadestypens ID
    public void deleteDamageTypeById(int damageTypeId) {
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.damagetype WHERE damageTypeID = ?";
        jdbcTemplate.update(DELETE_SQL, damageTypeId);
    }

    // Finder en skadestype i databasen ved hjælp af skadestypens ID
    public DamageType findById(int damageTypeId) {
        final String SELECT_BY_ID_SQL = "SELECT * FROM bilabonnementhamsa.damagetype WHERE damageTypeID = ?";
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new BeanPropertyRowMapper<>(DamageType.class), damageTypeId);
    }

    // Opdaterer oplysningerne om en skadestype i databasen
    public void updateDamageType(DamageType damageType) {
        final String UPDATE_SQL = "UPDATE bilabonnementhamsa.damagetype SET name = ?, price = ? WHERE damageTypeID = ?";
        jdbcTemplate.update(UPDATE_SQL, damageType.getName(), damageType.getPrice(), damageType.getDamageTypeID());
    }
}

