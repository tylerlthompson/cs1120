package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

import java.util.Scanner;

public class Controller implements IController {

	private IPigLatin myPigLatin;
	private ISms mySms;
	private Scanner kb;
	
	public Controller(ISms mySms, IPigLatin myPigLatin) {
		setPigLatinObject(myPigLatin);
		setSmsObject(mySms);
	}
	
	@Override
	public void setPigLatinObject(IPigLatin myPigLatin) {
		this.myPigLatin = myPigLatin;
	}
	
	@Override
	public void setSmsObject(ISms mySms) {
		this.mySms = mySms;
	}

	@Override
	public void runProgram() throws IllegalArgumentException, EmtpyStringException {
		this.kb = new Scanner(System.in);
		while (true) {
			printMenu("main");
			int input = getChoice();
			if (input == 0) {
				System.out.println("Program terminating ...");
				this.kb.close();
				System.exit(0);
			}
			else if (input == 1) {
				this.convertTextToSMS();
			}
			else if (input == 2) {
				this.convertSMSToText();
			}
			else if (input == 3) {
				this.convertTextToPigLatin();
			}
		}
	}

	@Override
	public void convertTextToSMS() throws EmtpyStringException {
		System.out.print("Input Text to be converted to SMS: ");
		String input = this.getInput();
		this.mySms.setInput(input);
		System.out.print("Your SMS is: \n" + this.mySms.textToSMS() + "\n");
	}

	@Override
	public void convertSMSToText() throws EmtpyStringException {
		System.out.print("Input SMS to be converted to Text: ");
		String input = this.getInput();
		this.mySms.setInput(input);
		System.out.println("Your Text is: \n" + this.mySms.smsToText() + "\n");
	}

	@Override
	public void convertTextToPigLatin() throws EmtpyStringException {
		System.out.print("Input Text to be converted to PigLatin: ");
		String input = this.getInput();
		this.myPigLatin.setInput(input);
		System.out.print("Your text in pigLatin is: \n" + this.myPigLatin.textToPigLatin() + "\n");
	}
	
	/**
	 * prints the menu specified by the parameter
	 * @param menu valid menus are: main, error
	 */
	public static void printMenu(String menu){
		if (menu == "main") {
			System.out.println("What would you like to do? \nChoose from the following menu: \n1 - Text to SMS conversion \n2 - SMS to Text conversion \n3 - Text to PigLatin conversion \n0 - Quit");
		}
		else if (menu == "error") {
			System.out.println("You must enter 1, 2, 3, or 0. Please try again");
		}
		else {
			System.out.println("Bad input for printMenu()");
		}
	}
	
	/**
	 * gets user input of type String, validates it, and then returns it if it is valid, otherwise will keep asking for input.
	 * @return validated user input.
	 * @throws EmtpyStringException
	 */
	public String getInput() throws EmtpyStringException {
		String input = this.kb.nextLine();
		if (validateInput(input, "emptyString") == true) {
			return input;
		}
		else {
			System.out.println("Error: Input cannot be an empty string.\nPlease input text again: ");
			return getInput();
		}
	}
	
	/**
	 *method gets user input, validates it, and returns that input if it's valid. Otherwise it will keep asking for input. 
	 * @return	returns the user input of type int
	 * @throws EmtpyStringException 
	 */
	public int getChoice() throws EmtpyStringException {		
		int input = 0;
		System.out.print("Enter Choice: ");
		String inputString = this.kb.nextLine();
			if ( validateInput(inputString, "integer") == true) {
				input = Integer.parseInt(inputString);
				if (input == 1 | input == 2 | input == 3 | input == 4 | input == 0) {
					return input;
				}
				else {
					return getChoice();
				}
			}
			if ( validateInput(inputString, "integer") == false) {
				printMenu("error");
				
				return getChoice();
			}
		return input;
	}//end getChoice()
	
	/**
	 * method validates input and returns false if input is not valid and true if the input is valid.
	 * @param input	string containing the data you would like to verify
	 * @param validationType	the type of data you want to verify your input with. Accepted values are: integer | double | filelocation
	 * @return returns true if the input is valid and false if the input is not valid
	 */
	public static boolean validateInput(String input, String validationType) throws EmtpyStringException {
		boolean validate = true;
		if ( validationType == "integer" ) {
			try {
				Integer.parseInt(input);
			} catch (NumberFormatException e) {
				validate = false;
			} catch (NullPointerException e) {
				validate = false;
			}
		}
		else if ( validationType == "emptyString")  {
			Exception e = new EmtpyStringException();
     		boolean test = ((EmtpyStringException) e).isStringEmpty(input);
     		if (test == true) {
     			validate = false;
     		}
     		else {
     			validate = true;
     		}
		}
		else {
			System.out.println("Bad validation type");
			validate = false;
		}
		return validate;
	}//end validateInput()
}
