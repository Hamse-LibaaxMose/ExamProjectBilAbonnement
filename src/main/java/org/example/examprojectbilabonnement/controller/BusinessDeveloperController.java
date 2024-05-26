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
        int totalPrice = 0;
        LocalDate rentalContractStartDate, rentalContractEndDate;
        List<RentalContractView> rentalContractList = rentalContractService.findAll();
        LocalDate currentDate = LocalDate.now();
        for(int i=0; i<rentalContractList.size(); i++){
            rentalContractStartDate = stringToDate(rentalContractList.get(i).getStartDate());
            rentalContractEndDate = stringToDate(rentalContractList.get(i).getEndDate());
            if(rentalContractStartDate.isBefore(currentDate) && rentalContractEndDate.isAfter(currentDate)) {
                totalPrice +=  rentalContractList.get(i).getPrice();
                rentalContractList.get(i).setRentalStatus("Active");
            }
            else if(rentalContractStartDate.isAfter(currentDate)) {
                totalPrice +=  rentalContractList.get(i).getPrice();
                rentalContractList.get(i).setRentalStatus("Reserved");
            }
            else
            rentalContractList.get(i).setRentalStatus("Expired");
        }
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("rentalContractList",rentalContractList);
        return "RentalCarReport";
    }
    public LocalDate stringToDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + dateStr);
            return null;
        }
    }
}
