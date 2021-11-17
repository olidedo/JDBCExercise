package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Office;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Office getCustomerOffice(int customerNumber);
}
