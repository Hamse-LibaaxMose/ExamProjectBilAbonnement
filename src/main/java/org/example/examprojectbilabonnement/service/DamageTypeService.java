package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.DamageType;
import org.example.examprojectbilabonnement.repository.DamageTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DamageTypeService {
    @Autowired
    private DamageTypeRepo damageTypeRepo;

    public List<DamageType> findAll() {
        return damageTypeRepo.findAll();
    }

    public DamageType findById(int damageTypeId) {
        return damageTypeRepo.findById(damageTypeId);
    }

    public void addDamageType(DamageType damageType) {
        damageTypeRepo.addDamageType(damageType);
    }

    public void updateDamageType(DamageType damageType) {
        damageTypeRepo.updateDamageType(damageType);
    }

    public void deleteDamageType(int damageTypeId) {
        damageTypeRepo.deleteDamageTypeById(damageTypeId);
    }
}