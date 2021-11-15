package service;

import entity.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
        System.out.println("Employee added!");
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
