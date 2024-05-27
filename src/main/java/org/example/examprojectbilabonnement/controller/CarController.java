package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService; // Automatisk injektion af CarService

    @GetMapping("/manageCarRegistration")
    public String manageCar(Model model) {
        // Tilføjer listen af biler til modellen
        model.addAttribute("carList", carService.findAll());
        return "ManageCarRegistration"; // Returnerer navnet på visningen
    }

    @GetMapping("/showAddCarPage")
    public String showAddCarPage() {
        return "AddCar"; // Returnerer navnet på siden for at tilføje en bil
    }

    @PostMapping("/addCar")
    public String addCar(@RequestParam("model") String model, @RequestParam("brand") String brand, @RequestParam("frameNumber") int frameNumber) {
        Car car = new Car(model, brand, frameNumber); // Opretter en ny bil
        carService.addCar(car); // Tilføjer bilen til systemet
        return "redirect:/manageCarRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/deleteCar/{carNumberID}")
    public String deleteCar(@PathVariable("carNumberID") int carNumberID) {
        carService.deleteCar(carNumberID); // Sletter bilen med det givne ID
        return "redirect:/manageCarRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/showCarUpdatePage/{carNumberID}")
    public String showUpdatePage(@PathVariable("carNumberID") int carNumberID, Model model) {
        // Tilføjer bilen til modellen for opdateringssiden
        model.addAttribute("car", carService.findByID(carNumberID));
        return "UpdateCar"; // Returnerer navnet på opdateringssiden
    }

    @PostMapping("/updateCar")
    public String updateCar(@RequestParam("carNumberID") int carNumberID,
                            @RequestParam("model") String model,
                            @RequestParam("brand") String brand,
                            @RequestParam("frameNumber") int frameNumber) {

        Car car = new Car(carNumberID, model, brand, frameNumber); // Opretter en bil med opdaterede oplysninger
        carService.updateCar(car); // Opdaterer bilen i systemet
        return "redirect:/manageCarRegistration"; // Omdirigerer til administrationssiden
    }

}
