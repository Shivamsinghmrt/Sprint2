package org.com.model;

import java.math.BigDecimal;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



//@Table(name="question")
@Entity
public class Questions  {
	
	
	@NotNull(message = "Id is blank")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionId;

	@Size(max=4,min=4)
	private ArrayList<String>questionOptions ;
	
	//@Column(name="Title",nullable=false)
	@NotEmpty(message = "QuestionTitle is blank")
	private String questionTitle ;
	@NotNull(message = "questionAnswer is blank")
	private Integer questionAnswer ;
	@NotNull(message = "questionMarks is blank")
	private Integer questionMarks ;

	private Integer chosenAnswer ;
	
	private BigDecimal marksScored ;
	
	
	public Questions(String title, ArrayList<String> answers, Integer correctAns,Integer marks) {
		
		this.questionTitle=title;
		this.questionMarks=marks;
		this.questionAnswer=correctAns;
		this.questionOptions=answers;
		
	}
	 public Questions() {
		// TODO Auto-generated constructor stub
	}
		@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionOptions=" + questionOptions + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}

		public Integer getQuestionId() {
			return questionId;
		}

		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}

		public ArrayList<String> getQuestionOptions() {
			return questionOptions;
		}

		public void setQuestionOptions(ArrayList<String> questionOptions) {
			this.questionOptions = questionOptions;
		}

		public String getQuestionTitle() {
			return questionTitle;
		}

		public void setQuestionTitle(String questionTitle) {
			this.questionTitle = questionTitle;
		}

		public Integer getQuestionAnswer() {
			return questionAnswer;
		}

		public void setQuestionAnswer(Integer questionAnswer) {
			this.questionAnswer = questionAnswer;
		}

		public Integer getQuestionMarks() {
			return questionMarks;
		}

		public void setQuestionMarks(Integer questionMarks) {
			this.questionMarks = questionMarks;
		}

		public Integer getChosenAnswer() {
			return chosenAnswer;
		}

		public void setChosenAnswer(Integer chosenAnswer) {
			this.chosenAnswer = chosenAnswer;
		}

		public BigDecimal getMarksScored() {
			return marksScored;
		}

		public void setMarksScored(BigDecimal marksScored) {
			this.marksScored = marksScored;
		}
	


}
