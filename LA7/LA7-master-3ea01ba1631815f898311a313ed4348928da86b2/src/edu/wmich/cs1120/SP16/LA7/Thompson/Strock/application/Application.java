package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.application;

import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.IList;
import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists.LinkedList;
import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.stacks.IStack;
import edu.wmich.cs1120.SP16.LA7.Thompson.Strock.stacks.Stack;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Class to read and write to a binary file
 * @author TJ Strock and Tyler Thompson
 *
 */
public class Application implements IApplication {

	private IList list;
	
	/**
	 * Application constructor
	 */
	public Application(){
		list = new LinkedList();
	}
	
	/**
	 * Reads the input file which is binary type
	 * @return IList list of lines read from the file
	 */
	public IList readInputFile() {
		// TODO Auto-generated method stub
		
		boolean endOfFile = false;
		
		
		try {
			FileInputStream fstream = new FileInputStream("input.bin");
			DataInputStream inputFile = new DataInputStream(fstream);
			System.out.println("Reading file...");
			
			while(!endOfFile){
				try{
				
				list.add(inputFile.readUTF());
			}
				catch(IOException e){
					endOfFile=true;
				}
			}
			inputFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		System.out.println("Done.");
		
		return list;
		
	}

	
	/**
	 * Writes an ArrayList of data to a binary file
	 * @param output An array list of strings
	 */
	public void writeOutputFile(IList output) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fstream = new FileOutputStream("output.bin");
			DataOutputStream outputFile = new DataOutputStream(fstream);
			System.out.println("Wrirting data to file...");
			
			for(int i =0;i<output.size();i++){
				outputFile.writeUTF(output.get(i));
			}
			outputFile.close();
			System.out.println("Done.");
			
		} catch (IndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * Uses the stack class to reverse a string
	 * @param s string to be reversed
	 */
	public String reverseString(String s) {
		// TODO Auto-generated method stub
		IStack stack = new Stack();
		String reverse = "";
		for(int i=0;i<s.length();i++){
			String letter = Character.toString(s.charAt(i));
			stack.push(letter);
		}
		while(!stack.isEmpty()){
			
			String temp = stack.peek();
			reverse=reverse+temp;
			stack.pop();
		}
		return reverse;
	}

}