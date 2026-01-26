package com.mk.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "product_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInventory {

    @Id
    @Column(name = "product_id")
    private Long id; // shared PK

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Product product;

    @Column(name = "quantity_on_hand", nullable = false)
    private Integer quantityOnHand = 0;

    @Column(name = "quantity_reserved", nullable = false)
    private Integer quantityReserved = 0;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}

