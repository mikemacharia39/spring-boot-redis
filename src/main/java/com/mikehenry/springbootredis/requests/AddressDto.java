package com.mikehenry.springbootredis.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private String mobileNumber;
    private String address;
    private int zipCode;
    private String city;
    private String country;
}
