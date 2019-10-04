package edu.wmich.cs1120.spring16.quiz.TThompson.Quiz;

import java.util.*;
import edu.wmich.cs1120.spring16.quiz.TThompson.Questions.IQuestion;

public interface IQuizUI {
	
	/**
	* Creates a quiz out of a set of questions
	* @param questions a list of questions
	* @return the quiz object
	*/
	public IQuiz createQuiz(List<IQuestion> questions);

	/**
	* takeQuiz will go through all of the questions,
	* handle user input, and check the answers
	* @param the quiz to be taken
	*/
	public void takeQuiz(IQuiz quiz);
	
}
