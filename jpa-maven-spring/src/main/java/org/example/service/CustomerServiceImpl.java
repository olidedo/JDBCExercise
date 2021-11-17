package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Office;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Office getCustomerOffice(int customerNumber) {
        return customerRepository.findOffice(customerNumber);
    }
}
