package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.DamageReport;
import org.example.examprojectbilabonnement.repository.DamageReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageReportService {
    @Autowired
    DamageReportRepo damageReportRepo;

    public List<DamageReport> findAll(){
        return damageReportRepo.findAll();
    }
    public void addDamageReport(DamageReport damageReport){
        damageReportRepo.addDamageReport(damageReport);
    }

    public void deleteDamageReport(int damageReportID){
        damageReportRepo.deleteDamageReportByDamageReportID(damageReportID);
    }

  //  public DamageReport findByID(int damageReport)

}
