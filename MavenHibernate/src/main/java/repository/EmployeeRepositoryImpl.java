package repository;

import database.Database;
import entity.Employee;

import javax.persistence.EntityManager;

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
