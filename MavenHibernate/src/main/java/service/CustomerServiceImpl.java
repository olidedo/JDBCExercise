package service;

import dto.CustomerDto;
import entity.Customer;
import entity.Office;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public void getAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();
        List<CustomerDto> customerData = new ArrayList<>();
        for (Customer c: customers) {
            CustomerDto customerDto = new CustomerDto(c.getCustomerName(), c.getFirstName(), c.getLastName());
            customerData.add(customerDto);
        }
        customerData.forEach(System.out::println);
    }

    @Override
    public void getCustomerOffice(int customerNumber) {
        Office office = customerRepository.findOffice(customerNumber);
        System.out.println("Address: "+office.getAddressLine1() );
    }
}
