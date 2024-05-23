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
    private DamageTypeService damageTypeService;

    @GetMapping("/manageDamageTypeRegistration")
    public String manageDamageType(Model model) {
        model.addAttribute("damageTypeList", damageTypeService.findAll());
        return "ManageDamageTypeRegistration";
    }

    @GetMapping("/showAddDamageTypePage")
    public String showAddDamageTypePage() {
        return "AddDamageType";
    }

    @PostMapping("/addDamageType")
    public String addDamageType(@RequestParam("name") String name, @RequestParam("price") int price) {
        DamageType damageType = new DamageType(name, price);
        damageTypeService.addDamageType(damageType);
        return "redirect:/manageDamageTypeRegistration";
    }

    @GetMapping("/showDamageTypeUpdatePage/{damageTypeID}")
    public String showDamageTypeUpdatePage(@PathVariable("damageTypeID") int damageTypeID , Model model) {
        DamageType damageType = damageTypeService.findById(damageTypeID);
        model.addAttribute("damageType", damageType);
        return "UpdateDamageType";
    }

    @PostMapping("/updateDamageType")
    public String updateDamageType(@RequestParam("damageTypeID") int damageTypeID, @RequestParam("name") String name, @RequestParam("price") int price) {
        DamageType damageType = new DamageType(damageTypeID, name, price);
        damageTypeService.updateDamageType(damageType);
        return "redirect:/manageDamageTypeRegistration";
    }

    @GetMapping("/deleteDamageType/{damageTypeID}")
    public String deleteDamageType(@PathVariable("damageTypeID") int damageTypeID) {
        damageTypeService.deleteDamageType(damageTypeID);
        return "redirect:/manageDamageTypeRegistration";
    }
}

