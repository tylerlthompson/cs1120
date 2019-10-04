package edu.wmich.cs1120.spring16.quiz.TThompson.Questions;

public class TrueFalse extends Question {
	
	private String questionText;
	private boolean answer;
	
	public TrueFalse(String questionText, boolean answer) {
		setQuestionText(questionText);
		setAnswer(answer);
	}
	
	public String getQuestionText() {
		return this.questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public boolean isAnswer() {
		return this.answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

}
