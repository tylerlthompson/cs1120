package edu.wmich.cs1120.spring16.quiz.TThompson.Quiz;

import java.util.List;

import edu.wmich.cs1120.spring16.quiz.TThompson.Questions.IQuestion;

public class Quiz implements IQuiz {
	
	private List<IQuestion> questions;
	private boolean isStarted;
	private boolean isCompleted;
	private int questionNumber;
	private int numCorrect;

	public void setQuestions(List<IQuestion> questions) {
		this.questions = questions;
	}

	public List<IQuestion> getQuestions() {
		return questions;
	}

	public int getNumberOfQuestions() {
		return questions.size();
	}

	public boolean isStarted() {
		return this.isStarted;
	}

	public boolean isCompleted() {
		return this.isCompleted;
	}

	public boolean hasNextQuestion() {
		if (getQuestionNumber() >= getNumberOfQuestions() - 1) {
			return false;
		}
		else {
			return true;
		}
	}

	public IQuestion getNextQuestion() {
		setQuestionNumber(getQuestionNumber() + 1);
		return getCurrentQuestion();
	}

	public IQuestion getCurrentQuestion() {
		return questions.get(this.questionNumber);
	}

	public String getCurrentAnswer() {
		return getCurrentQuestion().getAnswer();
	}

	public boolean checkAnswer(String answer) {
		if (this.getCurrentQuestion().checkAnswer(answer) == true ) {
			System.out.println("Your answer is correct.");
			setNumCorrect(getNumCorrect() + 1);
			return true;
		}
		else {
			System.out.println("Your answer is incorrect.");
			return false;
		}
	}

	public void reset() {
		this.setQuestionNumber(0);
		this.setNumCorrect(0);
		this.setStarted(false);
		this.setCompleted(false);
	}

	public int getQuestionNumber() {
		return this.questionNumber;
	}
	
	public void setQuestionNumber(int num) {
		this.questionNumber = num;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public int getNumCorrect() {
		return numCorrect;
	}

	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}

}
