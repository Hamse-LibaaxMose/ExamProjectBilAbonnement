package org.example.examprojectbilabonnement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String indexHomePage(){
        return "Homepage";
    }
    @GetMapping("/showDataPage")
    public String showDataPage() {
        return "DataRegistration";
    }
}
