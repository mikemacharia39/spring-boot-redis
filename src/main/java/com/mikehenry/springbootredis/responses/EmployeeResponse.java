package com.mikehenry.springbootredis.responses;

import com.mikehenry.springbootredis.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

    String employeeID;

    String msisdn;

    String firstName;

    String lastName;

    String emailAddress;

    public EmployeeResponse(Employee employee) {
        this.employeeID = employee.getEmployeeID();
        this.msisdn = employee.getMsisdn();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.emailAddress = employee.getEmailAddress();
    }
}
