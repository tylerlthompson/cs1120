package edu.wmich.cs1120.spring16.quiz.TThompson.Questions;

public interface IQuestion {

	/**
	* @return returns the question text plus any other extra prompts or details.
	*/
	public String getQuestion();

	/**
	* 
	* @return the answer as a string
	*/
	public String getAnswer();

	/**
	* 
	* @param answer the answer entered by the user
	* @return true if the answer is correct, false otherwise.
	*/
	public boolean checkAnswer(String answer);
	
}
