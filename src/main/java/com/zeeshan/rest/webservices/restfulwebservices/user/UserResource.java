package com.zeeshan.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;
	
	
	// Retrieve the details of all users
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping(path="/users")
	public void createUser(@RequestBody User user) {
		service.saveUser(user);
	}
}
