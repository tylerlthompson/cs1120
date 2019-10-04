package edu.wmich.cs1120.spring16.quiz.TThompson.Quiz;

import java.util.*;

import edu.wmich.cs1120.spring16.quiz.TThompson.Questions.IQuestion;

public class QuizUI implements IQuizUI {

	public IQuiz createQuiz(List<IQuestion> questions) {
		IQuiz newQuiz = new Quiz();
		newQuiz.reset();
		newQuiz.setQuestions(questions);
		return newQuiz;
	}

	public void takeQuiz(IQuiz quiz) {
		((Quiz) quiz).setStarted(true);
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		int currentNum = quiz.getQuestionNumber();
		int questNum = currentNum + 1;
		System.out.println("Question " + questNum + ": " + quiz.getCurrentQuestion().getQuestion());
		System.out.print("Enter your answer: ");
		String answer = kb.nextLine();
		quiz.checkAnswer(answer);
		if ( quiz.hasNextQuestion() == true) {
			quiz.getNextQuestion();
			takeQuiz(quiz);
		}
		else {
			((Quiz) quiz).setCompleted(true);
			System.out.println("You have finished the exam");
			System.out.println("Out of " + quiz.getNumberOfQuestions() + " questions, you answered " + ((Quiz) quiz).getNumCorrect() + " correctly.\n");
		}
	}
	
	
}
