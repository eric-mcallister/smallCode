package edu.ncsu.csc316.transportation_manager.set;
/**
 * Credit to Typos and Mr.Gaweda Office Hours Monday
 */
/**
 * Node class for UpTree in order to create linked structure 
 * @author Eric McAllister, Typos
 *
 * @param <K> - The type of the key 
 * @param <E> - the type of the data 
 */
public class UpTreeNode<K, E> {
	/** Data for the key of the node*/
	public K key; 
	/** The primary data for the node*/
	public E data; 
	/** The number of connections to this node object*/
	public int count; 
	/** The parent of this node*/
	public UpTreeNode<K, E> parent;
	/**
	 * This is the constructor for the node to be used in upTrees 
	 * @param key - identifier for the node 
	 * @param data - data stored in the node 
	 */
	public UpTreeNode(K key, E data) {
		this.key = key; 
		this.data = data; 
		// Each node starts as a subtree of one node, itself
		this.count = 1; 
	}
	/**
	 * Class that checks to see if another node is equal to this one or not
	 * @param o - the node to check to see if it equal to 
	 * @return - false if not equal to and true  else 
	 */
	public boolean sameParent(UpTreeNode<K, E> o) {
		if(o.parent == null && this.parent == null) {
			return false;
		} else if(o.parent == null) {
			UpTreeNode<K, E> check = parent;
			while(check.parent != null) {
				check = check.parent;
			}
			return o.key.equals(check.key);
		} else if(this.parent == null) {
			UpTreeNode<K, E> check = o.parent;
			while(check.parent != null) {
				check = check.parent;
			}
			return key.equals(o.key);
		}

		
		UpTreeNode<K, E> gaurdian = parent;
		while(gaurdian.parent != null) {
			gaurdian = gaurdian.parent;
		}
		UpTreeNode<K, E> gaurdian2 = o.parent;
		while(gaurdian2.parent != null) {
			gaurdian2 = gaurdian2.parent;
		}
		
		return gaurdian.key.equals(gaurdian2.key);
	}
	
//	@Override
//	/**
//	 * Compares this node to another node 
//	 * @param o - another node to compare this one to 
//	 * @return 0 if it is equal to and -1 else 
//	 */
//	public int compareTo(UpTreeNode<K, E> o) {
//		if(this.data.equals(o.data)) {
//			return 0; 
//		} else {
//			return -1; 
//		}
//	}
}
