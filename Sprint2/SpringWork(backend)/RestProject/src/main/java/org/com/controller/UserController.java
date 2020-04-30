package org.com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.com.model.User;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



	
	@RestController
	@RequestMapping("User")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	//@CrossOrigin(origins="http://localhost:4200")
	public class UserController {
		
		@Autowired
		private UserService userService;
		
		
		
		@RequestMapping("/allUsers")
		public List<User>getAllQuestions(){
			
			return userService.findAllUsers();
			
		}
		
		@PostMapping("/addUser")
		public String saveUser( @Valid @RequestBody User U , BindingResult result) {
			Optional<User>findById=userService.findUserById(U.getUserId());
			
			if (result.hasErrors())
			{
				return "Invalid input/inputs";
			}
			else {
			if(!findById.isPresent()) {
				userService.saveUser(U);
				return "Successfully Added";
			}
			else
				return "Already Present";
			}
				
			
		}
		
		
		
		@PostMapping("/authUser")
		public String authUser(@RequestBody User U ) {
			Optional<User>findById=userService.findUserById(U.getUserId());
			
			
			if(findById.isPresent()) {
				User user=findById.get();
				if(U.getUserPassword().equals(user.getUserPassword())) {
					
					if(user.getIsAdmin())
						return "Admin";
					else
						return "User";
				}
				else
					return "Wrong Password";
			}
			else
				return "Wrong ID";
			}
				
			
		}
		
		
		


