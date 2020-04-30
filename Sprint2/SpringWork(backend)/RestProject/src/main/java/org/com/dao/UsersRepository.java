package org.com.dao;

import org.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<User, Integer> { 
	
	

	
}
