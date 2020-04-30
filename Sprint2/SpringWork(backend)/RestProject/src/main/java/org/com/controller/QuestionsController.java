package org.com.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.com.model.Questions;
import org.com.services.QuestionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ques")
@CrossOrigin("http://localhost:4200")
public class QuestionsController {
	
	@Autowired
	private QuestionsServices questionsService;
	
	
	
	@RequestMapping("/allQuestions")
	public List<Questions>getAllQuestions(){
		
		return questionsService.findAllQuestions();
		
	}
	
	@PostMapping("/addQuestion")
	public String saveQuestion( @Valid @RequestBody Questions Q , BindingResult result) {
		Optional<Questions>findById=questionsService.findQuesById(Q.getQuestionId());
		
		if (result.hasErrors())
		{
			return "Invalid input/inputs";
		}
		else {
		if(!findById.isPresent()) {
			questionsService.saveQuestion(Q);
			return "Successfully Added";
		}
		else
			return "Already Present";
		}
			
		
	}
	
	
	@DeleteMapping("/deleteQuestion/{id}")
	public String removeProduct(@PathVariable("id") int id) {
		Optional<Questions>findById=questionsService.findQuesById(id);
		if(findById.isPresent()) {
			questionsService.DeleteQuestion(id);
			return "product removed";
		}
		else
			return "product not present";
	}

	@PutMapping("/updateQuestions")
	public String updateProduct(@Valid @RequestBody Questions Q , BindingResult result ) {
		
		if (result.hasErrors())
			return "Invalid Input/Inputs";
		else {
			Optional<Questions>findById=questionsService.findQuesById(Q.getQuestionId());
		
		if(findById.isPresent()) {
			questionsService.saveQuestion(Q);
			return "Question  updated";
		}
		else
			return "Question not present";
	
	
}
	
}
	}