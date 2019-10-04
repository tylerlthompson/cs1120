package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists;

public interface IList {

	/**
	* Adds the element e to the end of the list.
	* @param e element to be added
	*/
	void add(String e);
	
	/**
	* Adds the element e to the list at the specified index.
	* @param index of the location to place the string, starting from 0
	* @param e element to be added
	*/
	void add(int index, String e) throws IndexOutOfBoundsException;
	
	/**
	* Removes all of the elements from the list
	*/
	void clear();
	
	/**
	* Checks to see if list contains the parameter s
	* @param s parameter to search for.
	* @return true if found, false otherwise.
	*/
	boolean contains(String s);
	
	/**
	* @return the element at the front (index 0) of the list
	*/
	String getHead();
	
	/**
	* @return the element at the back (index size-1) of the list.
	*/
	String getTail();
	
	/**
	*
	* @param index index of the element to retrieve, starting from 0.
	* @return the element at that index.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	String get(int index) throws IndexOutOfBoundsException;
	
	/**
	* Searches for the element s in the list and returns the
	* index of the first occurrence, starting from index 0
	* @param s parameter to search for
	* @return index of the element, or -1 if not found.
	*/
	int indexOf(String s);
	
	/**
	* @return true if the list is empty, false otherwise.
	*/
	boolean isEmpty();
	
	/**
	* Removes the element at the specified index. Close up the gap
	* in the array by moving all elements forward one step.
	* Amend your size attribute to reflect the removal of the element.
	* @param index of element to be removed, starting from index 0
	* @return The contents of the element that was removed.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	String remove(int index) throws IndexOutOfBoundsException;

	/**
	*
	* @return the number of elements in this list.
	*/
	int size();
	
	
}
