package com.mk.order.controller;

import com.mk.order.entity.Order;
import com.mk.order.utility.OrderUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> loadProducts(@RequestBody List<Order> orders) {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
