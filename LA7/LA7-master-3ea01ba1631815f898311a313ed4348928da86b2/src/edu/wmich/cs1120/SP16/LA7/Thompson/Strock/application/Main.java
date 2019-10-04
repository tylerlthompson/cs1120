package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.application;

import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.IList;
import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.LinkedList;

public class Main {

	/**
	 * Main class
	 * @param args command line parameters
	 */
	public static void main(String[] args) {
		
		Application app = new Application();
		IList inputStrings = app.readInputFile();
		inputStrings.add(2,"String added to index 2");
		IList reversedStrings = new LinkedList();
		for(int i=0; i<inputStrings.size();i++){
			reversedStrings.add(app.reverseString(inputStrings.get(i)));
			app.printToScreen(inputStrings.get(i), reversedStrings.get(i));
		}
		app.writeOutputFile(reversedStrings);

	}

}
