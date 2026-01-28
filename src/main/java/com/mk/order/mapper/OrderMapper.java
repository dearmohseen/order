package com.mk.order.mapper;

import com.mk.order.bean.OrderResponse;
import com.mk.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse toResponse(Order order);

    // Collection mapping
    List<OrderResponse> toResponses(List<Order> orders);

}
