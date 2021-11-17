package org.example.service;

import java.sql.Date;

public interface OrderService {
    String getOrderStatus(int orderNumber);
    int getNumberOfOrders(Date date);
}
