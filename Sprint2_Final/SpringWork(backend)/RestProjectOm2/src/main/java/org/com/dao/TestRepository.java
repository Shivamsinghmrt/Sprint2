package org.com.dao;

import org.com.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
	
	//@Query(name="avgCost",value="select avg(p.prdCost) from Product p")
	//public float getavgCost() ;

	
	@Query(value="select user_id from user where user_test_test_id=?1",nativeQuery = true)
	Integer getUserIdByTestId(Integer Tid);
	
	
}