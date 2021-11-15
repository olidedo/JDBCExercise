package repository;

import java.sql.Date;

public interface OrderRepository {
    String getOrderStatus(int orderNumber);
    int numberOfOrders(Date date);
    int numberOfInProcessOrders();
}
