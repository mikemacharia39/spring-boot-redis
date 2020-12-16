package com.mikehenry.springbootredis.service;

import com.mikehenry.springbootredis.model.Employee;
import com.mikehenry.springbootredis.repository.EmployeeRepository;
import com.mikehenry.springbootredis.requests.UpdateEmployeePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeByID(String employeeID) {
        return employeeRepository.findById(employeeID);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> updateEmployee(UpdateEmployeePayload updateEmployeePayload) {
        Employee employee = employeeRepository.findById(updateEmployeePayload.getEmployeeID()).get();

        if (updateEmployeePayload.getFirstName() != null || updateEmployeePayload.getFirstName().isBlank()) {
            employee.setFirstName(updateEmployeePayload.getFirstName());
        }

        if (updateEmployeePayload.getLastName() != null || updateEmployeePayload.getLastName().isBlank()) {
            employee.setLastName(updateEmployeePayload.getLastName());
        }

        if (updateEmployeePayload.getEmailAddress() != null || updateEmployeePayload.getEmailAddress().isBlank()) {
            employee.setEmailAddress(updateEmployeePayload.getEmailAddress());
        }

        return Optional.of(employeeRepository.save(employee));
    }
}
