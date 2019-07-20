package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.spring_boot_soap_example.User;

@Service
public class UserService {
	public static final Map<String, User> users = new HashMap<String, User>();

	@PostConstruct // This particular method will be called one the spring boot application is up
	public void initialize() {
		// Called for the first time
		User user = new User();
		user.setEmployeeId(101);
		user.setName("Peter");
		user.setSalary(20000);

		users.put(user.getName(), user);
		user = new User();
		user.setEmployeeId(101);
		user.setName("SAM");
		user.setSalary(30000);

		users.put(user.getName(), user);
		user = new User();
		user.setEmployeeId(101);
		user.setName("RAM");
		user.setSalary(40000);

		users.put(user.getName(), user);

	}

	public User getUser(String name) {
		return users.get(name);
	}
}
