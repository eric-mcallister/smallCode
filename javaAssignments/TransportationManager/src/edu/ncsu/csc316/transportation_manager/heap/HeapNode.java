package edu.ncsu.csc316.transportation_manager.heap;
/**
 * Credit to Typos
 */
/**
 * Node class to be used in the Heap 
 * @author Eric McAllister 
 *
 * @param <K> - Priority data type that is comparable  
 * @param <E> - Data type for the element in the node
 */
public class HeapNode<K extends Comparable<K>, E> implements Comparable<HeapNode<K, E>> {
	/** K abstract data type for the priority */
	public K priority; 
	/** E abstract data type for the element in the node*/
	public E data;
	/**
	 * Constructor for the node 
	 * @param priority - the instance variable priority
	 * @param data - the instance variable for data 
	 */
	public HeapNode(K priority, E data) {
		this.data = data; 
		this.priority = priority; 
	}
	
	@Override
	/**
	 * Compares two nodes to each other and returns difference 
	 * @param o - the object being compared to
	 * @return - the integer value of compareTo from priority 
	 */
	public int compareTo(HeapNode<K, E> o) {
		return this.priority.compareTo(o.priority);
	}
	/**
	 * String representation of HeapNode class
	 * @return the HeapNode in string format
	 */
	public String toString() {
		return "HeapNode [priority=" + priority + ", data=" + data + "]";
	}

}
