package com.mikehenry.springbootredis.model;

import com.mikehenry.springbootredis.requests.CreateEmployee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

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
