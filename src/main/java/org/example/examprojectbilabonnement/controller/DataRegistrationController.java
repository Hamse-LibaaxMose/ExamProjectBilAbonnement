package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.service.DataRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataRegistrationController {
    @Autowired
    DataRegistrationService dataRegistrationService;
    @GetMapping("showDataPage")
    public String showDataPage() {
        return "DataRegistration";
    }

    @GetMapping("CreateCarPage")
    public String managerCar() {

        return "ManageCarRegistration";
    }

    @GetMapping("showAddCarPage")
    public String showAddCarPage() {
        return "AddCar";
    }


    @PostMapping("AddCar")
        public String addCar (@RequestParam("model") String model, @RequestParam("brand") String brand, @RequestParam("frameNumber") int frameNumber ) {
        Car car = new Car(model, brand, frameNumber);

        dataRegistrationService.addCar(car);

        return "DataRegistration";
        }
    }





