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
    CustomerRepo customerRepo;
    public List<Customer> findAll(){
        return customerRepo.findAll();
    }
    public void addCustomer(Customer customer){
        customerRepo.addCustomer(customer);
    }

}
