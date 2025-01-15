package com.mikehenry.springbootredis.controller;

import com.mikehenry.springbootredis.repository.EmployeeHashingRepository;
import com.mikehenry.springbootredis.requests.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * The idea of behind this EmployeeAddressController and EmployeeHashingRepository is to demonstrate how to store, retrieve and delete using
 * Redis Hashing data structure. The EmployeeHashingRepository is a custom repository that extends RedisRepository and provides methods to
 * store, retrieve and delete data using Redis Hashing data structure.
 */

@RestController
@RequestMapping("/employeeAddress")
public class EmployeeAddressController {

    @Autowired
    EmployeeHashingRepository employeeHashingRepository;

    @PostMapping
    public ResponseEntity<Object> createEmployeeByHash(@RequestBody AddressDto address) {

        String msisdn = address.getMobileNumber();

        employeeHashingRepository.create(msisdn, address);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved address");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{msisdn}")
    public ResponseEntity<AddressDto> getAddressByMSISDN(@PathVariable String msisdn) {

        AddressDto dataMap = employeeHashingRepository.getAddressByMobileNumber(msisdn);

        return new ResponseEntity<>(dataMap, HttpStatus.OK);
    }

    @DeleteMapping("/{msisdn}")
    public ResponseEntity<Void> deleteAddressByMSISDN(@PathVariable String msisdn) {

        employeeHashingRepository.delete(msisdn);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
