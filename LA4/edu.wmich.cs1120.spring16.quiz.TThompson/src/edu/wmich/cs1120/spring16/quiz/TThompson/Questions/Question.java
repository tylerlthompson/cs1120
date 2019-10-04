package edu.wmich.cs1120.spring16.quiz.TThompson.Questions;

public class Question implements IQuestion {

	public String getQuestion() {
		String questionType = this.getClass().getName();
		String type = "";
		if (questionType.contains("BlankFill")) {
			type = "Fill in the blank.";
		}
		else if (questionType.contains("ShortAns")) {
			type = "Type in a one word answer.";
		}
		else if (questionType.contains("TrueFalse")){
			type = "Enter True or False.";
		}
		return this.getText() + "\n" + type;
	}

	public String getAnswer() {
		String questionType = this.getClass().getName();
		if (questionType.contains("BlankFill")) {
			return ((BlankFill) this).getAnswer();
		}
		else if (questionType.contains("ShortAns")) {
			return ((ShortAns) this).getAnswer();
		}
		else if (questionType.contains("TrueFalse")) {
			return String.valueOf(((TrueFalse) this).isAnswer());
		}
		else {
			return "Error in getAnswer()";
		}
		
	}

	public boolean checkAnswer(String answer) {
		answer = answer.toLowerCase();
		if ( answer.equals("t")) {
			answer = "true";
		}
		if (answer.equals("f")) {
			answer = "false";
		}
		if (this.getAnswer().equals(answer)) {
			return true;
		}
		else{
			return false;
		}
	}

	/**
	* 
	* @return the wording of the question as a string
	*/
	final String getText(){
		String questionType = this.getClass().getName();
		if (questionType.contains("BlankFill")) {
			return ((BlankFill) this).getQuestionText();
		}
		else if (questionType.contains("ShortAns")) {
			return ((ShortAns) this).getQuestionText();
		}
		else if (questionType.contains("TrueFalse")){
			return ((TrueFalse) this).getQuestionText();
		}
		else {
			return "Error in getQuestion()";
		}
	}
}
