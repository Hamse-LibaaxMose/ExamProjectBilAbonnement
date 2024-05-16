package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping("manageCarRegistration")
    public String manageCar(Model model) {
        model.addAttribute("carList", carService.findAll());
        return "ManageCarRegistration";
    }

    @GetMapping("showAddCarPage")
    public String showAddCarPage() {
        return "AddCar";
    }


    @PostMapping("AddCar")
    public String addCar (@RequestParam("model") String model, @RequestParam("brand") String brand, @RequestParam("frameNumber") int frameNumber ) {
        Car car = new Car(model, brand, frameNumber);
        carService.addCar(car);
        return "redirect:/manageCarRegistration";
    }


}
