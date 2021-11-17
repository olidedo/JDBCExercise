package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Office;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Office findOffice(int customerNumber);
}
