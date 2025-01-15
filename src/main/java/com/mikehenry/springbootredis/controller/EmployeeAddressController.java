package com.mikehenry.springbootredis.controller;

import com.mikehenry.springbootredis.repository.EmployeeHashingRepository;
import com.mikehenry.springbootredis.entity.Address;
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

import java.util.List;

/**
 * The idea of behind this EmployeeAddressController and EmployeeHashingRepository is to demonstrate how to store, retrieve and delete using
 * Redis Hashing data structure. The EmployeeHashingRepository is a custom repository that extends RedisRepository and provides methods to
 * store, retrieve and delete data using Redis Hashing data structure.
 */

@RestController
@RequestMapping("/employeeAddresses")
public class EmployeeAddressController {

    @Autowired
    EmployeeHashingRepository employeeHashingRepository;

    @PostMapping
    public ResponseEntity<Address> createEmployeeByHash(@RequestBody Address address) {
        String msisdn = address.getMobileNumber();
        return new ResponseEntity<>(employeeHashingRepository.save(msisdn, address), HttpStatus.CREATED);
    }

    @GetMapping("/{msisdn}")
    public ResponseEntity<Address> getAddressByMSISDN(@PathVariable String msisdn) {

        Address dataMap = employeeHashingRepository.getAddressByMobileNumber(msisdn);

        return new ResponseEntity<>(dataMap, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        return new ResponseEntity<>(employeeHashingRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{msisdn}")
    public ResponseEntity<Void> deleteAddressByMSISDN(@PathVariable String msisdn) {

        employeeHashingRepository.delete(msisdn);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
