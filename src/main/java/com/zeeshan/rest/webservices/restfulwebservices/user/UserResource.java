package com.zeeshan.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserDaoService service;

	// Retrieve the details of all users

	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@DeleteMapping(path = "/users/{id}")
	
	public void  deleteUser(@PathVariable int id) {
		service.deleteById(id);
		
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null)
				throw new UserNotFoundException("id: "+id);
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.saveUser(user);
		// Post request response is now 201
		// We furthure improve this to return location or url

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
