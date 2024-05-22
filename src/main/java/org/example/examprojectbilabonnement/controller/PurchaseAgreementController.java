package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.service.PurchaseAgreementService;
import org.example.examprojectbilabonnement.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseAgreementController {
    @Autowired
    PurchaseAgreementService purchaseAgreementService;

    @Autowired
    RentalContractService rentalContractService;

    @GetMapping("/managePurchaseAgreement")
    public String managePurchaseAgreement(Model model) {
       model.addAttribute("endedRentalContractList", rentalContractService.getEndedRentalContract());
        return "PurchaseAgreementManagement";
    }

}
