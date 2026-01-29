package com.mk.order.service;

import com.mk.order.bean.OrderResponse;
import com.mk.order.bean.ProductBean;

import java.util.List;

public interface OrderService {

    public List<OrderResponse> getAllOrders();

    public List<ProductBean> getAllProducts();
}
