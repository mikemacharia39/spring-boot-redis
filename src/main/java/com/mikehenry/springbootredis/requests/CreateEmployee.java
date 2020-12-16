package com.mikehenry.springbootredis.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateEmployee {

    private String employeeID;

    @JsonProperty("mobileNumber")
    private String msisdn;

    private String firstName;

    private String lastName;

    private String emailAddress;
}
