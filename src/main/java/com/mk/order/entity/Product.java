package com.mk.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @NotBlank
    @Size(max = 160)
    @Column(nullable = false, length = 160)
    private String name;

    /**
     * Monetary amount with 2 decimals; adjust precision as needed.
     */
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer stock;

    /**
     * 0.0–5.0 typical rating; store as DECIMAL(2,1) or DOUBLE.
     */
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    @Column(precision = 2, scale = 1)
    private BigDecimal rating;

/*    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private ProductStatus status = ProductStatus.ACTIVE;*/

    /**
     * Many products belong to one category.
     */
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "category_id", nullable = false,
//            foreignKey = @ForeignKey(name = "fk_products_category"))
//    private ProductCategory category;

    /**
     * Many products belong to one brand.
     */
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "brand_id", nullable = false,
//            foreignKey = @ForeignKey(name = "fk_products_brand"))
//    private Brand brand;
}

