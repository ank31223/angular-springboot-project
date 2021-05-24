package com.io.springboot.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.io.springboot.dto.Client;
import com.io.springboot.dto.Employee;
import com.io.springboot.service.ClientService;

@Component
public class ClientControllerImpl implements ClientController {

	@Autowired
	private ClientService clientService;

	private Scanner scanner;

	@Override
	public void setSc(Scanner scanner) {
		this.scanner = scanner;

	}

	@Override
	public void addClient() {

		System.out.println("Enter the Clients Detaills to be added:- ");
		scanner.nextLine();

		System.out.println("Enter the name of Client");
		String clientName = scanner.nextLine();

		System.out.println("Enter the Address of Client");
		String clientAddress = scanner.nextLine();

		Client client = new Client();
		client.setClientName(clientName);
		client.setClientAddress(clientAddress);

		clientService.addClient(client);

	}

	@Override
	public void removeClient() {
		scanner.nextLine();
		System.out.println("Enter the id of client you want to delete");

		clientService.removeClient(scanner.nextLine());

	}

	@Override
	public void getAllClients() {
		scanner.nextLine();

		for (Client client : clientService.getAllClients()) {
			System.out.println(client);
		}

	}

	@Override
	public void updateClient() {
		scanner.nextLine();

		Client client=new Client();

		System.out.println("Enter the id of Client you want to update");
		client.setClientId(scanner.nextLine());

		System.out.println("Enter client details that is to be addes ");

		System.out.println("Enter the name of Client");
		client.setClientName(scanner.nextLine());

		System.out.println("Enter the address of client");
		client.setClientAddress(scanner.nextLine());
		
		clientService.updateClient(client);

	}

}
