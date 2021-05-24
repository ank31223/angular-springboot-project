package com.io.springboot.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClientEmployeeResponse {
	List<Employee> assignableEmployees;
	List<Employee> notAssignableEmployees;
	
	public ClientEmployeeResponse() {
		super();
	}

	public List<Employee> getAssignableEmployees() {
		return assignableEmployees;
	}

	public void setAssignableEmployees(List<Employee> assignableEmployees) {
		this.assignableEmployees = assignableEmployees;
	}

	public List<Employee> getNotAssignableEmployees() {
		return notAssignableEmployees;
	}

	public void setNotAssignableEmployees(List<Employee> notAssignableEmployees) {
		this.notAssignableEmployees = notAssignableEmployees;
	}

}
