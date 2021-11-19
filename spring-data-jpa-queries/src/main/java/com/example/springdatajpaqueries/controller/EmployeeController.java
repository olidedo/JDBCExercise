package com.example.springdatajpaqueries.controller;

import com.example.springdatajpaqueries.entity.Employee;
import com.example.springdatajpaqueries.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public List<Employee> findExEmployees(){
        return employeeService.findExEmployees();
    }

    public boolean isEmployeed(int employeeId){
        return employeeService.isEmployeed(employeeId);
    }

    public boolean isEmployeedParam(int employeeId){
        return employeeService.isEmployeedParam(employeeId);
    }
}
