package com.mikehenry.springbootredis.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Employee")
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    private String employeeID;

    private String msisdn;

    private String firstName;

    private String lastName;

    private String emailAddress;
}
