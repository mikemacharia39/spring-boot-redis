package com.mikehenry.springbootredis.repository;

import com.mikehenry.springbootredis.model.Employee;
import com.mikehenry.springbootredis.service.EmployeeService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
