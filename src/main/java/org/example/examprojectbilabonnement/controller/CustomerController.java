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
    CustomerService customerService; // Automatisk injektion af CustomerService

    @GetMapping("/manageCustomerRegistration")
    public String manageCustomer(Model model) {
        // Tilføjer listen af kunder til modellen
        model.addAttribute("customerList", customerService.findAll());
        return "ManageCustomerRegistration"; // Returnerer navnet på visningen
    }

    @GetMapping("/showAddCustomerPage")
    public String showAddCustomerPage() {
        return "AddCustomer"; // Returnerer navnet på siden for at tilføje en kunde
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam("name") String name, @RequestParam("adress") String adress, @RequestParam("mail") String mail, @RequestParam("phoneNumber") String phoneNumber) {
        Customer customer = new Customer(name, adress, mail, phoneNumber); // Opretter en ny kunde
        customerService.addCustomer(customer); // Tilføjer kunden til systemet
        return "redirect:/manageCustomerRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("deleteCustomer/{customerID}")
    public String deleteCustomer(@PathVariable("customerID") int customerID) {
        customerService.deleteCustomer(customerID); // Sletter kunden med det givne ID
        return "redirect:/manageCustomerRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/showCustomerUpdatePage/{customerID}")
    public String showUpdatePage(@PathVariable("customerID") int customerID, Model model) {
        // Tilføjer kunden til modellen for opdateringssiden
        model.addAttribute("customer", customerService.findByID(customerID));
        return "UpdateCustomer"; // Returnerer navnet på opdateringssiden
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerID") int customerID,
                                 @RequestParam("name") String name,
                                 @RequestParam("adress") String adress,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("phoneNumber") String phoneNumber) {

        Customer customer = new Customer(customerID, name, adress, mail, phoneNumber); // Opretter en kunde med opdaterede oplysninger
        customerService.updateCustomer(customer); // Opdaterer kunden i systemet
        return "redirect:/manageCustomerRegistration"; // Omdirigerer til administrationssiden
    }
}
