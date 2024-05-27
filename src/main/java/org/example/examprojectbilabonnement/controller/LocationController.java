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
    LocationService locationService; // Spring leverer automatisk en instans af LocationService

    @GetMapping("manageLocationRegistration")
    public String manageLocation(Model model) {
        // Tilføjer listen af lokationer til modellen
        model.addAttribute("locationList", locationService.findAll());
        return "ManageLocationRegistration"; // Returnerer navnet på visningen
    }

    @GetMapping("/showAddLocationPage")
    public String showAddLocationPage() {
        return "AddLocation"; // Returnerer navnet på siden for at tilføje en lokation
    }

    @PostMapping("/addLocation")
    public String addLocation(@RequestParam("name") String name,
                              @RequestParam("city") String city,
                              @RequestParam("zipCode") int zipCode,
                              @RequestParam("adress") String adress) {
        Location location = new Location(name, city, zipCode, adress); // Opretter en ny lokation
        locationService.addLocation(location); // Tilføjer lokationen til systemet
        return "redirect:/manageLocationRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/deleteLocation/{locationID}")
    public String deleteLocation(@PathVariable("locationID") int locationID) {
        locationService.deleteLocation(locationID); // Sletter lokationen med det givne ID
        return "redirect:/manageLocationRegistration"; // Omdirigerer til administrationssiden
    }

    @GetMapping("/showLocationUpdatePage/{locationID}")
    public String showUpdatePage(@PathVariable("locationID") int locationID, Model model) {
        // Tilføjer lokationen til modellen for opdateringssiden
        model.addAttribute("location", locationService.findByID(locationID));
        return "UpdateLocation"; // Returnerer navnet på opdateringssiden
    }

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestParam("locationID") int locationID,
                                 @RequestParam("name") String name,
                                 @RequestParam("city") String city,
                                 @RequestParam("zipCode") int zipCode,
                                 @RequestParam("adress") String adress) {

        Location location = new Location(locationID, name, city, zipCode, adress); // Opretter en lokation med opdaterede oplysninger
        locationService.updateLocation(location); // Opdaterer lokationen i systemet
        return "redirect:/manageLocationRegistration"; // Omdirigerer til administrationssiden
    }
}
