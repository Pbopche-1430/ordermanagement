package com.example.orderManagement.service;


import com.example.orderManagement.Exception.OrderNotFoundException;
import com.example.orderManagement.entity.Order;
import com.example.orderManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> createOrders(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Wrong Order"));
    }

    public Object updateOrder(Long orderId, Order orderDetails) {
        Order order=orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("Wrong Order"));
        order.setCustomerName(orderDetails.getCustomerName());
        order.setProduct(orderDetails.getProduct());
        order.setOrderdate(orderDetails.getOrderdate());
        order.setStatus(orderDetails.getStatus());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
