package com.example.springdatajpaqueries.service;

import com.example.springdatajpaqueries.entity.Employee;
import com.example.springdatajpaqueries.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findExEmployees(){
        return employeeRepository.findExEmployees();
    }

    public boolean isEmployeed(int employeeId){
        return employeeRepository.isEmployeed(employeeId);
    }

    public boolean isEmployeedParam(int employeeId){
        return employeeRepository.isEmployeedParam(employeeId);
    }
}
