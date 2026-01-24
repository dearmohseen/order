package com.mk.order.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address extends BaseEntity {
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
