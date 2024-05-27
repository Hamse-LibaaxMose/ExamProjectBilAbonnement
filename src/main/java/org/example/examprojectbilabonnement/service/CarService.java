package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo; // Spring leverer automatisk en instans af CarRepo

    // Henter alle biler fra CarRepo
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    // Tilføjer en ny bil via CarRepo
    public void addCar(Car car) {
        carRepo.addCar(car);
    }

    // Sletter en bil ved hjælp af bilens ID via CarRepo
    public void deleteCar(int carNumberId) {
        carRepo.deleteCarByCarNumberID(carNumberId);
    }

    // Finder en bil ved hjælp af bilens ID via CarRepo
    public Car findByID(int carNumberID) {
        return carRepo.findByID(carNumberID);
    }

    // Opdaterer oplysningerne om en bil via CarRepo
    public void updateCar(Car car) {
        carRepo.updateByID(car);
    }
}

