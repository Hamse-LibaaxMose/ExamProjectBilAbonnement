package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.DamageType;
import org.example.examprojectbilabonnement.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DamageTypeController {

    @Autowired
    private DamageTypeService damageTypeService; // Spring leverer automatisk en instans af DamageTypeService

    @GetMapping("/manageDamageTypeRegistration")
    public String manageDamageType(Model model) {
        // Tilføjer listen af skadestyper til modellen
        model.addAttribute("damageTypeList", damageTypeService.findAll());
        return "ManageDamageTypeRegistration"; // Returnerer navnet på visningen
    }

    @GetMapping("/showAddDamageTypePage")
    public String showAddDamageTypePage() {
        return "AddDamageType"; // Returnerer navnet på siden for at tilføje en skadestype
    }

    @PostMapping("/addDamageType")
    public String addDamageType(@RequestParam("name") String name, @RequestParam("price") int price) {
        DamageType damageType = new DamageType(name, price); // Opretter en ny skadestype
        damageTypeService.addDamageType(damageType); // Tilføjer skadestypen til systemet
        return "redirect:/manageDamageTypeRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/showDamageTypeUpdatePage/{damageTypeID}")
    public String showDamageTypeUpdatePage(@PathVariable("damageTypeID") int damageTypeID , Model model) {
        DamageType damageType = damageTypeService.findById(damageTypeID); // Finder skadestypen ved ID
        model.addAttribute("damageType", damageType); // Tilføjer skadestypen til modellen
        return "UpdateDamageType"; // Returnerer navnet på opdateringssiden
    }

    @PostMapping("/updateDamageType")
    public String updateDamageType(@RequestParam("damageTypeID") int damageTypeID,
                                   @RequestParam("name") String name,
                                   @RequestParam("price") int price) {
        DamageType damageType = new DamageType(damageTypeID, name, price); // Opretter en skadestype med opdaterede oplysninger
        damageTypeService.updateDamageType(damageType); // Opdaterer skadestypen i systemet
        return "redirect:/manageDamageTypeRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/deleteDamageType/{damageTypeID}")
    public String deleteDamageType(@PathVariable("damageTypeID") int damageTypeID) {
        damageTypeService.deleteDamageType(damageTypeID); // Sletter skadestypen med det givne ID
        return "redirect:/manageDamageTypeRegistration"; // Omdirigerer til administrationssiden
    }
}


