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
    PurchaseAgreementService purchaseAgreementService; // Brug en instans af PurchaseAgreementService til at håndtere købsaftale-operationer

    @Autowired
    RentalContractService rentalContractService; // Brug en instans af RentalContractService til at håndtere lejekontrakt-operationer

    @Autowired
    DamageTypeService damageTypeService; // Brug en instans af DamageTypeService til at håndtere skadestype-operationer

    @GetMapping("/showPurchaseAgreement")
    public String managePurchaseAgreement(Model model) {
        // Tilføjer listen af afsluttede lejekontrakter til modellen
        model.addAttribute("endedRentalContractList", rentalContractService.getEndedRentalContract());
        return "PurchaseAgreementManagement"; // Returnerer navnet på visningen
    }

    @GetMapping("/closeContract/{rentalContractID}")
    public String closeContract(@PathVariable("rentalContractID") int rentalContractID) {
        rentalContractService.updatePurchaseOptionalStatus(rentalContractID, 0); // Opdaterer status til ikke købbar
        return "redirect:/showPurchaseAgreement"; // Omdirigerer til købsoversigten
    }

    @GetMapping("/managePurchaseAgreement/{customerID}/{rentalContractID}")
    public String showPurchaseAgreement(@PathVariable("customerID") int customerID,
                                        @PathVariable("rentalContractID") int rentalContractID, Model model) {
        int purchaseAgreementID = purchaseAgreementService.getPurchaseAgreementByRentalContractId(rentalContractID);
        if (purchaseAgreementID == 0)
            purchaseAgreementID = purchaseAgreementService.addPurchaseAgreement(customerID, rentalContractID); // Tilføjer en ny købsaftale hvis den ikke eksisterer
        model.addAttribute("purchaseAgreementID", purchaseAgreementID);
        model.addAttribute("rentalContractID", rentalContractID);
        model.addAttribute("damageTypeList", damageTypeService.findAll()); // Tilføjer listen af skadestyper til modellen
        model.addAttribute("purchaseAgreementDamageTypeList",
                purchaseAgreementService.getAllPurchaseAgreementDamageByPurchaseAgreementID(purchaseAgreementID)); // Tilføjer listen af skadestyper tilhørende købsaftalen
        return "ManagePurchaseAgreement"; // Returnerer navnet på siden til håndtering af købsaftalen
    }

    @GetMapping("/manageDisplayPurchaseAgreement/{purchaseAgreementID}/{rentalContractID}")
    public String showDisplayPurchaseAgreement(@PathVariable("purchaseAgreementID") int purchaseAgreementID,
                                               @PathVariable("rentalContractID") int rentalContractID, Model model) {
        model.addAttribute("purchaseAgreementID", purchaseAgreementID);
        model.addAttribute("rentalContractID", rentalContractID);
        model.addAttribute("damageTypeList", damageTypeService.findAll()); // Tilføjer listen af skadestyper til modellen
        model.addAttribute("purchaseAgreementDamageTypeList",
                purchaseAgreementService.getAllPurchaseAgreementDamageByPurchaseAgreementID(purchaseAgreementID)); // Tilføjer listen af skadestyper tilhørende købsaftalen
        return "ManagePurchaseAgreement"; // Returnerer navnet på siden til visning af købsaftalen
    }

    @GetMapping("/deleteDamageTypeFromPurchaseAgreement/{purchaseAgreementDamageTypeID}/{purchaseAgreementID}/{rentalContractID}")
    public String deleteLocation(@PathVariable("purchaseAgreementDamageTypeID") int purchaseAgreementDamageTypeID,
                                 @PathVariable("purchaseAgreementID") int purchaseAgreementID,
                                 @PathVariable("rentalContractID") int rentalContractID) {
        purchaseAgreementService.deletePurchaseAgreementDamageType(purchaseAgreementDamageTypeID); // Sletter skadestypen fra købsaftalen
        return "redirect:/manageDisplayPurchaseAgreement/" + purchaseAgreementID + '/' + rentalContractID; // Omdirigerer til visningen af købsaftalen
    }

    @PostMapping("/addDamageTypeToPurchaseAgreement")
    public String addDamageTypeToPurchaseAgreement(@RequestParam("purchaseAgreementID") int purchaseAgreementID,
                                                   @RequestParam("damageTypeID") int damageTypeID,
                                                   @RequestParam("rentalContractID") int rentalContractID) {
        purchaseAgreementService.addDamageTypeToPurchaseAgreement(purchaseAgreementID, damageTypeID); // Tilføjer skadestypen til købsaftalen
        return "redirect:/manageDisplayPurchaseAgreement/" + purchaseAgreementID + '/' + rentalContractID; // Omdirigerer til visningen af købsaftalen
    }

    @PostMapping("/confirmPurchaseAgreement")
    public String confirmPurchaseAgreement(@RequestParam("purchaseAgreementID") int purchaseAgreementID,
                                           @RequestParam("rentalContractID") int rentalContractID,
                                           @RequestParam("exceedKm") int exceedKm) {
        purchaseAgreementService.updateExceedKmByPurchaseAgreementID(exceedKm, purchaseAgreementID); // Opdaterer antallet af overskredne kilometer
        rentalContractService.updatePurchaseOptionalStatus(rentalContractID, 1); // Opdaterer status til købbar
        return "redirect:/showPurchaseAgreement"; // Omdirigerer til købsoversigten
    }
}
