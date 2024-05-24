package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.PurchaseAgrementDamage;
import org.example.examprojectbilabonnement.repository.PurchaseAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseAgreementService {
    @Autowired
    PurchaseAgreementRepo purchaseAgreementRepo;


    public int addPurchaseAgreement(int customerID, int rentalContractID){
        return purchaseAgreementRepo.addPurchaseAgreement(customerID, rentalContractID);
    }

    public List<PurchaseAgrementDamage> getAllPurchaseAgreementDamageByPurchaseAgreementID(int purchaseAgreementID) {
        return purchaseAgreementRepo.getAllPurchaseAgreementDamageByPurchaseAgreementID(purchaseAgreementID);
    }

    public void deletePurchaseAgreementDamageType(int purchaseAgreementDamageTypeID) {
        purchaseAgreementRepo.deletePurchaseAgreementDamageType(purchaseAgreementDamageTypeID);
    }

    public void addDamageTypeToPurchaseAgreement(int purchaseAgreementID, int damageTypeID) {
        purchaseAgreementRepo.addDamageTypeToPurchaseAgreement( purchaseAgreementID, damageTypeID);
    }

    public int getPurchaseAgreementByRentalContractId(int rentalContractID){
        return purchaseAgreementRepo.getPurchaseAgreementByRentalContractId(rentalContractID);
    }

    public void updateExceedKmByPurchaseAgreementID(int exccedKm, int purchaseAgreementID){
        purchaseAgreementRepo.updateExceedKmByPurchaseAgreementID(exccedKm, purchaseAgreementID);
    }
}
