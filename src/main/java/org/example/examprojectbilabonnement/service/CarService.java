package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;

    public List<Car> findAll(){
     return carRepo.findAll();
    }
    public void addCar(Car car){
        carRepo.addCar(car);
    }
    public void deleteCar(int carNumberId){
        carRepo.deleteCarByCarNumberID(carNumberId);
    }

    public Car findByID(int carNumberID){
        return carRepo.findByID(carNumberID);

    }
    public void updateCar(Car car){
         carRepo.updateByID(car);
    }

}
