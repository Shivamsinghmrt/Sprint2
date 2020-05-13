package org.com.dao;

import org.com.model.Questions;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("questionsRepository")
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
	
		
/*	@Query("select p.question_answer from questions p where p.question_id=Qid") 
	Integer getQuestionsById(@Param("Qid") Integer Qid);
*/	

	@Query(value="select test_test_id from test_test_questions where test_questions_question_id=?1",nativeQuery = true)
	Integer getTestIdByQuestionId(Integer Qid);
	
}
