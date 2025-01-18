package com.example.orderManagement.controller;

import com.example.orderManagement.Exception.OrderNotFoundException;
import com.example.orderManagement.entity.Order;
import com.example.orderManagement.entity.Product;
import com.example.orderManagement.service.OrderService;
import com.example.orderManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProducts(@RequestBody Product products){
        return new ResponseEntity<Product>(productService.createProducts(products), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable Long productId){
        try{
            Product prdt=productService.getProductById(productId);
            return new ResponseEntity<Object>(prdt,HttpStatus.OK);
        }catch(OrderNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}

