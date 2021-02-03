package com.company.fleetApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.fleetApp.models.User;
import com.company.fleetApp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;
	

	public List<User> findAll(){
		return userRepository.findAll();
	}	
	

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	
	

	public void delete(int id) {
		userRepository.deleteById(id);
	}
	

	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
