package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.Location;
import org.example.examprojectbilabonnement.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("manageLocationRegistration")

    public String manageLocation(Model model) {
        model.addAttribute("locationList", locationService.findAll());
        return "ManageLocationRegistration";

    }

    @GetMapping("/showAddLocationPage")
    public String showAddLocationPage() {
        return "AddLocation";
    }

    @PostMapping("/addLocation")
    public String addLocation(@RequestParam("name") String name,
                              @RequestParam("city") String city,
                              @RequestParam("zipCode") int zipCode,
                              @RequestParam("adress") String adress) {
        Location location = new Location(name, city, zipCode, adress);
        locationService.addLocation(location);
        return "redirect:/manageLocationRegistration";
    }

    @GetMapping("/deleteLocation/{locationID}")
    public String deleteLocation(@PathVariable("locationID") int locationID) {
        locationService.deleteLocation(locationID);
        return "redirect:/manageLocationRegistration";
    }

    @GetMapping("/showLocationUpdatePage/{locationID}")
    public String showUpdatePage(@PathVariable("locationID") int locationID, Model model) {
        model.addAttribute("location", locationService.findByID(locationID));
        return "UpdateLocation";
    }

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestParam("locationID") int locationID,
                                 @RequestParam("name") String name,
                                 @RequestParam("city") String city,
                                 @RequestParam("zipCode") int zipCode,
                                 @RequestParam("adress") String adress) {

        Location location = new Location(locationID, name, city, zipCode, adress);
        locationService.updateLocation(location);
        return "redirect:/manageLocationRegistration";
    }
}
