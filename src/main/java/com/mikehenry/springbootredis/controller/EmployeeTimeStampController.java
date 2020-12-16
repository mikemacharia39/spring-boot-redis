package com.mikehenry.springbootredis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikehenry.springbootredis.repository.EmployeeHashingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/employeeTimeStamp")
public class EmployeeTimeStampController {

    @Autowired
    EmployeeHashingRepository employeeHashingRepository;

    @PostMapping("/save/{msisdn}")
    public ResponseEntity<Object> saveEmployeeTimeStamp(@PathVariable String msisdn, @RequestBody String timeStamp) {

        employeeHashingRepository.setValue(msisdn, timeStamp);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved timestamp");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/saveTemp/{msisdn}")
    public ResponseEntity<Object> saveEmployeeTimeStampTemporary(@PathVariable String msisdn, @RequestBody String timeStamp) {

        employeeHashingRepository.setValueWithExpireTime(msisdn, timeStamp, 7, TimeUnit.DAYS);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved timestamp");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get/{msisdn}")
    public ResponseEntity<Object> getTimeStampInfo(@PathVariable String msisdn) throws JsonProcessingException {

        String timestampData = employeeHashingRepository.getValueData(msisdn);

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> data = objectMapper.readValue(timestampData, Map.class);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "Successfully saved timestamp");
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
