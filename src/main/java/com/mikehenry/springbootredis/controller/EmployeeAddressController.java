package com.mikehenry.springbootredis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikehenry.springbootredis.repository.EmployeeHashingRepository;
import com.mikehenry.springbootredis.requests.CreateAddressRequest;
import com.mikehenry.springbootredis.responses.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employeeAddress/")
public class EmployeeAddressController {

    @Autowired
    EmployeeHashingRepository employeeHashingRepository;

    @PostMapping("create")
    public ResponseEntity<Object> createEmployeeByHash(@RequestBody CreateAddressRequest createAddressRequest) {

        String msisdn = createAddressRequest.getMobileNumber();

        Map<String, Object> addressMap = new HashMap<>();
        addressMap.put("address", createAddressRequest.getAddress());
        addressMap.put("city", createAddressRequest.getCity());
        addressMap.put("zipCode", createAddressRequest.getZipCode());
        addressMap.put("country", createAddressRequest.getCountry());
        addressMap.put("msisdn", msisdn);

        employeeHashingRepository.create(msisdn, addressMap);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved address");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getEmployeeAddress/{msisdn}")
    public ResponseEntity<Object> getAddressByMSISDN(@PathVariable String msisdn) {

        Map dataMap = employeeHashingRepository.getUserAddress(msisdn);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved address");
        response.put("data", dataMap);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
