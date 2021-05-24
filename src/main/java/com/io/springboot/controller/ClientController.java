package com.io.springboot.controller;

import java.util.Scanner;

public interface ClientController {
	void setSc(Scanner scanner);

	void addClient();

	void removeClient();

	void getAllClients();

	void updateClient();

}
