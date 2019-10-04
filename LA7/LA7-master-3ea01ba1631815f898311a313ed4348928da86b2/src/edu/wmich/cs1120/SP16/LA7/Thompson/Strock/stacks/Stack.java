package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.stacks;

import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.IList;
import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.LinkedList;

/**
 * Class to create a stack to use for reversal of words
 * @author TJ Strock and Tyler Thompson
 *
 */
public class Stack implements IStack {

	private IList stack;
	
	/**
	 * Stack constructor. Initializes the stack array list.
	 */
	public Stack() {
		this.stack = new LinkedList();
	}
	
	/**
	 * adds value to top of the stack
	 * @param s String to add
	 */
	public void push(String s) {
		this.stack.add(s);
	}

	/**
	 * removes value from the top of the stack
	 */
	public void pop() {
		if (this.size() == 0) {
			System.out.println("Stack is empty");
		}
		else {
			this.stack.remove(this.size() - 1);
		}
	}

	/**
	 * returns value on top of stack
	 * @return String top of stack
	 */
	public String peek() {
		if (this.size() == 0) {
			return null;
		}
		else {
			return stack.get(this.size() - 1);
		}
	}

	/**
	 * returns size of stack
	 * @return int size of stack
	 */
	public int size() {
		return this.stack.size();
	}

	/**
	 * tells if stack is empty or not
	 * @return boolean true if empty false if not
	 */
	public boolean isEmpty() {
		if ( this.size() == 0 ) {
			return true;
		}
		else {
			return false;
		}
	}

}