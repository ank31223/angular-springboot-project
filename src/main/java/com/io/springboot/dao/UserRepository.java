package com.io.springboot.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.io.springboot.dto.User;

public interface UserRepository extends MongoRepository<User,String> {
	
	public User findByUsername(String username);

}
