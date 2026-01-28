package com.mk.order.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBean {
    private Long id;
    private CustomerBean customer;
    private String addressLabel;
    private String name;
    private String phone;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String postalCode;
    private String countryCode;
    private Instant createdAtUtc;
    private Instant updatedAtUtc;
}

