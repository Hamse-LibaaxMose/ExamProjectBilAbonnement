package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DamageReportController {
    @Autowired
    DamageReportService damageReportService;

    @GetMapping("/damageReportRegistration")
    public String manageDamageReport(Model model){
        model.addAttribute("damageReportList", damageReportService.findAll());
        return "ManageDamageReportRegistration";
    }

    @GetMapping ("/showAddDamage&Repair")
    public String showAddDamage_Repair(){
        return "AddDamage&Repair";
    }

    @PostMapping("/addDamage&Repair")
    public String addDamageRepair(@RequestParam("exceedKm") int exceedkm){
        return"";
    }


}
