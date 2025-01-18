package com.example.orderManagement.service;

import com.example.orderManagement.Exception.OrderNotFoundException;
import com.example.orderManagement.entity.Order;
import com.example.orderManagement.entity.Product;
import com.example.orderManagement.repository.OrderRepository;
import com.example.orderManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProducts(Product products) {
        return productRepository.save(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(()->new OrderNotFoundException("Wrong Product"));
    }
}

