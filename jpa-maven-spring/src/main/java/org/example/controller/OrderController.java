package org.example.controller;

import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    public String getOrderStatus(int orderNumber){
        return orderService.getOrderStatus(orderNumber);
    }

    public int getNumberOfOrders(Date date){
        return orderService.getNumberOfOrders(date);
    }

}
