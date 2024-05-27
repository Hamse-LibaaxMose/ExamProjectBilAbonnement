package org.example.examprojectbilabonnement.controller;

import org.example.examprojectbilabonnement.model.RentalContractView;
import org.example.examprojectbilabonnement.service.RentalContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Controller
public class BusinessDeveloperController {
    @Autowired
    RentalContractService rentalContractService;

    @GetMapping("/displayRentalCarReport")
    public String displayRentalCarReport(Model model) {
        int totalPrice = 0; // Initialiserer totalprisen
        LocalDate rentalContractStartDate, rentalContractEndDate;
        List<RentalContractView> rentalContractList = rentalContractService.findAll(); // Henter alle udlejningskontrakter
        LocalDate currentDate = LocalDate.now(); // Henter den aktuelle dato

        // Itererer gennem alle udlejningskontrakter
        for (int i = 0; i < rentalContractList.size(); i++) {
            rentalContractStartDate = stringToDate(rentalContractList.get(i).getStartDate()); // Konverterer startdato til LocalDate
            rentalContractEndDate = stringToDate(rentalContractList.get(i).getEndDate()); // Konverterer slutdato til LocalDate

            // Tjekker om kontrakten er aktiv
            if (rentalContractStartDate.isBefore(currentDate) && rentalContractEndDate.isAfter(currentDate)) {
                totalPrice += rentalContractList.get(i).getPrice(); // Tilføjer prisen til totalprisen
                rentalContractList.get(i).setRentalStatus("Active"); // Sætter status til "Aktiv"
            }
            // Tjekker om kontrakten er reserveret
            else if (rentalContractStartDate.isAfter(currentDate)) {
                totalPrice += rentalContractList.get(i).getPrice(); // Tilføjer prisen til totalprisen
                rentalContractList.get(i).setRentalStatus("Reserved"); // Sætter status til "Reserveret"
            }
            // Hvis kontrakten er udløbet
            else {
                rentalContractList.get(i).setRentalStatus("Expired"); // Sætter status til "Udløbet"
            }
        }

        model.addAttribute("totalPrice", totalPrice); // Tilføjer totalprisen til modellen
        model.addAttribute("rentalContractList", rentalContractList); // Tilføjer udlejningskontraktlisten til modellen
        return "RentalCarReport"; // Returnerer navnet på visningen
    }

    public LocalDate stringToDate(String dateStr) {
        try {
            // Definerer en formatter, der bruger ISO_LOCAL_DATE formatet
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            // Parser strengen til en LocalDate ved hjælp af formatteren
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            // Håndterer undtagelsen hvis datoformatet er ugyldigt
            System.err.println("Invalid date format: " + dateStr);
            return null; // Returnerer null hvis parsing fejler
        }
    }
}
