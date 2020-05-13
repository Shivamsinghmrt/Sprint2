package org.com.dao;

import org.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<User, Integer> { 
	
	
	//UPDATE table_name SET column1 = value1, column2 = value2,... 
			//WHERE condition;

	
	 @Query("UPDATE User SET test_id=id1 WHERE user_id=id2")
	    public void assignTest(@Param("id1") Integer id1,@Param("id2") Integer id2);
	
	 
	 
}
