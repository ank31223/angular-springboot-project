package com.io.springboot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.io.springboot.dto.User;

public interface UserService extends UserDetailsService {

	public UserDetails loadUserByUsername(String username);

	public User signup(User user);

	public User getUserByUserName(String username);

}
