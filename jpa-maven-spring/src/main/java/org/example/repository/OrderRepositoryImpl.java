package org.example.repository;

import org.example.database.Database;
import org.example.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private EntityManager em;
    private Database database;

    public OrderRepositoryImpl() {
        database = new Database();
        em = database.getConnection();
    }

    @Override
    public String getOrderStatus(int orderNumber) {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.id=?1", Order.class);
        return query.setParameter(1,orderNumber).getSingleResult().getStatus();
    }

    @Override
    public int numberOfOrders(Date date) {
        TypedQuery<Long> query = em.createQuery("SELECT count(o) \n" +
                "FROM Order o \n" +
                "GROUP BY o.orderDate\n" +
                "HAVING o.orderDate=?1", Long.class);
        return Integer.parseInt(String.valueOf(query.setParameter(1,date).getSingleResult()));
    }

    @Override
    public int numberOfInProcessOrders() {
        TypedQuery<Long> query = em.createQuery("SELECT count(o) \n" +
                "FROM Order o \n" +
                "GROUP BY o.status\n" +
                "HAVING o.status=?1", Long.class);
        return Integer.parseInt(String.valueOf(query.setParameter(1,"In Process").getSingleResult()));
    }
}
