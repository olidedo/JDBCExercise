package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public Employee findEmployee(int employeeNumber){
        return employeeService.findEmployee(employeeNumber);
    }

    public void addEmployee(Employee employee){
        employeeService.addEmployee(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeService.deleteEmployee(employee);
    }
}
