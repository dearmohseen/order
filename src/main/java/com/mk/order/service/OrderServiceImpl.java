package com.mk.order.service;

import com.mk.order.bean.OrderResponse;
import com.mk.order.bean.ProductBean;
import com.mk.order.feignclient.ProductServiceClient;
import com.mk.order.mapper.OrderMapper;
import com.mk.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    WebClient webClient;

    @Autowired
    ProductServiceClient productServiceClient;

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderMapper.toResponses(orderRepository.findAll());
    }

    @Override
    public List<ProductBean> getProductsByWebClient() {
        return webClient.get().uri("").retrieve().bodyToMono(List.class).block();
    }

    @Override
    public List<ProductBean> getProductsByFeign() {
        return productServiceClient.getProducts();
    }

}
