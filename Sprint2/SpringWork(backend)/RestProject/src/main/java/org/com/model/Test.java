/*package org.com.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	
	private BigInteger testId ;
	private String testTitle ;
	private LocalTime testDuration ;
	private BigDecimal testTotalMarks ;
	private BigDecimal testMarksScored ;
	private Questions currentQuestion ;
	private LocalDateTime startTime ;
	private LocalDateTime endTime ;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="Test")
	@JoinColumn(name="T_id")
	Set<Questions> testQuestions ;

	
}
*/