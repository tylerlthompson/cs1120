package edu.wmich.cs1120.TThompson.LA3;

import java.util.*;

/**
 * 
 * @author Tyler Thompson
 *Holds information about library items. Works like a bookshelf.
 */
public class Library implements ILibrary {

	private String callNumber;
	private boolean isCheckedOut;
	private GregorianCalendar dateCheckedOut;
	private GregorianCalendar dateDue;
	
	public Library(){}
	
	public Library(String callNumber){
		this.setCallNumber(callNumber);
		this.isCheckedOut = false;
	}
	
	public void checkOut() {
		if ( this.isCheckedOut == true ) {
			System.out.println("Item is not available.");
		}
		else {
			this.isCheckedOut = true;
			this.dateCheckedOut = new GregorianCalendar();
			this.dateDue = (GregorianCalendar)dateCheckedOut.clone();
			String type = this.toString();
			if ( type.contains("Book") ){
				this.dateDue.add(Calendar.DAY_OF_YEAR, 21);
			}
			else if ( type.contains("Periodical") ) {
				this.dateDue.add(Calendar.DAY_OF_YEAR, 7);
			}
		}
	}

	public String toString() {
		String str = "";
		String temp = this.getClass().getName();
		boolean checkedOut = this.isCheckedOut;
		if ( temp.contains("Book") ) {
			str = str + "\nBook Title: " + ((Book) this).getTitle();
			str = str + "\nAuthor: " + ((Book) this).getAuthor();
			str = str + "\nGenre: " + ((Book) this).getGenre();
		}
		else if ( temp.contains("Periodical") ) {
			str = str + "\nPeriodical Title: " + ((Periodical) this).getTitle();
			str = str + "\nVolume: " + ((Periodical) this).getVolume();
			str = str + "\nIssue: " + ((Periodical) this).getIssue();
			str = str + "\nSubject: " + ((Periodical) this).getSubject();
		}
		str = str + "\nCall Number: " + this.getCallNumber();
		if (checkedOut == false) {
			str = str + "\nChecked Out: NO";
		}
		else if (checkedOut == true) {
			str = str + "\nChecked Out: Yes";
			if (temp.contains("Book")) {
				str = str + String.format("\nDate Out: %tD", ((Book) this).getDateCheckedOut() );
				str = str + String.format("\nDate Due: %tD", ((Book) this).getDateDue() );
			}
			else if (temp.contains("Periodical")) {
				str = str + (String.format("\nDate Out: %tD", ((Periodical) this).getDateCheckedOut() ));
				str = str + (String.format("\nDate Due: %tD", ((Periodical) this).getDateDue() ));
			}
		}
		return str;
	}
	
	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	
	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	
	public GregorianCalendar getDateDue() {
		return dateDue;
	}

	public void setDateDue(GregorianCalendar dateDue) {
		this.dateDue = dateDue;
	}

	public void setDateCheckedOut(GregorianCalendar dateCheckedOut) {
		this.dateCheckedOut = dateCheckedOut;
	}

	public GregorianCalendar getDateCheckedOut() {
		return dateCheckedOut;
	}
	

}
