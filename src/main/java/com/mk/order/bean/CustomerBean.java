package com.mk.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBean {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String status;
    private Instant createdAtUtc;
    private Instant updatedAtUtc;
}

