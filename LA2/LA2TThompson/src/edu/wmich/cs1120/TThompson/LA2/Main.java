package edu.wmich.cs1120.TThompson.LA2;

import java.io.File;
import java.util.*;

/**
 * @author Tyler Thompson
 * @version DateCreated: 01/28/16
 * DateDue: /16
 * Course: CS1120-543
 * Description: 
 */
public class Main {

	/**
	 * Main method receives user input and calls other methods 
	 * @param args	user input
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		TreeDataStructure root = new TreeDataStructure("A");
		
		printMenu("intro");
		
		root.addChild("B", "A");
		root.addChild("C", "A"); 
		root.addChild("D", "B");
		root.addChild("E", "B"); 
		root.addChild("F", "C"); 
		root.addChild("G", "C"); 
		root.addChild("H", "D"); 
		root.addChild("I", "D"); 
		root.addChild("J", "E"); 
		root.addChild("K", "E"); 
		root.addChild("L", "F");
		root.printTree();
		System.out.println(root.size());

		while (true) {
			printMenu("main");
			int input = getChoice(kb);
			if (input == 0) {
				kb.close();
				System.exit(0);
			}
			else if (input == 1) {
				System.out.print("Node to add: ");
				String newNode = kb.nextLine();
				System.out.print("Parent of new Node: ");
				String newNodeParent = kb.nextLine();
				if (root.addChild(newNode.toUpperCase(), newNodeParent.toUpperCase()) == true ) {
					System.out.println("New node added successfully" );
				}
				else {
					System.out.println("That parent node already has two children.\nNew node not added!!");
				}
				root.printTree();
			}
			else if (input == 2) {
				System.out.print("Please input the root node: ");
				String findInput = kb.nextLine();
				TreeDataStructure find = (TreeDataStructure) root.find(findInput.toUpperCase());
				System.out.println("There are " + find.size() + " nodes in the tree");
			}
			else if (input == 3) {
				System.out.print("Enter node to look for: ");
				String findNode = kb.next();
				Inode find = root.find(findNode.toUpperCase());
				if ( find != null ) {
					System.out.println("Node " + findNode.toUpperCase() + " exist");
				}
				else {
					System.out.println("Node " + findNode.toUpperCase() + " does not exist");
				}
			}
			else if (input == 4) {
				root.printTree();
			}
		}
	}//end main method

	/**
	 * prints the main menu
	 */
	public static void printMenu(String menu) {
		if ( menu == "main" ) {
			System.out.println("\n 1. Add Node\n 2. Tree Size\n 3. Find Node\n 0. Exit");
		}
		else if ( menu == "intro" ) {
			System.out.println("\n *** Welcome to CS1120 Lab Assignment 2: Bianary Trees *** \n\t\t Created by: Tyler Thompson \n");
		}
		else {
			System.out.println("Bad input for printMenu()");
		}
		
	}//end printMenu()
	
	/**
	 *method gets user input, validates it, and returns that input if it's valid. Otherwise it will keep asking for input. 
	 * @param kb	the keyboard scanner
	 * @return	returns the user input of type int
	 */
	public static int getChoice(Scanner kb) {		
		int input = 0;
		boolean flag = true;
		while(flag == true) {
			System.out.print("Enter Choice: ");
			String inputString = kb.nextLine();
			if ( validateInput(inputString, "integer") == true) {
				input = Integer.parseInt(inputString);
				if (input == 1 | input == 2 | input == 3 | input == 4 | input == 0) {
					flag = false;
				}
				else {
					System.out.println("You must enter 1, 2, 3, or 0. Please try again");
					printMenu("main");
				}
			}
			else {
				System.out.println("You must enter 1, 2, 3, or 0. Please try again");
				printMenu("main");
			}
		}
		return input;
	}//end getChoice()
	
	/**
	 * method validates input and returns false if input is not valid and true if the input is valid.
	 * @param input	string containing the data you would like to verify
	 * @param validationType	the type of data you want to verify your input with. Accepted values are: integer | double | filelocation
	 * @return returns true if the input is valid and false if the input is not valid
	 */
	public static boolean validateInput(String input, String validationType) {
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
		else if ( validationType == "double") {
			try {
				Double.parseDouble(input);
			} catch (NumberFormatException e) {
				validate = false;
			} catch (NullPointerException e) {
				validate = false;
			}
		}
		else if ( validationType == "filelocation") {
			try {
				Scanner databaseFile = new Scanner(new File(input));
				databaseFile.close();
			} catch (Exception e) {
				validate = false;
			}
		}
		else {
			System.out.println("Bad validation type");
			validate = false;
		}
		return validate;
	}//end validateInput()
	
}//end main class
