package edu.wmich.cs1120.TThompson.LA1;
import java.util.*;
import java.io.*;
/**
 * @author Tyler Thompson
 * @version DateCreated: 01/14/16
 * DateDue: 01/27/16
 * Course: CS1120-543
 * Description: Banking System prototype. Program will load account data from a text file and allows the user to deposit, withdraw, view account balance, and transfer funds from the terminal.
 */
public class BankingSystem {

	/**
	 * Main method receives user input and calls other methods 
	 * @param args	user input
	 * @throws FileNotFoundException	throw exception if file is doesn't exist
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(System.in);
		int accountNumber = 0, withdrawAccount = 0, depositAccount = 0;
		double withdrawAmount = 0, depositAmount = 0, transferAmount = 0;
		String input, databaseFile = "";
		boolean flag = true, flag1 = true;
		printMenu("databaseLocation");
		
		//ask for database location and handle a filenotfound exception
		while (flag == true) {
			input = kb.nextLine();
			if (validateInput(input, "filelocation") == true) {
				databaseFile = input;
				flag = false;
			}
			else {
				System.out.println("\nFile location does not exist, please try again\n Enter location of account database file: ");
			}
		}
		flag = true;
				
		//read database into arraylist
		ArrayList<Account> accounts = new ArrayList<Account>(readDatabase(kb, databaseFile));
		
		while (flag == true) {
			printMenu("main");
			int choice = getChoice(kb);
			
			//0. Exit
			if (choice == 0) {
				writeDatabase(kb, databaseFile, accounts);
				System.out.println("Exiting...");
				flag = false;
			}
			
			//1. Deposit
			else if (choice == 1) {
				while (flag1 == true) {
					System.out.print("\nEnter deposit account number: ");
					input = kb.nextLine();
					if (validateInput(input, "integer") == true) {
						accountNumber = Integer.parseInt(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				while (flag1 == true) {
					System.out.print("Enter deposit amount: ");
					input = kb.nextLine();
					if (validateInput(input, "double") == true) {
						depositAmount = Double.parseDouble(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				bankTeller(kb, "deposit", accounts, accountNumber, depositAmount);
			}
			
			//2. Withdraw
			else if (choice == 2) {
				while (flag1 == true) {
					System.out.print("\nEnter withdraw account number: ");
					input = kb.nextLine();
					if (validateInput(input, "integer") == true) {
						accountNumber = Integer.parseInt(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				while (flag1 == true) {
					System.out.print("Enter withdraw amount: ");
					input = kb.nextLine();
					if (validateInput(input, "double") == true) {
						withdrawAmount = Double.parseDouble(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				bankTeller(kb, "withdraw", accounts, accountNumber, withdrawAmount);
			}
			
			//3. Transfer
			else if (choice == 3) {
				while (flag1 == true) {
					System.out.print("\nEnter withdraw account number: ");
					input = kb.nextLine();
					if (validateInput(input, "integer") == true) {
						withdrawAccount = Integer.parseInt(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				while (flag1 == true) {
					System.out.print("Enter deposit account number: ");
					input = kb.nextLine();
					if (validateInput(input, "integer") == true) {
						depositAccount = Integer.parseInt(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				while (flag1 == true) {
					System.out.print("Enter transfer amount: ");
					input = kb.nextLine();
					if (validateInput(input, "double") == true) {
						transferAmount = Double.parseDouble(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				System.out.print("\nWithdraw account: " + withdrawAccount);
				bankTeller(kb, "withdraw", accounts, withdrawAccount, transferAmount);
				System.out.print("Deposit account: " + depositAccount);
				bankTeller(kb, "deposit", accounts, depositAccount, transferAmount);
			}
			
			//4. Account Balance
			else if (choice == 4) {
				while (flag1 == true) {
					System.out.print("\nEnter account number: ");
					input = kb.nextLine();
					if (validateInput(input, "integer") == true) {
						accountNumber = Integer.parseInt(input);
						flag1 = false;
					}
					else {
						System.out.println("\nBad input, please try again");
					}
				}
				flag1 = true;
				getAccountBalance(kb, accounts, accountNumber);
				System.out.println("");
			}
			
			else {
				System.out.println("bad input, exiting...");
				flag = false;
			}
		}
		kb.close();
		System.exit(0);
	}//end of main method
	
	/**
	 * Method handles deposits and withdraws. combines the deposit and withdraw methods show in the example
	 * @param kb	keyboard scanner
	 * @param action	action to take, valid strings are: deposit | withdraw
	 * @param accounts	the arraylist that contains all the accounts and information
	 * @param accountNumber	account number to work with
	 * @param amount	amount of money to deposit or withdraw
	 */
	public static void bankTeller(Scanner kb, String action, ArrayList<Account> accounts, int accountNumber, double amount) {
		double newBalance = 0;
		double currentBalance = getAccountBalance(kb, accounts, accountNumber);
		if (action == "withdraw") {
			newBalance = currentBalance - amount;
		}
		else if (action == "deposit") {
			newBalance = amount + currentBalance;
		}
		System.out.print("New account balance: $" + newBalance + "\n\n");
		int accountIndex = getAccountIndex(accountNumber, accounts);
		Account writeAccount = new Account(accountNumber, newBalance);
		accounts.set(accountIndex, writeAccount).setAccountBalance(newBalance);
	}
	
	
	/**
	 * Method reads the database file and returns an arraylist of type account
	 * @param kb	the keyboard scanner
	 * @param filePath	path to the database file
	 * @return	returns an arraylist of type account
	 * @throws FileNotFoundException	throw exception if file is doesn't exist
	 */
	public static ArrayList<Account> readDatabase(Scanner kb, String filePath) throws FileNotFoundException{
		System.out.println("\nReading account database...");
		Scanner databaseFile = new Scanner(new File(filePath));
		ArrayList<Account> accounts = new ArrayList<Account>();
		while (databaseFile.hasNextLine()) {
			String line = databaseFile.nextLine();
			Scanner scanner = new Scanner(line);
			int i = 0;
			int j = 1;
			while(scanner.hasNextLine()){		
				String accountInfo = scanner.nextLine();
				String[] splitInfo = accountInfo.split(" ");
				int accountNum = Integer.parseInt(splitInfo[i]);
				double accountBal = Double.parseDouble(splitInfo[j]);
				Account newAccount = new Account(accountNum, accountBal);
				accounts.add(newAccount);
				i++;
				j++;
			}
			scanner.close();
		}
		databaseFile.close();		
		System.out.println("Done.\n");
		return accounts; 
	}
	
	/**
	 * Method write all account information back to the database file. 
	 * @param kb	the keyboard scanner
	 * @param filePath	path to the database file
	 * @param accounts	arraylist of type account that holds all the account information
	 * @throws FileNotFoundException	throw exception if file is doesn't exist
	 */
	public static void writeDatabase(Scanner kb, String filePath, ArrayList<Account> accounts) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filePath);
		System.out.println("\nWriting database file...");
		int i = 0;
		while (i < accounts.size()) {
			int curAccount = accounts.get(i).getAccountNumber();
			double curAccountBal = accounts.get(i).getAccountBalance();
			String line = curAccount + " " + curAccountBal;
			writer.println(line);
			i++;
		}
		writer.close();
		System.out.println("Done.\n");
	}
	
	/**
	 *method gets user input of type int and return that input 
	 * @param kb	the keyboard scanner
	 * @return	returns the input of type int
	 */
	public static int getChoice(Scanner kb) {		
		int input = 0;
		boolean flag = true;
		while(flag == true) {
			System.out.print("Enter Choice: ");
			String inputString = kb.nextLine();
			//input = Integer.parseInt(inputString);
			if ( validateInput(inputString, "integer") == true) {
				input = Integer.parseInt(inputString);
				if (input == 1 | input == 2 | input == 3 | input == 4 | input == 0) {
					flag = false;
				}
			}
			else {
				System.out.println("You must enter 1, 2, 3, 4, or 0. Please try again");
				printMenu("main");
			}
		}
		return input;
	}
	
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
	}
	
	/**
	 * method prints out account balance and returns it as a double.
	 * @param kb	the keyboard scanner
	 * @param accounts	the arraylist containing all the accounts
	 * @param accountNumber	account number of the account you want to get the balance of
	 * @return	returns the account balance as a double
	 */
	public static double getAccountBalance(Scanner kb,ArrayList<Account> accounts, int accountNumber) {
		double accountBalance = 0 ;
		int accountNum = accountNumber;
		int accountIndex = getAccountIndex(accountNum, accounts);
		accountBalance = accounts.get(accountIndex).getAccountBalance();
		System.out.print("\nCurrent account balance: $" + accountBalance + "\n");
		return accountBalance;
	}
	
	/**
	 * method searches through the ArrayList of accounts and returns the index of the specified account.
	 * @param accountNumber	the account number you want to know the index of
	 * @param accounts	the arraylist of accounts you want to search through
	 * @return	returns the index of the account as type int
	 */
	public static int getAccountIndex(int accountNumber, ArrayList<Account> accounts) {
		int accountNum = accountNumber;
		int accountIndex = 0;
		for (int i = 0; i < accounts.size(); i++) {
			int currentAccount = accounts.get(i).getAccountNumber();
			if (currentAccount == accountNum) {
				accountIndex = i;
			}
		}
		return accountIndex;
	}
	
	/**
	 * print out menus
	 * @param menu	the name of the menu you want to print. Accepted inputs are: main | databaselocation
	 */
	public static void printMenu(String menu) {
		if (menu == "main") {
			System.out.println(" *** Main Menu ***\n 1. Deposit \n 2. Withdraw \n 3. Transfer \n 4. View Account Balance \n 0. Write Database File & Exit");
		}
		else if (menu == "databaseLocation") {
			System.out.println("\n *** Welcome to CS1120 Lab Assignment 1: Banking System *** \n\t\t Created by: Tyler Thompson \n\n Enter location of account database file: ");
		}
		else {
			System.out.println("Invalid input for printMenu()");
		}
	}
	
}//end of BankingSystem class
