package com.mikehenry.springbootredis.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {

    private String mobileNumber;
    private String address;
    private int zipCode;
    private String city;
    private String country;
}
