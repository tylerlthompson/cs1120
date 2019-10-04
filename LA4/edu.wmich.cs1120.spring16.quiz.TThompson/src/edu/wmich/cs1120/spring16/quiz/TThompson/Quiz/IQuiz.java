package edu.wmich.cs1120.spring16.quiz.TThompson.Quiz;

import java.util.*;
import edu.wmich.cs1120.spring16.quiz.TThompson.Questions.IQuestion;

public interface IQuiz {
	
	/**
	* @param questions list of questions in the quiz
	*/
	public void setQuestions(List<IQuestion> questions);

	/**
	* @return List of questions in the quiz
	*/
	public List<IQuestion> getQuestions();

	/**
	* @return number of questions in the quiz
	*/
	public int getNumberOfQuestions();

	/**
	* @return True if a quiz has been started. False otherwise
	*/
	public boolean isStarted();

	/**
	* @return True if the last question has been answer, false otherwise.
	*/
	public boolean isCompleted();

	/**
	* @return true if there is a question after the current one, false otherwise.
	*/
	public boolean hasNextQuestion();

	/**
	* Sets isCompleted to false if there are no more questions after returning;
	* @return the next question that should be answered.
	*/
	public IQuestion getNextQuestion();

	/**
	* sets the isStarted variable to true if it is false and returns the current question
	* @return the current question waiting for an answer.
	*/
	public IQuestion getCurrentQuestion();
	
	/**
	* @return the answer to the current question
	*/
	public String getCurrentAnswer();

	/**
	* checks if the user input matches the question's answer.
	* @param answer the user input as a string
	* @return true if the answer matches, false otherwise.
	*/
	public boolean checkAnswer(String answer);

	/**
	* Resets the number of incorrect answers and the current question to 0,
	* isStarted and isCompleted to false;
	*/
	public void reset();

	/**
	* @return the number of the current question
	*/
	public int getQuestionNumber();
	
}
