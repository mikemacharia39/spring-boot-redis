package com.mikehenry.springbootredis.controller;

import com.mikehenry.springbootredis.model.Employee;
import com.mikehenry.springbootredis.requests.CreateEmployee;
import com.mikehenry.springbootredis.requests.UpdateEmployeePayload;
import com.mikehenry.springbootredis.responses.EmployeeResponse;
import com.mikehenry.springbootredis.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employee/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("create")
    public Employee saveEmployeeRecord(@RequestBody CreateEmployee createEmployee) {

        logger.info("Received Request: " + createEmployee.toString());

        Employee employee = new Employee();
        employee.setEmployeeID(createEmployee.getEmployeeID());
        employee.setMsisdn(createEmployee.getMsisdn());
        employee.setFirstName(createEmployee.getFirstName());
        employee.setLastName(createEmployee.getLastName());
        employee.setEmailAddress(createEmployee.getEmailAddress());

        return employeeService.createEmployee(employee);
    }

    @PutMapping("update")
    public Employee updateEmployeeData(@RequestBody UpdateEmployeePayload updateEmployeePayload) {
        Optional<Employee> employeeData = employeeService.updateEmployee(updateEmployeePayload);

        if (employeeData.isEmpty()) {
            throw new RuntimeException("No employee data");
        }

        return employeeData.get();
    }

    @GetMapping("get/{id}")
    public Employee getEmployeeData(@PathVariable("id") String employeeID) {
        Optional<Employee> employeeData = employeeService.getEmployeeByID(employeeID);

        if (employeeData.isEmpty()) {
            throw new RuntimeException("No employee data");
        }

        return employeeData.get();
    }

    @GetMapping("getall")
    public List<EmployeeResponse> getAllEmployeeData() {

        Iterable <Employee> employeeIterable = employeeService.getAllEmployees();

        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for (Employee employee : employeeIterable) {
            employeeResponseList.add(new EmployeeResponse(employee));
        }

        return employeeResponseList;
    }
}
