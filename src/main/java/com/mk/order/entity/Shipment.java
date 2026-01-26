package com.mk.order.entity;

import com.mk.order.domain.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id
    @SequenceGenerator(name = "shipment_seq", sequenceName = "seq_shipment_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
    @Column(name = "shipment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;

    @Column(name = "carrier", length = 40)
    private String carrier;

    @Column(name = "service", length = 40)
    private String service;

    @Column(name = "tracking_number", length = 60)
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ShipmentStatus status = ShipmentStatus.READY;

    @Column(name = "shipped_at_utc")
    private Instant shippedAtUtc;

    @Column(name = "delivered_at_utc")
    private Instant deliveredAtUtc;

    @Column(name = "created_at_utc", nullable = false)
    private Instant createdAtUtc;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}
