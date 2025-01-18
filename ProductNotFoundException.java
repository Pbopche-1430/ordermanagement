package com.example.orderManagement.Exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String ProductNotFound) {
        super(ProductNotFound);
    }
}



