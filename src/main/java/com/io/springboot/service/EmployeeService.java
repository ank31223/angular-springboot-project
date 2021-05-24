package com.io.springboot.service;

import java.util.List;

import com.io.springboot.dto.Employee;
import com.io.springboot.dto.EmployeeClientResponse;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	void removeEmployee(String employeeId);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee employee);

	void addClientToEmployee(String employeeId, String clientId);

	void addClientToEmployeeForClient(String employeeId, String clientId);

	EmployeeClientResponse employeeClients(String employeeId);

	List<Employee> getAssinableEmployeeList(List<String> assignedEmployeeIdList);

	List<Employee> getNotAssignableEmployeeList(List<String> assignedEmployeeIdList);

	void removeClientFromEmployee(String employeeId, String clientId);

	void removeClientFromEmployeeForClient(String employeeId, String clientId);


	void removeClientIdFromEmployees(String clientId);

}
