package org.com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.com.error.RecordAlredyPresentException;
import org.com.error.RecordNotFoundException;
import org.com.model.Test;
import org.com.model.User;
import org.com.services.QuestionsServices;
import org.com.services.TestServices;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins="http://localhost:4200")
public class TestController {
	
	
	
	@Autowired
	private TestServices testService;

	@Autowired
	private UserService userService;
	

	
	

	@PostMapping("/addTest")
	public String saveTest( @Valid @RequestBody Test t ) {
		Optional<Test>findById=testService.findTestById(t.getTestId());
		
		if(!findById.isPresent()) {
			
						
			testService.saveTest(t);
			
			return "Successfully Added";
		}
		else
			throw new RecordAlredyPresentException("Test with this id Already Present");
		}
		
		
	
	
	
	@GetMapping("/allTest")
	public List<Test>getAllQuestions(){
		
		return testService.findAllTest();
		
	}
	
@GetMapping("/{id}")
public ResponseEntity<?> getTestById(@PathVariable("id")int id) {
	
	Optional<Test> findById=testService.findTestById(id);
	try {
	if(findById.isPresent()) {
		Test test=findById.get();
		return new ResponseEntity<Test>(test,HttpStatus.OK);
	}
	else
		throw new RecordNotFoundException("Record not found");
}
	catch(RecordNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

	
	
	
}



@DeleteMapping("/deleteTest/{id}")
public String removeProduct(@PathVariable("id") int id) {
	int uid=testService.getUserID(id);
	Optional<User>findById1=userService.findUserById(uid);
	User u=findById1.get();
	u.setUserTest(null);
	Optional<Test>findById=testService.findTestById(id);
	if(findById.isPresent()) {
		testService.DeleteQuestion(id);
		return "test removed";
	}
	else
		return "test not present";
}




}
