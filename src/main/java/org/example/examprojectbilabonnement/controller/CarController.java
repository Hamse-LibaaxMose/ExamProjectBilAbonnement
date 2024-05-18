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
    CarService carService;

    @GetMapping("/manageCarRegistration")
    public String manageCar(Model model) {
        model.addAttribute("carList", carService.findAll());
        return "ManageCarRegistration";
    }

    @GetMapping("/showAddCarPage")
    public String showAddCarPage() {
        return "AddCar";
    }


    @PostMapping("/addCar")
    public String addCar(@RequestParam("model") String model, @RequestParam("brand") String brand, @RequestParam("frameNumber") int frameNumber) {
        Car car = new Car(model, brand, frameNumber);
        carService.addCar(car);
        return "redirect:/manageCarRegistration";
    }

    @GetMapping("/deleteCar/{carNumberID}")
    public String deleteCar(@PathVariable("carNumberID") int carNumberID) {
        carService.deleteCar(carNumberID);
        return "redirect:/manageCarRegistration";
    }

    @GetMapping("/showUpdatePage/{carNumberID}")
    public String showUpdatePage(@PathVariable("carNumberID") int carNumberID, Model model) {
        model.addAttribute("car", carService.findByID(carNumberID));
        return "UpdateCar";
    }

    @PostMapping("updateCar")
    public String updateCar(@RequestParam("carNumberID") int carNumberID, @RequestParam("model") String model, @RequestParam("brand") String brand, @RequestParam("frameNumber") int frameNumber) {
        Car car = new Car(carNumberID, model, brand, frameNumber);
        carService.updateCar(car);
        return "redirect:/manageCarRegistration";
    }

}
