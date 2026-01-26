package com.mk.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payment_refund")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRefund {
    @Id
    @SequenceGenerator(name = "refund_seq", sequenceName = "seq_refund_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_seq")
    @Column(name = "refund_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Payment payment;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "reason", length = 200)
    private String reason;

    @Column(name = "refunded_at_utc", nullable = false)
    private Instant refundedAtUtc;
}

