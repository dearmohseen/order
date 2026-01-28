package com.mk.order.bean;

import com.mk.order.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private CustomerBean customer;
    private String orderNumber;
    private OrderStatus status;
    private String currencyCode = "USD";
    private BigDecimal subtotalAmount;
    private BigDecimal discountAmount;
    private BigDecimal taxAmount;
    private BigDecimal shippingAmount;
    private BigDecimal totalAmount;
    private AddressBean billingAddress;
    private AddressBean shippingAddress;
    private Instant placedAtUtc;
    private Instant paidAtUtc;
    private Instant updatedAtUtc;
}

