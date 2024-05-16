package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("AddCustomer")
        public String addCustomer () {
            return "";
        }
    }



