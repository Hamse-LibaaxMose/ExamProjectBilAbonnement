package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Location;
import org.example.examprojectbilabonnement.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepo locationRepo;

    public List<Location> findAll() {
        return locationRepo.findAll();
    }

    public void addLocation(Location location) {
        locationRepo.addLocation(location);
    }

    public void deleteLocation(int locationID) {
        locationRepo.deleteLocationBYLocationID(locationID);
    }

    public Location findByID(int locationID) {
        return locationRepo.findByID(locationID);
    }

    public void updateLocation(Location location) {
        locationRepo.updateByID(location);
    }


}
