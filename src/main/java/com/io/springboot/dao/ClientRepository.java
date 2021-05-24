package com.io.springboot.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.io.springboot.dto.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

	//List<Client> getAssignedClientList(List<String> assignedClientIdList);

//	List<Client> findByEmployeeIdsIn(List<String> assignedClientIdList);
//
//	List<Client> findByEmployeeIdsNotIn(List<String> assignedClientIdList);

	List<Client> findByClientIdIn(List<String> assignedClientIdList);

	List<Client> findByClientIdNotIn(List<String> assignedClientIdList);

}
