package repository;

import entity.Customer;
import entity.Office;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Office findOffice(int customerNumber);
}
