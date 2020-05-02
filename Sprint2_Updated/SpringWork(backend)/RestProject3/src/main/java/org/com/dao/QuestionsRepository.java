package org.com.dao;

import org.com.model.Questions;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("questionsRepository")
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
	
		
/*	@Query("select p.question_answer from questions p where p.question_id=Qid") 
	Integer getQuestionsById(@Param("Qid") Integer Qid);
	
	*/
	

	
}
