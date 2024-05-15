package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Car;
import org.example.examprojectbilabonnement.repository.DataRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DataRegistrationService {
    @Autowired
    DataRegistrationRepo dataRegistrationRepo;

    public void addCar(Car car){
        dataRegistrationRepo.addCar(car);
    }

}
