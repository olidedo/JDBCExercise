package org.example.service;

import org.example.repository.OrderRepository;
import org.example.repository.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public String getOrderStatus(int orderNumber) {
        return orderRepository.getOrderStatus(orderNumber);
    }

    @Override
    public int getNumberOfOrders(Date date) {
        return orderRepository.numberOfOrders(date);
    }
}
