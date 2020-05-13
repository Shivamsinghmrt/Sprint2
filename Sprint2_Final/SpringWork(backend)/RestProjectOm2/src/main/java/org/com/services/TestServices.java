package org.com.services;

import java.util.List;
import java.util.Optional;

import org.com.dao.TestRepository;
import org.com.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServices {

	
	
	@Autowired
	TestRepository testRepository;
	
	
	
	
	public void saveTest(Test t) {
		testRepository.save(t);
		
	}
	
	public List<Test> findAllTest() {

		return testRepository.findAll();
		
	}
	public Integer getUserID(Integer Qid)
	{
		return testRepository.getUserIdByTestId(Qid);
	}


	
	public Optional<Test> findTestById(Integer id) {

		return testRepository.findById(id);
		
	}
	public void DeleteQuestion(Integer id) {
		testRepository.deleteById(id);
	
		
	}

	
}
