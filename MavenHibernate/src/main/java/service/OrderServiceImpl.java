package service;

import repository.OrderRepository;
import repository.OrderRepositoryImpl;

import java.sql.Date;

public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository = new OrderRepositoryImpl();
    @Override
    public void getOrderStatus(int orderNumber) {
        System.out.println(orderRepository.getOrderStatus(orderNumber));
    }

    @Override
    public void getNumberOfOrders(Date date) {
        System.out.println("Number of orders: "+orderRepository.numberOfOrders(date));
    }

    @Override
    public void getNumberOfInProcessOrders() {
        System.out.println("Number of in process orders: " + orderRepository.numberOfInProcessOrders());
    }
}
