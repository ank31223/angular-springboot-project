package com.io.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.io.springboot.dto.Employee;
import com.io.springboot.dto.EmployeeClientResponse;
import com.io.springboot.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController1 {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping(value = "/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") String employeeId) {
		employeeService.removeEmployee(employeeId);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/addClientToEmployee/{employeeId}/{clientId}")
	public void addClientToEmployee(@PathVariable("employeeId") String employeeId,
			@PathVariable("clientId") String clientId) {
		employeeService.addClientToEmployee(employeeId, clientId);
	}

	@GetMapping("/employeeClients/{employeeId}")
	public EmployeeClientResponse employeeClients(@PathVariable("employeeId") String employeeId) {
		return employeeService.employeeClients(employeeId);
	}

	@GetMapping("/removeClientFromEmployee/{employeeId}/{clientId}")
	public void removeClientFromEmployee(@PathVariable("employeeId") String employeeId,
			@PathVariable("clientId") String clientId) {
		employeeService.removeClientFromEmployee(employeeId, clientId);
	}

}
