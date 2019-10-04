package edu.wmich.cs1120.SP16.LA7.Thompson.Strock.lists;

/**
 * Class implements the requirements of the INode interface
 * @author  TJ Strock and Tyler Thompson
 *
 * @param <E> generic type of object
 */
public class Node<E>implements INode<E> {

	private E nodeData;
	private INode<E> nextNode;
	
	/**
	 * Node constructor
	 * @param data the info to be held by the node
	 * @param n the next node in the chain
	 */
	public Node(E data, INode<E> n){
		this.nodeData=data;
		this.nextNode=n;
	}
	
	/**
	 * Node constructor
	 * @param nodeData the info to be held by the node
	 */
	public Node(E nodeData) {
		this(nodeData, null);
	}
	
	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	@Override
	public E getData() {
		return this.nodeData;
	}

	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	@Override
	public void setData(E data) {
		this.nodeData = data;
	}

	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	@Override
	public INode<E> getNext() {
		return this.nextNode;
	}

	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	@Override
	public void setNext(INode<E> next) {
		this.nextNode = next;
	}
	
	

}
