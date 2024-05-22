package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.service.PurchaseAgreementService;
import org.example.examprojectbilabonnement.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PurchaseAgreementController {
    @Autowired
    PurchaseAgreementService purchaseAgreementService;

    @Autowired
    RentalContractService rentalContractService;

    @GetMapping("/showPurchaseAgreement")
    public String managePurchaseAgreement(Model model) {
       model.addAttribute("endedRentalContractList", rentalContractService.getEndedRentalContract());
        return "PurchaseAgreementManagement";
    }

    @GetMapping("/managePurchaseAgreement/{customerID}")
    public String showPurchaseAgreement(@PathVariable("customerID") int customerID,Model model) {
        var purchaseAgreementID = purchaseAgreementService.addPurchaseAgreement(customerID);
        model.addAttribute("purchaseAgreementID", purchaseAgreementID);
        return "ManagePurchaseAgreement";
    }

}
