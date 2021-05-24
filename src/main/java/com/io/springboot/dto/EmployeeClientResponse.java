package com.io.springboot.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeClientResponse {
	List<Client> assignableClientsList;
	List<Client> notAssignableClientList;
	
	public EmployeeClientResponse() {
		super();
	}
	
	public List<Client> getAssignableClientsList() {
		return assignableClientsList;
	}
	public void setAssignableClientsList(List<Client> assignableClientsList) {
		this.assignableClientsList = assignableClientsList;
	}
	public List<Client> getNotAssignableClientList() {
		return notAssignableClientList;
	}
	public void setNotAssignableClientList(List<Client> notAssignableClientList) {
		this.notAssignableClientList = notAssignableClientList;
	}
	
}
