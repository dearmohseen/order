package com.mk.order.entity;

import com.mk.order.domain.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @SequenceGenerator(name = "orders_seq", sequenceName = "seq_orders_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    @Column(name = "order_number", nullable = false, length = 30, unique = true)
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private OrderStatus status;

    @Column(name = "currency_code", nullable = false, length = 3)
    private String currencyCode = "USD";

    @Column(name = "subtotal_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotalAmount;

    @Column(name = "discount_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "tax_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "shipping_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal shippingAmount;

    @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Address billingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Address shippingAddress;

    @Column(name = "placed_at_utc", nullable = false)
    private Instant placedAtUtc;

    @Column(name = "paid_at_utc")
    private Instant paidAtUtc;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}

