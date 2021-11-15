package service;

import java.sql.Date;

public interface OrderService {
    void getOrderStatus(int orderNumber);
    void getNumberOfOrders(Date date);
    void getNumberOfInProcessOrders();
}
