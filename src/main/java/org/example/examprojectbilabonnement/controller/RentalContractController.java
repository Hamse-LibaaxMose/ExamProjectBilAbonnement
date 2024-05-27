package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.model.RentalContract;
import org.example.examprojectbilabonnement.service.CarService;
import org.example.examprojectbilabonnement.service.CustomerService;
import org.example.examprojectbilabonnement.service.LocationService;
import org.example.examprojectbilabonnement.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RentalContractController {

    @Autowired
    RentalContractService rentalContractService; // Spring leverer automatisk en instans af RentalContractService

    @Autowired
    CustomerService customerService; // Spring leverer automatisk en instans af CustomerService

    @Autowired
    CarService carService; // Spring leverer automatisk en instans af CarService

    @Autowired
    LocationService locationService; // Spring leverer automatisk en instans af LocationService

    @GetMapping("/manageRentalContractRegistration")
    public String manageCustomer(Model model) {
        // Tilføjer listen af lejekontrakter til modellen
        model.addAttribute("contractList", rentalContractService.findAll());
        return "ManageRentalContractRegistration"; // Returnerer navnet på visningen
    }

    @GetMapping("/showRentalContractPage")
    public String showAddRentalContractPage(Model model) {
        // Tilføjer nødvendige lister til modellen for oprettelse af en lejekontrakt
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("locationList", locationService.findAll());
        return "AddRentalContract"; // Returnerer navnet på siden for at tilføje en lejekontrakt
    }

    @PostMapping("/addRentalContract")
    public String addRentalContract(@RequestParam("startDate") String startDate,
                                    @RequestParam("endDate") String endDate,
                                    @RequestParam("price") int price,
                                    @RequestParam("customerID") int customerID,
                                    @RequestParam("subscriptionID") int subscriptionID,
                                    @RequestParam("carNumberID") int carNumberID,
                                    @RequestParam("pickupLocationID") int pickupLocationID,
                                    @RequestParam("deliveryLocationID") int deliveryLocationID) {
        // Opretter en ny lejekontrakt
        RentalContract rentalContract = new RentalContract(startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID);
        rentalContractService.addRentalContract(rentalContract); // Tilføjer lejekontrakten til systemet
        return "redirect:/manageRentalContractRegistration"; // Omdirigerer til administrationssiden for lejekontrakter
    }

    @GetMapping("deleteRentalContract/{rentalContractID}")
    public String deleteRentalContract(@PathVariable("rentalContractID") int rentalContractID) {
        rentalContractService.deleteRentalContract(rentalContractID); // Sletter lejekontrakten med det givne ID
        return "redirect:/manageRentalContractRegistration"; // Omdirigerer til administrationssiden for lejekontrakter
    }

    @GetMapping("/showRentalContractUpdatePage/{rentalContractID}")
    public String showUpdatePage(@PathVariable("rentalContractID") int rentalContractID, Model model) {
        // Tilføjer lejekontrakten og nødvendige lister til modellen for opdateringssiden
        model.addAttribute("rentalContract", rentalContractService.findByID(rentalContractID));
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("locationList", locationService.findAll());
        return "UpdateRentalContract"; // Returnerer navnet på opdateringssiden for lejekontrakter
    }

    @PostMapping("/updateRentalContract")
    public String updateRentalContract(@RequestParam("rentalContractID") int rentalContractID,
                                       @RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate,
                                       @RequestParam("price") int price,
                                       @RequestParam("customerID") int customerID,
                                       @RequestParam("subscriptionID") int subscriptionID,
                                       @RequestParam("carNumberID") int carNumberID,
                                       @RequestParam("pickupLocationID") int pickupLocationID,
                                       @RequestParam("deliveryLocationID") int deliveryLocationID) {
        // Opretter en lejekontrakt med opdaterede oplysninger
        RentalContract rentalContract = new RentalContract(rentalContractID, startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID);
        rentalContractService.updateRentalContract(rentalContract); // Opdaterer lejekontrakten i systemet
        return "redirect:/manageRentalContractRegistration"; // Omdirigerer til administrationssiden for lejekontrakter
    }
}




