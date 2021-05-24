package com.io.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

	@Id
	private String clientId;
	private String clientName;
	private String clientAddress;

	private List<String> employeeIds=new ArrayList<String>();
	
	public Client() {
		super();
	}

	public Client(String clientId, String clientName, String clientAddress, List<String> employeeIds) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.employeeIds = employeeIds;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public List<String> getEmployeeIds() {
		return employeeIds;
	}

	public void setEmployeeIds(List<String> employeeIds) {
		this.employeeIds = employeeIds;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress
				+ ", employeeIds=" + employeeIds + "]";
	}

	

}
