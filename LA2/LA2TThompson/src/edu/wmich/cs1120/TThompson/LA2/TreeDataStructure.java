package edu.wmich.cs1120.TThompson.LA2;

import java.util.ArrayList;

public class TreeDataStructure implements Inode {

	private String ID;
	private TreeDataStructure parentID;
	private TreeDataStructure leftChild;
	private TreeDataStructure rightChild;
	
	/**
	 * Creates the root node of a tree
	 * @param ID - string for identification. Name of the root node.
	 */
	public TreeDataStructure(String ID) {
		this.ID = ID;
	}
	
	public boolean addChild(String newID, String newParentID) {
		TreeDataStructure child = new TreeDataStructure(newID);
		TreeDataStructure parent = (TreeDataStructure) find(newParentID);
		if (parent.leftChild == null) {
			parent.leftChild = child;
			
			return true;
		}
		else if (parent.rightChild == null) {
			parent.rightChild = child;
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public Inode find(String value) {
		if ( this.ID.equals(value) ) {
			return this;
		}
		if ( leftChild != null) {
			TreeDataStructure find = (TreeDataStructure) leftChild.find(value);
			if (find != null) {
				return find;
			}
		}
		if ( rightChild != null) {
			TreeDataStructure find = (TreeDataStructure) rightChild.find(value);
			if (find != null) {
				return find;
			}
		}
		return null;
	}

	public int size() {
		int size = 0;
		if (ID != null) {
			size++;
		}
		if ( leftChild != null) {
			size = size + leftChild.size();	
		}
		if ( rightChild != null) {
			size = size + rightChild.size();
		}
		return size;
	}

	public void printTree() {
		ArrayList<TreeDataStructure> nodes = new ArrayList<TreeDataStructure>();
		nodes.add(this);
		while ( nodes.size() > 0 ) {
			if ( nodes.get(0).leftChild != null ) {
				nodes.add(nodes.get(0).leftChild);
			}
			if ( nodes.get(0).rightChild != null ) {
				nodes.add(nodes.get(0).rightChild);
			}
			System.out.println(nodes.get(0).toString());
			nodes.remove(0);
		}
	}
	

	public String getId() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public TreeDataStructure getParentID() {
		return parentID;
	}

	public void setParentID(TreeDataStructure parentID) {
		this.parentID = parentID;
	}

	public Inode getParent() {
		return this.parentID;
	}
	public String toString() {
		if (this.ID != null && this.leftChild != null && this.rightChild != null) {
			return this.ID + this.leftChild.ID + this.rightChild.ID;
		}
		else if (this.ID != null && this.leftChild != null) {
			return this.ID + this.leftChild;
		}
		else if (this.ID != null && this.rightChild != null) {
			return this.ID + this.rightChild;
		}
		else {
			return this.ID;
		}
	}
	

}
