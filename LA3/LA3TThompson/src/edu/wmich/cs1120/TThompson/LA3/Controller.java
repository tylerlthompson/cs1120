package edu.wmich.cs1120.TThompson.LA3;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 
 * @author Tyler Thompson
 *Main controller. Works like a librarian.
 */
public class Controller implements IController {

	private ArrayList<Library> library;
	private Scanner keyboard;
	/**
	 * Controller constructor
	 * @param keyboard
	 */
	public Controller(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	public void displayCollection() {
		int i = 0;
		while ( i < library.size() ) {
			String temp = library.get(i).toString();
			System.out.println(temp);
			System.out.println("");
			i++;
		}
	}

	public void checkoutMaterials() {
		this.keyboard = new Scanner(System.in);
		System.out.print("Enter the call number: ");
		String callNumber = keyboard.nextLine();
		ILibrary temp = new Library();
		temp = this.findItem(callNumber);
		if (temp.isCheckedOut() == true) {
			System.out.println("Item is not available.");
		}
		else {
			this.findItem(callNumber).checkOut();
			System.out.println(temp.toString());
			System.out.println("");
		}
	}

	public void showMenu() {
		System.out.print("\n------------- Menu -------------\n1) Display collection\n2) Check out materials\n3) Quit\n----------------------------------\nPlease choose an option: ");
	}

	public void readInput(String fileName) throws IOException {
		this.keyboard = new Scanner(new File(fileName));
		library = new ArrayList<Library>();
		while ( keyboard.hasNextLine() ) {
			String line = keyboard.nextLine();
			String[] materialInfo = line.split(",");
			if ( materialInfo[0].equals("B") ){
				Library book = new Book(materialInfo[2], materialInfo[3], materialInfo[4]);
				book.setCallNumber(materialInfo[1]);
				library.add(book);
			}
			else if ( materialInfo[0].equals("P") ){
				Library periodical = new Periodical(materialInfo[2], materialInfo[3], materialInfo[4], materialInfo[5]);
				periodical.setCallNumber(materialInfo[1]);
				library.add(periodical);
			}
		}
	}

	public ILibrary findItem(String callNum) {
		int i = 0;
		ILibrary find = new Library();
		while ( i < library.size() ) {
			String callNumber = library.get(i).getCallNumber();
			if ( callNumber.equals(callNum) ) {
				find = library.get(i);
			}
			i++;
		}
		return find;
	}

	public ArrayList<Library> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Library> library) {
		this.library = library;
	}

}
