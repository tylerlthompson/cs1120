package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, EmtpyStringException {
		ISms sms = new Sms();
		IPigLatin pigLatin = new PigLatin();
		IController control = new Controller(sms, pigLatin);
		control.runProgram();
		
	}

}
