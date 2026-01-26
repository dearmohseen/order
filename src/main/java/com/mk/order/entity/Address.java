package com.mk.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "seq_address_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @Column(name = "address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer; // nullable (guest checkout)

    @Column(name = "address_label", length = 40)
    private String addressLabel;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "phone", length = 32)
    private String phone;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "line1", nullable = false, length = 200)
    private String line1;

    @Column(name = "line2", length = 200)
    private String line2;

    @Column(name = "city", nullable = false, length = 120)
    private String city;

    @Column(name = "state", length = 120)
    private String state;

    @Column(name = "postal_code", length = 32)
    private String postalCode;

    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode = "US";

    @Column(name = "created_at_utc", nullable = false)
    private Instant createdAtUtc;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}

