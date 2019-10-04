package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public interface IController {
	
	/**
	* Sets the SMS object.
	* @param mySms - the object used to set the SMS object.
	*/
	void setSmsObject(ISms mySms);

	/**
	* Sets the PigLatin object.
	* @param myPigLatin - the object used to set the PigLatin object.
	*/
	void setPigLatinObject(IPigLatin myPigLatin);

	/**
	* This method displays the menu to the user, uses a try-catch block to read in the
	* input from the user and, based on the user&#39;s choice, calls one of the three
	* &quot;convert...&quot; methods in this class. This method should keep prompting the user
	* for input until the user wants to quit.
	 * @throws EmtpyStringException 
	 * @throws IllegalArgumentException 
	*/
	void runProgram() throws IllegalArgumentException, EmtpyStringException;

	/**
	* This method prompts the user for text to be converted into SMS-text. It uses the
	* SMS object in this class to call the appropriate method in the SMS class to do
	* the conversion from text to SMS-text.
	 * @throws EmtpyStringException 
	*/
	void convertTextToSMS() throws EmtpyStringException;

	/**
	* This method prompts the user for SMS-text to be converted into normal text. It
	* uses the SMS object in this class to call the appropriate method in the SMS class
	* to do the conversion from SMS-text to normal text.
	 * @throws EmtpyStringException 
	*/
	void convertSMSToText() throws EmtpyStringException;

	/**
	* This method prompts the user for a word to be converted to PigLatin. It uses the
	* PigLatin object to call the appropriate method in the PigLatin class to do the
	* required conversion. To convert to PigLatin, remove the first letter of the word
	* and append to what is left of the word, then append &quot;ay&quot;. So, &quot;hello&quot; becomes
	* &quot;ellohay&quot;.
	 * @throws EmtpyStringException 
	*/
	void convertTextToPigLatin() throws EmtpyStringException;
}
