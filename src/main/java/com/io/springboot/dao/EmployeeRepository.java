package com.io.springboot.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.io.springboot.dto.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

	List<Employee> findByEmployeeIdIn(List<String> assignedEmployeeIdList);

	List<Employee> findByEmployeeIdNotIn(List<String> assignedEmployeeIdList);

}
