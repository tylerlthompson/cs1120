package edu.wmich.cs1120.spring16.quiz.TThompson.Questions;

public class BlankFill extends Question {
	
	private String questionText;
	private String answer;
	
	public BlankFill(String questionText, String answer) {
		setQuestionText(questionText);
		setAnswer(answer);
	}
	
	public String getQuestionText() {
		return this.questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswer() {
		return this.answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
