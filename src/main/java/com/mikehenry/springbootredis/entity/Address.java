package com.mikehenry.springbootredis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("EMPLOYEE_ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String mobileNumber;
    private String address;
    private int zipCode;
    private String city;
    private String country;
}
