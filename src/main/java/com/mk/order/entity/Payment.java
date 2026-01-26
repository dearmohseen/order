package com.mk.order.entity;

import com.mk.order.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_seq", sequenceName = "seq_payment_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;

    @Column(name = "provider", nullable = false, length = 40)
    private String provider;

    @Column(name = "method", nullable = false, length = 40)
    private String method;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "currency_code", nullable = false, length = 3)
    private String currencyCode = "USD";

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private PaymentStatus status;

    @Column(name = "transaction_ref", length = 100)
    private String transactionRef;

    @Column(name = "auth_code", length = 40)
    private String authCode;

    @Column(name = "created_at_utc", nullable = false)
    private Instant createdAtUtc;

    @Column(name = "authorized_at_utc")
    private Instant authorizedAtUtc;

    @Column(name = "captured_at_utc")
    private Instant capturedAtUtc;

    @Column(name = "failure_reason", length = 200)
    private String failureReason;
}

