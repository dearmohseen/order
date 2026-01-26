package com.mk.order.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shipment_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentItem {

    @Id
    @SequenceGenerator(name = "shipment_item_seq", sequenceName = "seq_shipment_item_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_item_seq")
    @Column(name = "shipment_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Shipment shipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_detail_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrderDetail orderDetail;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
