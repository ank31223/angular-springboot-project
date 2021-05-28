package com.io.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.springboot.commonutils.CommonUtils;
import com.io.springboot.dao.ClientRepository;
import com.io.springboot.dto.Client;
import com.io.springboot.dto.ClientEmployeeResponse;
import com.io.springboot.dto.Employee;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
//	@Autowired
//	private ClientRepository1 clientRepository;
	
//	@Autowired
//	private CommonRepository<Client,String> clientRepository;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public Client addClient(Client client) {
		client.setClientId(CommonUtils.getUUID());
		return clientRepository.save(client);
	}

	@Override
	public void removeClient(String clientId) {
		employeeService.removeClientIdFromEmployees(clientId);
		clientRepository.deleteById(clientId);

	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void addEmployeeToClientForEmployee(String clientId, String employeeId) {
		Optional<Client> client1 = clientRepository.findById(clientId);

		Client client2;

		if (client1.isPresent()) {
			client2 = client1.get();
			client2.getEmployeeIds().add(employeeId);
			clientRepository.save(client2);
		} else {
			System.out.println("client not available");
			return;
		}

	}

	@Override
	public void addEmployeeToClient(String clientId, String employeeId) {
		Optional<Client> client=clientRepository.findById(clientId);
		
		if(client.isPresent()) {
			Client client2=client.get();
			client2.getEmployeeIds().add(employeeId);
			clientRepository.save(client2);
		}else {
			System.out.println("Client not available");
		}
		
		employeeService.addClientToEmployeeForClient(employeeId,clientId);
	}

	@Override
	public List<Client> getAssignedClientList(List<String> assignedClientIdList) {
		return clientRepository.findByClientIdIn(assignedClientIdList);
		//return clientRepository.getAssignedClientList(assignedClientIdList) ;
	}

	@Override
	public List<Client> getNotAssignedClientList(List<String> assignedClientIdList) {
		return clientRepository.findByClientIdNotIn(assignedClientIdList);
	}

	@Override
	public ClientEmployeeResponse clientEmployees(String clietId) {
		List<String> assignedEmployeeIdList=clientRepository.findById(clietId).get().getEmployeeIds();
		List<Employee> assignableEmployeeList=new ArrayList<Employee>();
		List<Employee> notAssignableEmployeeList=new ArrayList<Employee>();
		
		if(assignedEmployeeIdList.size()!=0) {
			notAssignableEmployeeList=employeeService.getAssinableEmployeeList(assignedEmployeeIdList);
			assignableEmployeeList=employeeService.getNotAssignableEmployeeList(assignedEmployeeIdList);
			
		}else {
			assignableEmployeeList=employeeService.getAllEmployees();
			
		}
		
		ClientEmployeeResponse clientEmployeeResponse=new ClientEmployeeResponse();
		clientEmployeeResponse.setAssignableEmployees(assignableEmployeeList);
		clientEmployeeResponse.setNotAssignableEmployees(notAssignableEmployeeList);

		
		return clientEmployeeResponse;
	}

	@Override
	public void removeEmployeeFromClientForEmployee(String clientId, String employeeId) {

		Client client=clientRepository.findById(clientId).get();
		
		int i=0;
		boolean flag=false;
		
		for (String tempId: client.getEmployeeIds()) {
			if(tempId.contentEquals(employeeId)) {
				flag=true;
				break;
			}
			i++;
		}
		
		if(flag==true) {
			client.getEmployeeIds().remove(i);
			clientRepository.save(client);
		}
		
		
	}

	@Override
	public void removeEmployeeFromClient(String clientId, String employeeId) {
		Client client=clientRepository.findById(clientId).get();
		
		int i=0;
		for (String tempId : client.getEmployeeIds()) {
			if(tempId.contentEquals(employeeId)) {
				break;
			}
			i++;
		}
		client.getEmployeeIds().remove(i);
		clientRepository.save(client);
		
		employeeService.removeClientFromEmployeeForClient(employeeId,clientId);
	}

	@Override
	public void removeEmployeeIdFromClients(String employeeId) {
		
		for (Client client : clientRepository.findAll()) {
			
			int i=0;
			boolean flag=false;
			for (String tempId : client.getEmployeeIds()) {
				if(tempId.contentEquals(employeeId)) {
					flag=true;
					break;
				}
				i++;
			}
			if(flag==true) {
				client.getEmployeeIds().remove(i);
				clientRepository.save(client);
			}
			
	
		}
	}

	

}
