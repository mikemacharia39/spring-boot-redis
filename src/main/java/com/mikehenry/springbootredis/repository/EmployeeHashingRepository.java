package com.mikehenry.springbootredis.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class EmployeeHashingRepository {

    private final HashOperations<String, String, Object> hashOperations;

    private final ValueOperations<String, Object> valueOperations;

    public EmployeeHashingRepository(RedisTemplate<String, Object> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.valueOperations = redisTemplate.opsForValue();
    }

    // ============== HASH OPERATIONS ====================

    public void create(String msisdn, Map<String, Object> addressData) {
        hashOperations.put("EMPLOYEE_ADDRESS", msisdn, addressData);
    }

    public Map getUserAddress(String msisdn) {
        return (Map) hashOperations.get("EMPLOYEE_ADDRESS", msisdn);
    }

    // ============ VALUE OPERATIONS ==================

    /**
     * set values
     * @param msisdn employee mobile number
     * @param data JSON data
     */
    public void setValue(String msisdn, String data) {
        valueOperations.set("DISPOSABLE_DATA_"+msisdn, data);
    }

    /**
     * Set value with expiry
     * @param msisdn employee mobile number
     * @param data JSON Data
     */
    public void setValueWithExpireTime(String msisdn, String data, long timeout, TimeUnit timeUnit) {
        valueOperations.set("DISPOSABLE_DATA_" + msisdn, data, timeout, timeUnit);
    }

    /**
     * Get Value from redis using key
     * @param msisdn mobileNumber
     */
    public String getValueData(String msisdn) {
        return (String) valueOperations.get("DISPOSABLE_DATA_"+msisdn);
    }
}
