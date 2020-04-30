package org.com.model;

import java.math.BigInteger;

//import java.math.BigDecimal;
//import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	Integer userId ;
	String userName ;
	Boolean isAdmin =false;
	String userPassword ;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", isAdmin=" + isAdmin + ", userPassword="
				+ userPassword + "]";
	}

	
	
	
	//@OneToOne
	//@JoinColumn(name="Test_id")
	//Test userTest ;
	
	 /*Test addTest(Test test){ 
		 
		 if(isAdmin) {
			 
		 }
	 }  

	 Test updateTest(BigInteger testId,Test test){ 
		 
	 }

	 
	 Test deleteTest( BigInteger TestId) {
		 
	 }
	 
	 Boolean assignTest(Long userId,BigInteger TestId){
		 
	 }
	 
	 Questions addQuestions(BigInteger TestId,Questions question) {
		 
	 }
	 
	 Questions updateQuestions(BigInteger TestId,Questions question) {
		 
	 }
		 
	 Questions deleteQuestions(BigInteger TestId,Questions question) {
		 
	 }
		 
	 BigDecimal getResult(Test test){
		 
	 }

}
*/
}