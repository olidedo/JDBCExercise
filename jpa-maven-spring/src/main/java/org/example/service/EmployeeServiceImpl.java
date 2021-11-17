package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee findEmployee(int employeeNumber) {
        return employeeRepository.findEmployeeByNumber(employeeNumber);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
        System.out.println("Employee deleted!");
    }
}
