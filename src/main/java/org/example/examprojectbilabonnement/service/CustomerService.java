package org.example.examprojectbilabonnement.service;

import org.example.examprojectbilabonnement.model.Customer;
import org.example.examprojectbilabonnement.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo; // Spring leverer automatisk en instans af CustomerRepo

    // Henter alle kunder fra CustomerRepo
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    // Tilføjer en ny kunde via CustomerRepo
    public void addCustomer(Customer customer) {
        customerRepo.addCustomer(customer);
    }

    // Sletter en kunde ved hjælp af kundens ID via CustomerRepo
    public void deleteCustomer(int customerID) {
        customerRepo.deleteCustomerByCustomerID(customerID);
    }

    // Finder en kunde ved hjælp af kundens ID via CustomerRepo
    public Customer findByID(int customerID) {
        return customerRepo.findByID(customerID);
    }

    // Opdaterer oplysningerne om en kunde via CustomerRepo
    public void updateCustomer(Customer customer) {
        customerRepo.updateByID(customer);
    }
}
