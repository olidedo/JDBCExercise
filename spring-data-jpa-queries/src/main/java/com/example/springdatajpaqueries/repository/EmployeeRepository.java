package com.example.springdatajpaqueries.repository;

import com.example.springdatajpaqueries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e from Employee e where e.isEmployeed=false")
    List<Employee> findExEmployees();

    @Query("SELECT e.isEmployeed from Employee e where e.employeeId =?1")
    boolean isEmployeed(int employeeId);

    @Query("SELECT e.isEmployeed from Employee e where e.employeeId =:employeeId")
    boolean isEmployeedParam(@Param("employeeId") int employeeId);
}
