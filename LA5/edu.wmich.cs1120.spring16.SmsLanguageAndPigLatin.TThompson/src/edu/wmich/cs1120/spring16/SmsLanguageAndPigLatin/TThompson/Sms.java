package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public class Sms implements ISms {

	private String myInput;
	
	@Override
	public void setInput(String myInput) {
		this.myInput = myInput;
	}

	@Override
	public String textToSMS() {
		String input = this.myInput;
		input = input.replace("what", "w@");
		input = input.replace("incredible", "NcreDbl");
		input = input.replace("best", "A1");
		input = input.replace("the", "d");
		input = input.replace("england", "UK");
		input = input.replace("world", "wrld");
		input = input.replace("and", "n");
		input = input.replace("stuff", "stuf");
		input = input.replace("that", "dat");
		input = input.replace("game", "gme");
		input = input.replace("has", "hs");
		input = input.replace("twisted", "twistD");
		input = input.replace("one", "1");
		input = input.replace("ten", "10");
		input = input.replace("another", "nothA");
		input = input.replace("again", "agn");
		input = input.replace("before", "B4");
		input = input.replace("up", "^");
		input = input.replace("even", "evn");
		input = input.replace("great", "gr8");
		input = input.replace("have", "av");
		input = input.replace("night", "nite");
		input = input.replace("good", "gud");
		return input;
	}

	@Override
	public String smsToText() {
		String input = this.myInput;
		input = input.replace("w@", "what");
		input = input.replace("ncredbl", "incredible");
		input = input.replace("a1", "best");
		input = input.replace(" d ", " the ");
		input = input.replace("uk", "England");
		input = input.replace("wrld", "world");
		input = input.replace(" n ", " and ");
		input = input.replace("stuf ", "stuff");
		input = input.replace(" dat ", " that ");
		input = input.replace("gme", "game");
		input = input.replace(" hs ", " has ");
		input = input.replace("twistd", "twisted");
		input = input.replace("1", "one");
		input = input.replace("notha", "another");
		input = input.replace("agn", "again");
		input = input.replace("b4", "before");
		input = input.replace("^", "up");
		input = input.replace("evn", "even");
		input = input.replace("gr8", "great");
		input = input.replace("av", "have");
		input = input.replace("nite", "night");
		input = input.replace("have", "av");
		input = input.replace("gud", "good");
		return input;
	}

}
