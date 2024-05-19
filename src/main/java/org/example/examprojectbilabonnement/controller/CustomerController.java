package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Customer;
import org.example.examprojectbilabonnement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/manageCustomerRegistration")
    public String manageCustomer(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "ManageCustomerRegistration";
    }

    @GetMapping("/showAddCustomerPage")
    public String showAddCustomerPage() {
        return "AddCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam("name") String name, @RequestParam("adress") String adress, @RequestParam("mail") String mail, @RequestParam("phoneNumber") String phoneNumber) {
        Customer customer = new Customer(name, adress, mail, phoneNumber);
        customerService.addCustomer(customer);
        return "redirect:/manageCustomerRegistration";
    }
    @GetMapping("deleteCustomer/{customerID}")
public String deleteCustomer(@PathVariable("customerID") int customerID) {
        customerService.deleteCustomer(customerID);
        return "redirect:/manageCustomerRegistration";
    }
}





