package com.example.orderManagement.Exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String OrderNotFound) {
        super(OrderNotFound);
    }

}
