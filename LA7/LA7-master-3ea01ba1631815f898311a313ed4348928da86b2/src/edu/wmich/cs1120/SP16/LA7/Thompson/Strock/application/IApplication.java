package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.application;

import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.IList;

public interface IApplication {

	/**
	* Reads the binary file "input.bin" and returns each line
	* as an element in an IList
	* @return an IList containing the input.
	*/
	public IList readInputFile();
	
	/**
	* Writes the reversed string to the binary file "output.bin"
	* @param output an IList containing the output
	*/
	public void writeOutputFile(IList output);
	
	/**
	* Prints out the input and output strings to the screen.
	* @param input the input string
	* @param output the output string
	*/
	default public void printToScreen(String input, String output){
		System.out.println("The reverse of string \""+input+"\" is\""+output+"\".");
	}
	
	/**
	* Reverses the String parameter.
	* @param s the String to be reversed
	* @return the reversed string
	*/
	public String reverseString(String s);
	
	
}
