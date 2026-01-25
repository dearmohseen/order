package com.mk.order.controller;

import com.mk.order.entity.Order;
import com.mk.order.utility.OrderUtility;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderUtility orderUtility;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setId(1l);
        order.setTotalPrice(new BigDecimal(1000.00));
        orders.add(order);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> loadProducts() throws IOException {
        orderUtility.loadProducts();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/initialize")
    public String initializeData() throws IOException {
        orderUtility.initializeData();
        return "Success";
    }

}
