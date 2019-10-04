package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public interface IPigLatin {
	
	/**
	* Sets the input field to userInput (myInput).
	* @param myInput - user&#39;s input.
	*/
	void setInput(String myInput);

	/**
	* Converts user input to PigLatin format.
	* @return - PigLatin form of user input.
	*/
	String textToPigLatin();
}
