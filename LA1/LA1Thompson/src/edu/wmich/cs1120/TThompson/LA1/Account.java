/*
 * Author: Tyler Thompson
 * Date Created: 01/14/16
 * Date Due: 01/27/16
 * Course: CS1120-543
 * Description: Banking System prototype. Program will load account data from a text file and allows the user to deposit, withdraw, and transfer funds from the terminal.
 */
package edu.wmich.cs1120.TThompson.LA1;

public class Account {

	private int accountNumber;
	private double accountBalance;
	
	public Account(int accountNumber, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}//end Account constructor

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}//end Account class
