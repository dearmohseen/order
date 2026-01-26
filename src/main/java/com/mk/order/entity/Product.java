package com.mk.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "seq_product_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name = "product_id")
    private Long id;

    @Column(name = "sku", nullable = false, length = 64, unique = true)
    private String sku;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private java.math.BigDecimal price;

    @Column(name = "currency_code", nullable = false, length = 3)
    private String currencyCode = "USD";

    @Column(name = "weight_grams")
    private Integer weightGrams;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "created_at_utc", nullable = false)
    private Instant createdAtUtc;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}

