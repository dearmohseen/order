package com.mk.order.service;

import com.mk.order.bean.OrderResponse;
import com.mk.order.mapper.OrderMapper;
import com.mk.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderMapper.toResponses(orderRepository.findAll());
    }

}
