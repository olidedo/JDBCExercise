package org.example.service;

import org.example.entity.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee findEmployee(int employeeNumber);
    void deleteEmployee(Employee employee);
}
