package com.spring.cassandra.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cassandra.api.model.User;
import com.spring.cassandra.api.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(1231, "Anamitra", "Barasat", 29));
		users.add(new User(2311, "Sagarika", "Kalindi", 27));
		users.add(new User(4123, "Abhishek", "London", 32));
		users.add(new User(6544, "Vijay", "Toronto", 35));
		userRepository.saveAll(users);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age) {
		return userRepository.findByAgeGreaterThan(age);
	}
	
	
}
