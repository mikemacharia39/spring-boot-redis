package com.mikehenry.springbootredis.repository;

import com.mikehenry.springbootredis.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
