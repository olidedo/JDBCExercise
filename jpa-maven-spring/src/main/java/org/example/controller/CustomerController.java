package org.example.controller;

import org.example.entity.Customer;
import org.example.entity.Office;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Office findOffice(int customerNumber){
        return customerService.getCustomerOffice(customerNumber);
    }
}
