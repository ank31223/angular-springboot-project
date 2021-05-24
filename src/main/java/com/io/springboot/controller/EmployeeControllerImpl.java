package com.io.springboot.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.io.springboot.dto.Employee;
import com.io.springboot.service.EmployeeService;

@Component
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private Scanner scanner;

	public EmployeeControllerImpl() {
		super();
	}

	public void setSc(Scanner sc) {
		this.scanner = sc;
	}

	@Override
	public void addEmployee() {
		scanner.nextLine();
		Employee employee = new Employee();
		System.out.println("Enter the Employee Detaills to be added:- ");
		System.out.println("Enter the Name of Employee");
		
		String name = scanner.nextLine();
		employee.setEmployeeName(name);
		
		System.out.println("Enter the gender of Employee");
		employee.setEmployeeGender(scanner.nextLine());
		
		System.out.println("Enter the Age of Employee");
		employee.setEmployeeAge(scanner.nextInt());

		System.out.println("Enter the emailId of Employee");
		employee.setEmployeeEmail(scanner.next()); 
		
		employeeService.addEmployee(employee);
		
	}

	@Override
	public void removeEmployee() {
		scanner.nextLine();
		System.out.println("Enter the id of employee you wnat to delete");
		
		employeeService.removeEmployee(scanner.nextLine());
		
	}

	@Override
	public void getAllEmployees() {
		scanner.nextLine();
		
		for (Employee employee : employeeService.getAllEmployees() ) {
			System.out.println(employee);
		}
		
	}

	@Override
	public void updateEmployee() {
		scanner.nextLine();
		
		Employee employee=new Employee();
		
		System.out.println("Enter the id of employee you wnat to update");
		employee.setEmployeeId(scanner.nextLine());
		
		System.out.println("Enter employee details that is to be addes ");
		
		System.out.println("Enter the name of Employee");
		employee.setEmployeeName(scanner.nextLine());
		
		System.out.println("Enter the Gender of Employee");
		employee.setEmployeeGender(scanner.nextLine());
		
		System.out.println("Enter the Age of Employee");
		employee.setEmployeeAge(scanner.nextInt());
		
		scanner.nextLine();
		
		System.out.println("Enter the emailId of Employee");
		employee.setEmployeeEmail(scanner.nextLine());
		
		System.out.println(employeeService.updateEmployee(employee));
	}

	@Override
	public void addClientToEmployee() {
		scanner.nextLine();
		
		System.out.println("Enter the employee id whom you want to assign client");
		String employeeId=scanner.nextLine();
		
		System.out.println("Enter the client id that is to be assigned under employee");
		String clientId=scanner.nextLine();
		
		employeeService.addClientToEmployee(employeeId,clientId);
		
		
		
	}

}
