package org.com.services;

import java.util.List;
import java.util.Optional;

import org.com.dao.UsersRepository;
import org.com.model.Questions;
import org.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
	private UsersRepository userRepositoty;
	
	
	public Optional<User> findUserById(Integer id) {

		return userRepositoty.findById(id);
		
	}
	

	public List<User> findAllUsers() {

		return userRepositoty.findAll();
		
	}
	
	public void saveUser(User user) {
		userRepositoty.save(user);
		
	}

}
