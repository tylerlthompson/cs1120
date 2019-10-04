package edu.wmich.cs1120.spring16.SmsLanguageAndPigLatin.TThompson;

public class EmtpyStringException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Test string to see if it's empty
	 * @param str string to test
	 * @return true if string is empty, false if it is not.
	 */
	public boolean isStringEmpty(String str) {
		if (str.trim().isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}
