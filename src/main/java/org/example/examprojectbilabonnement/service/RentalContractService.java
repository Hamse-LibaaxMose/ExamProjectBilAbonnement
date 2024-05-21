package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Location;
import org.example.examprojectbilabonnement.model.RentalContract;
import org.example.examprojectbilabonnement.model.RentalContractView;
import org.example.examprojectbilabonnement.repository.RentalContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalContractService {
    @Autowired
    RentalContractRepo rentalContractRepo;

    public List<RentalContractView> findAll() {
        return rentalContractRepo.findAll();
    }

    public void addRentalContract(RentalContract rentalContract) {
        rentalContractRepo.addRentalContract(rentalContract);
    }

    public RentalContract findByID(int rentalContractID) {
        return rentalContractRepo.findByID(rentalContractID);
    }

    public void updateRentalContract(RentalContract rentalContract) {
        rentalContractRepo.updateByID(rentalContract);
    }

}
