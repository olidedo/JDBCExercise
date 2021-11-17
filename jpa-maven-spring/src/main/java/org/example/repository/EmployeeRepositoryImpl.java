package org.example.repository;

import org.example.database.Database;
import org.example.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager em;
    private Database database;

    public EmployeeRepositoryImpl() {
        database = new Database();
        em = database.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    @Override
    public Employee findEmployeeByNumber(int employeeNumber) {
        return em.find(Employee.class, employeeNumber);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
        em.close();
    }
}
