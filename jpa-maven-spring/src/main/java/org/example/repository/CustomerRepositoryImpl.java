package org.example.repository;

import org.example.database.Database;
import org.example.entity.Customer;
import org.example.entity.Office;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private EntityManager em;
    private Database database;

    public CustomerRepositoryImpl() {
        database = new Database();
        em = database.getConnection();
    }

    @Override
    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Office findOffice(int customerNumber) {
        TypedQuery<Office> query = em.createQuery("SELECT o\n" +
                "FROM Customer c JOIN Employee e ON e.employeeNumber = c.salesRep.employeeNumber\n" +
                "JOIN Office o ON e.officeCode= o.id\n" +
                "WHERE c.customerNumber = ?1", Office.class);
        return query.setParameter(1,customerNumber).getSingleResult();
    }
}
