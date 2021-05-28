package com.io.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.io.springboot.dto.User;
import com.io.springboot.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SignUpController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		return this.userService.signup(user);
		
	}

}
