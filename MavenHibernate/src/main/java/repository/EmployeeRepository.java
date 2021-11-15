package repository;

import entity.Employee;

public interface EmployeeRepository {
    void addEmployee(Employee employee);
    Employee findEmployeeByNumber(int employeeNumber);
    void deleteEmployee(Employee employee);
}
