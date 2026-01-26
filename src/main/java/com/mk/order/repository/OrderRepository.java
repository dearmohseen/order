package com.mk.order.repository;

import com.mk.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Override
    public List<Order> findAll();
}
