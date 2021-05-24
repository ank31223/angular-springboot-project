package com.io.springboot.bootstrap;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.io.springboot.controller.ClientController;
import com.io.springboot.controller.EmployeeController;
import com.io.springboot.controller.EmployeeControllerImpl;
import com.io.springboot.dao.EmployeeRepository;

@SpringBootApplication(scanBasePackages = "com.io.springboot")
@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		Scanner scanner = new Scanner(System.in);

		EmployeeController employeeController = context.getBean("employeeControllerImpl", EmployeeControllerImpl.class);
		ClientController clientController=context.getBean("clientControllerImpl",ClientController.class);
		
		employeeController.setSc(scanner);
		clientController.setSc(scanner);
		
		while (true) {
			System.out.print("1.Client Management System \n");
			System.out.print("2.Employee Management System\n");
			int choice = scanner.nextInt();
			if (choice == 1) {
				while (true) {
					System.out.print(
							" Enter the below choices to fetch/update Client \n 1.addClient\n 2.deleteClientByCompanyName\n 3.updateClientByCompanyName\n 4.showAllClientsDetails \n 5.add Employee to the client \n 6.get details of working employees under clients \n 7.remove empoyee from the client \n to the client for exit=-1 \n");
					choice = scanner.nextInt();
					if (choice == -1) {
						break;
					}

					switch (choice) {
					case 1:
						clientController.addClient();
						break;
					case 2:
						clientController.removeClient();
						break;
					case 3:
						clientController.updateClient();
						
						break;
					case 4:
						clientController.getAllClients();
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					}
				}

			}
			if (choice == 2) {
				while (true) {
					System.out.print(
							"\n Enter the below choices to fetch/update Employee\n 1.addEmployee\n 2.deleteEmployee\n 3.updateEmployee\n 4.showAllEmployees \n 5.add clients to the employee \n 6.show all clients under this employeess \n7.delete Client from Employee \n for exit=-1 \n");
					choice = scanner.nextInt();
					if (choice == -1) {
						break;
					}

					switch (choice) {
					case 1:
						employeeController.addEmployee();
						break;
					case 2:
						employeeController.removeEmployee();
						break;
					case 3:
						employeeController.updateEmployee();
						
						break;
					case 4:
						employeeController.getAllEmployees();
						break;
					case 5:
						employeeController.addClientToEmployee();
						break;
					case 6:
						break;
					case 7:
						break;
					}
				}

			}


		}


	}

}
