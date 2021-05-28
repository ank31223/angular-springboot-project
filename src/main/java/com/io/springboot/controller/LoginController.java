package com.io.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.io.springboot.commonutils.JwtUtils;
import com.io.springboot.dto.LoginRequest;
import com.io.springboot.dto.LoginResponse;
import com.io.springboot.dto.User;
import com.io.springboot.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtil;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) throws Exception {

		System.out.print(loginRequest);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials....");
		}

		UserDetails userDetails = this.userService.loadUserByUsername(loginRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);

		System.out.println("Jwt  " + token);
		User user = this.userService.getUserByUserName(userDetails.getUsername());
		user.setPassword(null);
		user.setAge(0);
		user.setCity(null);
		user.setId(null);
		return ResponseEntity.ok(new LoginResponse(token, user));
	}

}
