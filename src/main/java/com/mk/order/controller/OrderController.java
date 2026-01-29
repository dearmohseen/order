package com.mk.order.controller;

import com.mk.order.bean.OrderResponse;
import com.mk.order.bean.ProductBean;
import com.mk.order.service.OrderService;
import com.mk.order.utility.OrderUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

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

    @GetMapping("/products")
    public List<ProductBean> getProducts() {
        return orderService.getProductsByWebClient();
    }

    @GetMapping("/feign/products")
    public List<ProductBean> getProductsByFeign() {
        logger.info("getProductsByFeign");
        return orderService.getProductsByFeign();
    }

    @GetMapping("/initialize")
    public String initializeData() throws IOException {
        orderUtility.initializeData();
        return "Success";
    }

}
