package com.mk.order.service;

import com.mk.order.bean.OrderResponse;

import java.util.List;

public interface OrderService {

    public List<OrderResponse> getAllOrders();
}
