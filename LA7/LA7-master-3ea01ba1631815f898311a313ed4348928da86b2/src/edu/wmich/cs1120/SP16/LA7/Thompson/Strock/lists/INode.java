package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists;

public interface INode <E>{

	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	E getData();
	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	void setData(E data);
	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	INode<E> getNext();
	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	void setNext(INode<E> next);
	
}
