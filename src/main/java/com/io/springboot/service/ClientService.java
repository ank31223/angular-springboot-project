package com.io.springboot.service;

import java.util.List;
import java.util.Optional;

import com.io.springboot.dto.Client;
import com.io.springboot.dto.ClientEmployeeResponse;
import com.io.springboot.dto.Employee;

public interface ClientService {
	

	Client addClient(Client client);

	void removeClient(String clientId);

	List<Client> getAllClients();

	Client updateClient(Client client);

	public void addEmployeeToClientForEmployee(String clientId, String employeeId);

	void addEmployeeToClient(String clientId, String employeeId);

	List<Client> getAssignedClientList(List<String> assignedClientIdList);

	List<Client> getNotAssignedClientList(List<String> assignedClientIdList);

	ClientEmployeeResponse clientEmployees(String clietId);

	void removeEmployeeFromClientForEmployee(String clientId, String employeeId);

	void removeEmployeeFromClient(String clientId, String employeeId);

	void removeEmployeeIdFromClients(String employeeId);

}
