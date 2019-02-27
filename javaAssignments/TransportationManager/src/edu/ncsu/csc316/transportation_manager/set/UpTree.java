package edu.ncsu.csc316.transportation_manager.set;
/**
 * Credit for design: Typos
 * July 10th, 2018 
 */
/**
 * This is a generic node class that defines an upTree
 * This class will be used as a way to organize graphs 
 * @author Eric McAllister, Typos 
 * @param <String> - a string piece of data
 * @param <Integer> - a second integer piece of data
 */
@SuppressWarnings("hiding")
public class UpTree<String, Integer> { 
	/**
	 * Constructor to assign values into the instance variable 
	 */
	public UpTree() {
		//Empty on purpose 
	}
	/**
	 * Method to find the upper most parent in the data structure 
	 * @param node - the child node who's parent we are looking for 
	 * @return node where there is not a parent 
	 */
	public UpTreeNode<String, Integer> find(UpTreeNode<String, Integer> node) {
		while(node.parent != null)
			node = node.parent;
		return node;
	}
	/**
	 * Combines two UpTrees so that the "Most important" upTree is the parent of the 
	 * the other UpTree 
	 * @param node - The first comparison node 
	 * @param node2 - The second comparison node 
	 */
	public void union(UpTreeNode<String, Integer> node, UpTreeNode<String, Integer> node2) {
		if (node.count >= node2.count) {
			node.count += node2.count;
			node2.parent = node;
			
		} else {
			node2.count += node.count; 
			node.parent = node2;
		}
	}
}
