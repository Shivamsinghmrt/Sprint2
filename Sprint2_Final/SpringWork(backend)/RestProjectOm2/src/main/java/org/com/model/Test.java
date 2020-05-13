package org.com.model;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="test_Id",unique=true)
	private Integer testId ;
    @NotNull
	private String testTitle ;
    
	private LocalTime testDuration ;
	private BigDecimal testTotalMarks ;
	private BigDecimal testMarksScored ;
	private LocalDateTime startTime ;
	private LocalDateTime endTime ;

	//@NotFound(action = NotFoundAction.IGNORE)
	 /*@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "test",targetEntity=Questions.class)
	 @OnDelete(action = OnDeleteAction.CASCADE)*/
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	

	  private Set<Questions>testQuestions  = new HashSet<>();
	
	@OneToOne(fetch = FetchType.EAGER)
	private User user;

	
public void addQuestion(Questions q){
	this.testQuestions.add(q);
}

	
	public Test() {}

	public Integer getTestId() {
		return testId;
	}


	public void setTestId(Integer testId) {
		this.testId = testId;
	}


	public String getTestTitle() {
		return testTitle;
	}


	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}


	public LocalTime getTestDuration() {
		return testDuration;
	}


	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}


	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}


	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}


	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}


	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}


	

	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public Set<Questions> getTestQuestions() {
		return testQuestions;
	}


	public void setTestQuestions(Set<Questions> testQuestions) {
		
		this.testQuestions = testQuestions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testTotalMarks=" + testTotalMarks + ", testMarksScored=" + testMarksScored + ", startTime="
				+ startTime + ", endTime=" + endTime + ", testQuestions=" + testQuestions + ", user=" + user + "]";
	}


	public Test(Integer testId, @NotNull String testTitle, LocalTime testDuration, BigDecimal testTotalMarks,
			BigDecimal testMarksScored, LocalDateTime startTime, LocalDateTime endTime, Set<Questions> testQuestions,
			User user) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.testQuestions = testQuestions;
		this.user = user;
	}

	
}
//"endTime":0000-00-00-00-00-00.000,
//"startTime":"0000-00-00-00-00-00.000",