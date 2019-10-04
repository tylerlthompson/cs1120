package edu.wmich.cs1120.TThompson.LA3;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Tyler Thompson
 * @version DateCreated: 02/10/16
 * DateDue: 02/24/16
 * Course: CS1120-543
 * Description: Library Catalog System
 */
public class Main {

	/**
	 * Main method receives user input and calls other methods 
	 * @param args	user input
	 */
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in); 
		IController control = new Controller(keyboard); 
		    control.readInput("input.txt");
		        String response = "";
		        boolean quitFlag = false;
		        while (!quitFlag) {
		            control.showMenu();
		            response = keyboard.nextLine();
		            System.out.println();
		            switch (response) {
		                case "1":
		                    control.displayCollection();
		                    break;
		                case "2":
		                    control.checkoutMaterials();
		                    break;
		                case "3":
		                    quitFlag = true;
		                    break;
		            }
		        } 
		        keyboard.close();
	}

}
