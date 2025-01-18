package com.example.orderManagement.controller;

import com.example.orderManagement.Exception.OrderNotFoundException;
import com.example.orderManagement.entity.Order;
import com.example.orderManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<List<Order>> createOrders(@RequestBody List<Order> orders){
        return new ResponseEntity<List<Order>>(orderService.createOrders(orders), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<List<Order>>(orderService.getOrders(),HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long orderId){
        try{
            Order order=orderService.getOrderById(orderId);
            return new ResponseEntity<Object>(order,HttpStatus.OK);
        }catch(OrderNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/orders/{orderId}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long orderId, @RequestBody Order orderDetails){
        try{
            return new ResponseEntity<>(orderService.updateOrder(orderId,orderDetails), HttpStatus.OK);
        }catch(OrderNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}