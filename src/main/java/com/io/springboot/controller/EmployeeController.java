package com.io.springboot.controller;

import java.util.Scanner;

public interface EmployeeController {

	void setSc(Scanner scanner);

	void addEmployee();

	void removeEmployee();

	void getAllEmployees();

	void updateEmployee();

	void addClientToEmployee();

}
