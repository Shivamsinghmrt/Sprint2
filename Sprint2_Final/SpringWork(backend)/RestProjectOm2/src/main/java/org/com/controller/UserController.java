package org.com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.com.error.RecordAlredyPresentException;
import org.com.error.RecordNotFoundException;
import org.com.model.Questions;
import org.com.model.Test;
import org.com.model.User;
import org.com.services.TestServices;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



	
	@RestController
	@RequestMapping("User")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	//@CrossOrigin(origins="http://localhost:4200")
	public class UserController {
		
		@Autowired
		private UserService userService;
		
		@Autowired
		private TestServices testService;
		
		
		@RequestMapping("/allUsers")
		public List<User>getAllQuestions(){
			
			return userService.findAllUsers();
			
		}
		
		@PostMapping("/addUser")
		public String saveUser( @Valid @RequestBody User U) {
			Optional<User>findById=userService.findUserById(U.getUserId());
			
			
			if(!findById.isPresent()) {
				userService.saveUser(U);
				return "Successfully Added";
			}
			else
				throw new RecordAlredyPresentException("User with this id Already Present");
			}
				
			
		
		
		@GetMapping("/getTest/{id}")
		public Test getTest(@PathVariable("id")int id) {
			Optional<User>findById=userService.findUserById(id);
			User u=findById.get();
			return u.getUserTest();
		}
		
		@PostMapping("/authenticateUser")
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
				

		
	
		
		@PutMapping("/assignTesttoUser/{id1}/{id2}")
		public String testAssingnment(@PathVariable("id1")int id1,@PathVariable("id2")int id2  ) {
			Optional<User>findById=userService.findUserById(id2);
			Optional<Test>findById1=testService.findTestById(id1);
			
			if(findById.isPresent()) {
				User user=findById.get();
				
					
					if(user.getIsAdmin())
						return "user is a admin";
					else {
						if(findById1.isPresent()) {
						Test test=findById1.get();
						user.setUserTest(test);
						userService.saveUser(user);
					
						return "test assigned";
						}
						else
							throw new RecordNotFoundException("test with id = "+id1+ " not present");
						
					}
					
			}		
			else
				return "Wrong user ID";
			}
		
		
		
		@GetMapping("/getTestOfUser/{id1}")
		public Test getassignedTest(@PathVariable("id1")int id1){
			
			Optional<User>findById=userService.findUserById(id1);
			if(findById.isPresent()) {
				User user=findById.get();
			
			return user.getUserTest();
		}
			else
				return null;
		}
		@DeleteMapping("/deleteUser/{id}")
		public String removeProduct(@PathVariable("id") int id) {
			Optional<User>findById=userService.findUserById(id);
			if(findById.isPresent()) {
				userService.DeleteUser(id);
				return "User removed";
			}
			else
				throw new RecordNotFoundException("User with id = "+id+ " not present");
			
		}

		
		
		}
		
		
		
	

