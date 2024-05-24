package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.service.DamageTypeService;
import org.example.examprojectbilabonnement.service.PurchaseAgreementService;
import org.example.examprojectbilabonnement.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseAgreementController {
    @Autowired
    PurchaseAgreementService purchaseAgreementService;

    @Autowired
    RentalContractService rentalContractService;

    @Autowired
    DamageTypeService damageTypeService;

    @GetMapping("/showPurchaseAgreement")
    public String managePurchaseAgreement(Model model) {
        model.addAttribute("endedRentalContractList", rentalContractService.getEndedRentalContract());
        return "PurchaseAgreementManagement";
    }

    @GetMapping("/closeContract/{rentalContractID}")
    public String closeContract(@PathVariable("rentalContractID") int rentalContractID) {
        rentalContractService.updatePurchaseOptionalStatus(rentalContractID, 0);
        return "redirect:/showPurchaseAgreement";
    }

    @GetMapping("/managePurchaseAgreement/{customerID}/{rentalContractID}")
    public String showPurchaseAgreement(@PathVariable("customerID") int customerID,
                                        @PathVariable("rentalContractID") int rentalContractID, Model model) {
        int purchaseAgreementID = purchaseAgreementService.getPurchaseAgreementByRentalContractId(rentalContractID);
        if (purchaseAgreementID == 0)
            purchaseAgreementID = purchaseAgreementService.addPurchaseAgreement(customerID, rentalContractID);
        model.addAttribute("purchaseAgreementID", purchaseAgreementID);
        model.addAttribute("rentalContractID", rentalContractID);
        model.addAttribute("damageTypeList", damageTypeService.findAll());
        model.addAttribute("purchaseAgreementDamageTypeList",
                purchaseAgreementService.getAllPurchaseAgreementDamageByPurchaseAgreementID(purchaseAgreementID));
        return "ManagePurchaseAgreement";
    }

    @GetMapping("/manageDisplayPurchaseAgreement/{purchaseAgreementID}/{rentalContractID}")
    public String showDisplayPurchaseAgreement(@PathVariable("purchaseAgreementID") int purchaseAgreementID,
                                               @PathVariable("rentalContractID") int rentalContractID, Model model) {
        model.addAttribute("purchaseAgreementID", purchaseAgreementID);
        model.addAttribute("rentalContractID", rentalContractID);
        model.addAttribute("damageTypeList", damageTypeService.findAll());
        model.addAttribute("purchaseAgreementDamageTypeList",
                purchaseAgreementService.getAllPurchaseAgreementDamageByPurchaseAgreementID(purchaseAgreementID));
        return "ManagePurchaseAgreement";
    }

    @GetMapping("/deleteDamageTypeFromPurchaseAgreement/{purchaseAgreementDamageTypeID}/{purchaseAgreementID}/{rentalContractID}")
    public String deleteLocation(@PathVariable("purchaseAgreementDamageTypeID") int purchaseAgreementDamageTypeID,
                                 @PathVariable("purchaseAgreementID") int purchaseAgreementID,
                                 @PathVariable("rentalContractID") int rentalContractID) {
        purchaseAgreementService.deletePurchaseAgreementDamageType(purchaseAgreementDamageTypeID);
        return "redirect:/manageDisplayPurchaseAgreement/" + purchaseAgreementID + '/' + rentalContractID;
    }

    @PostMapping("/addDamageTypeToPurchaseAgreement")
    public String addDamageTypeToPurchaseAgreement(@RequestParam("purchaseAgreementID") int purchaseAgreementID,
                                                   @RequestParam("damageTypeID") int damageTypeID,
                                                   @RequestParam("rentalContractID") int rentalContractID) {
        purchaseAgreementService.addDamageTypeToPurchaseAgreement(purchaseAgreementID, damageTypeID);
        return "redirect:/manageDisplayPurchaseAgreement/" + purchaseAgreementID + '/' + rentalContractID;
    }

    @PostMapping("/confirmPurchaseAgreement")
    public String confirmPurchaseAgreement(@RequestParam("purchaseAgreementID") int purchaseAgreementID,
                                           @RequestParam("rentalContractID") int rentalContractID,
                                           @RequestParam("exceedKm") int exceedKm) {
        purchaseAgreementService.updateExceedKmByPurchaseAgreementID(exceedKm , purchaseAgreementID);
        rentalContractService.updatePurchaseOptionalStatus(rentalContractID, 1);
        return "redirect:/showPurchaseAgreement";
    }


}
