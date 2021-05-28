package com.io.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.io.springboot.dto.Client;
import com.io.springboot.dto.ClientEmployeeResponse;
import com.io.springboot.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController1 {

	@Autowired
	private ClientService clientService;

	@GetMapping("/getAllClients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}

	@DeleteMapping("/deleteClient/{clientId}")
	public void deleteClient(@PathVariable("clientId") String clientId) {
		clientService.removeClient(clientId);
	}

	@PutMapping("/updateClient")
	public Client updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@GetMapping("/addEmployeeToClient/{clientId}/{employeeId}")
	public void addEmployeeToClient(@PathVariable("clientId") String clientId,
			@PathVariable("employeeId") String employeeId) {
		clientService.addEmployeeToClient(clientId, employeeId);
	}

	@GetMapping("/clientEmployees/{clientId}")
	public ClientEmployeeResponse clientEmployees(@PathVariable("clientId") String clietId) {
		return clientService.clientEmployees(clietId);
	}

	@GetMapping("/removeEmployeeFromClient/{clientId}/{employeeId}")
	public void removeEmployeeFromCLient(@PathVariable("clientId") String clientId,
			@PathVariable("employeeId") String employeeId) {
		clientService.removeEmployeeFromClient(clientId, employeeId);
	}

}
