package com.mikehenry.springbootredis.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateEmployeePayload {

    @NotNull
    private String employeeID;

    private String msisdn;

    private String firstName;

    private String lastName;

    private String emailAddress;
}
