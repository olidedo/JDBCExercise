package service;

import entity.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);
    Employee findEmployee(int employeeNumber);
    void deleteEmployee(Employee employee);
}
