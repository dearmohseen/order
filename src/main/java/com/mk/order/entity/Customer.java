package com.mk.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "seq_customer_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "email", nullable = false, length = 160, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "phone", length = 32)
    private String phone;

    @Column(name = "status", nullable = false, length = 16)
    private String status; // or an enum if you prefer

    @Column(name = "created_at_utc", nullable = false)
    private Instant createdAtUtc;

    @Column(name = "updated_at_utc", nullable = false)
    private Instant updatedAtUtc;
}

