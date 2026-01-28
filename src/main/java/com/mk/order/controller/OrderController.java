package com.mk.order.controller;

import com.mk.order.bean.OrderResponse;
import com.mk.order.service.OrderService;
import com.mk.order.utility.OrderUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderUtility orderUtility;

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createOrder() throws IOException {
        //orderUtility.loadProducts();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/initialize")
    public String initializeData() throws IOException {
        orderUtility.initializeData();
        return "Success";
    }

}
