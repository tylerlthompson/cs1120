package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists;

/**
 * Class to implement the requirements of the IList interface
 * @author TJ Strock and Tyler Thompson
 *
 */
public class LinkedList implements IList {

	private INode head;
	private INode tail;
	
	/**
	 * LinkedList constructor
	 */
	public LinkedList(){}
	
	
	/**
	* Adds the element e to the end of the list.
	* @param e element to be added
	*/
	@Override
	public void add(String e) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			head = new Node<String>(e);
			tail=head;
		}else{
			tail.setNext(new Node(e));
			tail=tail.getNext();
		}
	}

	
	/**
	* Adds the element e to the list at the specified index.
	* @param index of the location to place the string, starting from 0
	* @param e element to be added
	*/
	@Override
	public void add(int index, String e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
		
		if(index==0){
			head=new Node(e, head);
			if(tail==null){
				tail=head;
			}
		}else{
			INode p = head;
			for(int k=1;k<index;k++){
				p=p.getNext();
			}
			p.setNext(new Node(e,p.getNext()));
			if(p.getNext().getNext()==null){
				tail=p.getNext();
			}
		}
		

	}

	/**
	* Removes all of the elements from the list
	*/
	@Override
	public void clear() {
		head=null;
		tail=null;
	}

	/**
	* Checks to see if list contains the parameter s
	* @param s parameter to search for.
	* @return true if found, false otherwise.
	*/
	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		INode p = head;
		for(int i=0;i<size();i++){
			
			if(((String)p.getData()).equals(s)){
				return true;
			}
			p=p.getNext();
		}
		
		return false;
	}

	/**
	* @return the element at the front (index 0) of the list
	*/
	@Override
	public String getHead() {
		// TODO Auto-generated method stub
		return (String)head.getData();
	}

	/**
	* @return the element at the back (index size-1) of the list.
	*/
	@Override
	public String getTail() {
		// TODO Auto-generated method stub
		return (String)tail.getData();
	}

	/**
	*
	* @param index index of the element to retrieve, starting from 0.
	* @return the element at that index.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	@Override
	public String get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		INode p = head;
		for(int i=0;i<index;i++){
			
			p=p.getNext();
			
			
		}
		return (String)p.getData();
	}

	/**
	* Searches for the element s in the list and returns the
	* index of the first occurrence, starting from index 0
	* @param s parameter to search for
	* @return index of the element, or -1 if not found.
	*/
	@Override
	public int indexOf(String s) {
		// TODO Auto-generated method stub
		INode p = head;
		for(int i=0;i<size();i++){
			
			if(((String)p.getData()).equals(s)){
				return i;
			}
			p=p.getNext();
		}
		return 0;
	}

	/**
	* @return true if the list is empty, false otherwise.
	*/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null;
	}

	/**
	* Removes the element at the specified index. Close up the gap
	* in the array by moving all elements forward one step.
	* Amend your size attribute to reflect the removal of the element.
	* @param index of element to be removed, starting from index 0
	* @return The contents of the element that was removed.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	@Override
	public String remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index<0 || index>=size()){
			throw new IndexOutOfBoundsException();
		}
		String e;
		if(index==0){
			e=(String)head.getData();
			head=head.getNext();
			if(head==null){
				tail=null;
			}
		}else{
			INode p = head;
			for(int i=1;i<index;i++){
				p=p.getNext();
			}
			e=(String)p.getNext().getData();
			p.setNext(p.getNext().getNext());
			if(p.getNext()==null){
				tail=p;
			}
		}
		return e;
	}

	/**
	*
	* @return the number of elements in this list.
	*/
	@Override
	public int size() {
		int count =0;
		INode p = head;
		while(p!=null){
			count++;
			p=p.getNext();
		}
		return count;
	}

}
