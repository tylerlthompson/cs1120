package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public class PigLatin implements IPigLatin {

	private String myInput;
	
	@Override
	public void setInput(String myInput) {
		this.myInput = myInput;
	}

	@Override
	public String textToPigLatin() {
		char firstLetter = this.myInput.charAt(0);
		String body = this.myInput.substring(1);
		return body + firstLetter + "ay";
	}

}
