package org.example.examprojectbilabonnement.repository;

import org.example.examprojectbilabonnement.model.DamageReport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DamageReportRepo {
    private JdbcTemplate jdbcTemplate;

    public List<DamageReport> findAll(){
        final String SELECT_SQL = "SELECT * FROM bilabonnementhamsa.damageReport";
        return jdbcTemplate.query(SELECT_SQL, new BeanPropertyRowMapper<>(DamageReport.class));
    }

    public void addDamageReport(DamageReport damageReport){
        final String INSERT_SQL ="INSERT INTO bilabonnementhamsa.damage";
        jdbcTemplate.update(INSERT_SQL, damageReport.getExceedKm());
    }

    public void deleteDamageReportByDamageReportID(int damageReportID ){
        final String DELETE_SQL = "DELETE FROM bilabonnementhamsa.damageReport where damageReportID = ?";
        jdbcTemplate.update(DELETE_SQL, damageReportID );

        public DamageReport findByID(int damageReportID){
            final String SELECT_BYID_SQL = "SELECT * FROM bilabonnementhamsa.damageReport where damageReportID = ?";
            jdbcTemplate.queryForObject(SELECT_BYID_SQL, new BeanPropertyRowMapper<>(DamageReport.class), damageReportID);
        }

        public void updateByID(DamageReport damageReport){
            final String UPDATE_SQL ="SELECT * FROM bilabonnement.damageReport SET model = ? WHERE damageReportID = ?";
            jdbcTemplate.update(updateByID, damage)
        }


    }
}
