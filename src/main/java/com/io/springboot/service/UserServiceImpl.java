package com.io.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.io.springboot.commonutils.CommonUtils;
import com.io.springboot.dao.UserRepository;
import com.io.springboot.dto.MyUserDetails;
import com.io.springboot.dto.User;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	CommonRepository<User,String> userRepository;
//	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User is not Found");
		}
		return new MyUserDetails(user);
	}

	public User signup(User user) {
		user.setId(CommonUtils.getUUID());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return this.userRepository.save(user);

	}

	@Override
	public User getUserByUserName(String username) {
		
		return  this.userRepository.findByUsername(username);
	}

}
