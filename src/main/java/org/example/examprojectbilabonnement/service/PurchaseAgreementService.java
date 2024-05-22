package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.repository.PurchaseAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseAgreementService {
    @Autowired
    PurchaseAgreementRepo purchaseAgreementRepo;


    public int addPurchaseAgreement(int customerID){
        return purchaseAgreementRepo.addPurchaseAgreement(customerID);
    }
}
