package org.com.services;

import java.util.List;
import java.util.Optional;

import org.com.dao.QuestionsRepository;
import org.com.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServices {

	
	@Autowired
	private QuestionsRepository questionsRepository; 
	

	
	
	public Optional<Questions> findQuesById(Integer id) {

		return questionsRepository.findById(id);
		
	}
	

	public List<Questions> findAllQuestions() {

		return questionsRepository.findAll();
		
	}
	public void saveQuestion(Questions q) {
		questionsRepository.save(q);
		
	}

	public void Deletequestion(Integer id) {
		questionsRepository.deleteById(id);
		
	}
	public Integer getTestID(Integer Qid)
	{
		return questionsRepository.getTestIdByQuestionId(Qid);
	}



}
