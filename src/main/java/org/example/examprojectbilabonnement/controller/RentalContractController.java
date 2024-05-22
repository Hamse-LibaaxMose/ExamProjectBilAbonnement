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
    RentalContractService rentalContractService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    LocationService locationService;

    @GetMapping("/manageRentalContractRegistration")
    public String manageCustomer(Model model) {
        model.addAttribute("contractList", rentalContractService.findAll());
        return "ManageRentalContractRegistration";
    }

    @GetMapping("/showRentalContractPage")
    public String showAddRentalContractPage(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("locationList", locationService.findAll());
        return "AddRentalContract";
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
        RentalContract rentalContract = new RentalContract(startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID);
        rentalContractService.addRentalContract(rentalContract);
        return "redirect:/manageRentalContractRegistration";
    }

    @GetMapping("deleteRentalContract/{rentalContractID}")
    public String deleteRentalContract(@PathVariable("rentalContractID") int rentalContractID){
        rentalContractService.deleteRentalContract(rentalContractID);
        return "redirect:/manageRentalContractRegistration";
    }



    @GetMapping("/showRentalContractUpdatePage/{rentalContractID}")
    public String showUpdatePage(@PathVariable("rentalContractID") int rentalContractID, Model model) {
        model.addAttribute("rentalContract", rentalContractService.findByID(rentalContractID));
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("locationList", locationService.findAll());
        return "UpdateRentalContract";
    }

    @PostMapping("/updateRentalContract")
    public String updateRentalContract(@RequestParam("rentalContractID") int rentalContractID,
                                       @RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate, @RequestParam("price") int price,
                                       @RequestParam("customerID") int customerID,
                                       @RequestParam("subscriptionID") int subscriptionID,
                                       @RequestParam("carNumberID") int carNumberID,
                                       @RequestParam("pickupLocationID") int pickupLocationID,
                                       @RequestParam("deliveryLocationID") int deliveryLocationID) {

        RentalContract rentalContract = new RentalContract(rentalContractID, startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID);

        rentalContractService.updateRentalContract(rentalContract);

        return "redirect:/manageRentalContractRegistration";


    }
}



