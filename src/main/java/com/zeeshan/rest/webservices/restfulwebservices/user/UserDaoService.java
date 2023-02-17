package com.zeeshan.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// create a static list to save data for now
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=users.size();
	static {
		users.add(new User(++userCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(++userCount,"Jim",LocalDate.now().minusYears(20)));
	}
	
	
	// Return all the users in the static list
	public List<User> findAll(){
		return users;
	}
	
	// Save user to the list
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		
		Predicate<? super User> predicate = user ->
				user.getId()==id;
		return users.stream().filter(predicate ).findFirst().get();
	}
}
