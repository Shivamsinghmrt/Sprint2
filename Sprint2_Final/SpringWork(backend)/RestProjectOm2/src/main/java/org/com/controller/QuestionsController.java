package org.com.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.com.error.RecordAlredyPresentException;
import org.com.error.RecordNotFoundException;
import org.com.model.Questions;
import org.com.model.Test;
import org.com.services.QuestionsServices;
import org.com.services.TestServices;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ques")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionsController {
	
	@Autowired
	private QuestionsServices questionsService;
	
	@Autowired
	private TestServices testService;
	
	
	@RequestMapping("/allQuestions")
	public List<Questions>getAllQuestions(){
		
		return questionsService.findAllQuestions();
		
	}
	
	@PostMapping("/addQuestion/{id1}")
	public String saveQuestion( @Valid @RequestBody Questions Q ,@PathVariable("id1") int id1) {
		Optional<Questions>findById=questionsService.findQuesById(Q.getQuestionId());
		
		
		if(!findById.isPresent()) {
			
			Optional<Test>findBytestId=testService.findTestById(id1);
			
		if(findBytestId.isPresent()) {
			Test t=findBytestId.get();
			t.addQuestion(Q);
			testService.saveTest(t);
			return "Successfully Added ";
		}
		else {
			throw new RecordNotFoundException("Test with this id not Present");
		}
		}
		else
			throw new RecordAlredyPresentException("Question with this id Already Present");
		}
			
		
	
	
	
	
	
	
	@DeleteMapping("/deleteQuestion/{id1}")
	public String removeProduct(@PathVariable("id1") int id1) {
		Optional<Test>findBytestId=testService.findTestById(questionsService.getTestID(id1));
		
		if(findBytestId.isPresent()) {
			Test t=findBytestId.get();
		for(Questions q:t.getTestQuestions()) {
			if(q.getQuestionId()==id1) {
				t.getTestQuestions().remove(q);
				questionsService.Deletequestion(id1);
				
				testService.saveTest(t);
				return "deleted successfully";
			}
		}
		return "can't delete ";
		}
		else
			throw new RecordNotFoundException("test with id = "+questionsService.getTestID(id1)+ " not present");
			
		
	}
	
	
	
	
	
	
	@PutMapping("/updateQuestions")
	public String updateProduct(@Valid @RequestBody Questions Q , BindingResult result ) {
		
			Optional<Questions>findById=questionsService.findQuesById(Q.getQuestionId());
		
		if(findById.isPresent()) {
			questionsService.saveQuestion(Q);
			return "Question  updated";
		}
		else
			throw new RecordNotFoundException("Question not present");
	
}
	
}
	
