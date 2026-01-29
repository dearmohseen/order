package com.mk.order.bean;

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
public class ProductBean {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String currencyCode = "USD";
    private Integer weightGrams;
    private boolean active = true;
    private Instant createdAtUtc;
    private Instant updatedAtUtc;
}

