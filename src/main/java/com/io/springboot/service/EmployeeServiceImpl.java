package com.io.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.springboot.commonutils.CommonUtils;
import com.io.springboot.dao.EmployeeRepository;
import com.io.springboot.dto.Client;
import com.io.springboot.dto.Employee;
import com.io.springboot.dto.EmployeeClientResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//
//	@Autowired
//	private CommonRepository<Employee,String> employeeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ClientService clientService;

	@Override
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeId(CommonUtils.getUUID());
		return employeeRepository.save(employee);
	}

	@Override
	public void removeEmployee(String employeeId) {
		clientService.removeEmployeeIdFromClients(employeeId);
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void addClientToEmployee(String employeeId, String clientId) {
		Optional<Employee> employee1 = employeeRepository.findById(employeeId);

		Employee employee2;

		if (employee1.isPresent()) {
			employee2 = employee1.get();
			employee2.getClientIds().add(clientId);
			employeeRepository.save(employee2);
		} else {
			System.out.println("employee is not available");
			return;
		}

		clientService.addEmployeeToClientForEmployee(clientId, employeeId);

	}

	@Override
	public void addClientToEmployeeForClient(String employeeId, String clientId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);

		if (employee.isPresent()) {
			Employee employee2 = employee.get();
			employee2.getClientIds().add(clientId);
			employeeRepository.save(employee2);
		} else {
			System.out.println("employee is not available");
		}

	}

	@Override
	public EmployeeClientResponse employeeClients(String employeeId) {
		List<String> assignedClientIdList = employeeRepository.findById(employeeId).get().getClientIds();
		List<Client> assignableClientList = new ArrayList<Client>();
		List<Client> notAssignableClientList = new ArrayList<Client>();

		if (assignedClientIdList.size() != 0) {
			notAssignableClientList = clientService.getAssignedClientList(assignedClientIdList);
			assignableClientList = clientService.getNotAssignedClientList(assignedClientIdList);
		} else {
			assignableClientList = clientService.getAllClients();
		}

		EmployeeClientResponse employeeClientResponse = new EmployeeClientResponse();
		employeeClientResponse.setAssignableClientsList(assignableClientList);
		employeeClientResponse.setNotAssignableClientList(notAssignableClientList);

		return employeeClientResponse;
	}

	@Override
	public List<Employee> getAssinableEmployeeList(List<String> assignedEmployeeIdList) {
		return employeeRepository.findByEmployeeIdIn(assignedEmployeeIdList);
	}

	@Override
	public List<Employee> getNotAssignableEmployeeList(List<String> assignedEmployeeIdList) {
		return employeeRepository.findByEmployeeIdNotIn(assignedEmployeeIdList);
	}

	@Override
	public void removeClientFromEmployee(String employeeId, String clientId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		int i = 0;
		boolean flag = false;
		for (String tempId : employee.getClientIds()) {
			if (tempId.contentEquals(clientId)) {
				flag = true;
				break;
			}
			i++;
		}

		if (flag == true) {
			employee.getClientIds().remove(i);
			employeeRepository.save(employee);
		}

		clientService.removeEmployeeFromClientForEmployee(clientId, employeeId);
	}

	@Override
	public void removeClientFromEmployeeForClient(String employeeId, String clientId) {

		Employee employee = employeeRepository.findById(employeeId).get();

		int i = 0;
		for (String tempId : employee.getClientIds()) {
			if (tempId.contentEquals(clientId)) {
				break;
			}
			i++;
		}
		employee.getClientIds().remove(i);
		employeeRepository.save(employee);
	}

	@Override
	public void removeClientIdFromEmployees(String clientId) {

		for (Employee employee : employeeRepository.findAll()) {

			int i = 0;
			boolean flag = false;
			for (String tempId : employee.getClientIds()) {
				if (tempId.contentEquals(clientId)) {
					flag = true;
					break;
				}
				i++;
			}
			if (flag == true) {
				employee.getClientIds().remove(i);
				employeeRepository.save(employee);
			}

		}

	}

}
