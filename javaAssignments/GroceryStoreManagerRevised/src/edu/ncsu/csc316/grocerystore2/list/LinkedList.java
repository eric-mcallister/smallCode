package edu.ncsu.csc316.grocerystore2.list;

import java.util.Iterator;
/**
 * Class that implements the linked list structure 
 * @author Eric McAllister
 *
 * @param <E>
 */
public class LinkedList<E> {
	/** A ListNode class that keeps the front as a reference. This is the "beginning" of the list*/
	private ListNode front;
	/** This is a variable to hold the size of the Linked List*/
	private int size;
	
	/**
	 * This is the constructor of the class. It sets the front to a null ListNode and size to 0
	 */
	public LinkedList() {
		front = null;
		size = 0;
	}
	/**
	 * This method determines if the linkedList is empty or not 
	 * @return returns true if linkedList is empty
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	/**
	 * This gets how many elements have been linked together
	 * @return the number of elements in the linked list
	 */
	public int size() {
		return size;
	}
	/**
	 * This adds a value to the linked list
	 * @param value - the value that is wanting to be admitted into the list
	 */
	public void add(E value) {
		if(front == null) {
			front = new ListNode(value);
			size++;
		} else {
			ListNode newFront = new ListNode(value);
			newFront.next = front;
			front = newFront;
			size++;
		}
	}
	/**
	 * This method determines if an element is contained within the linked list 
	 * @param element - this is the element that is being checked for containment
	 * @return - returns true if the element is in the list and false if it isn't 
	 */
	public boolean contains(E element) {
		if(isEmpty()) {
			return false;
		} else {
			return front.contains(element);
		}
	}
	
	
	/**
	 * Iterator class to help initialize the iterator and move through the linked list
	 * @return - an iterator object that will be used to traverse the linked list 
	 */
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	/**
	 * ListNode class that stores the data being referenced as well as their target
	 * @author Eric McAllister
	 *
	 */
	private class ListNode {
		/** This is a variable to hold the data the list can reference */
		private E data;
		/** This is a variable to hold the locating of the next piece of data in the list*/
		private ListNode next;
		/**
		 * This is a simple constructor class that assigns the value of the data 
		 * @param data - data to be assigned into a node 
		 */
		public ListNode(E data) {
			this(data, null);
		}
		/**
		 * This is class also constructs a ListNode object if there is a next reference to that object
		 * @param data - the data being stored in the linked list 
		 * @param next - the location of the next listNode
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		/**
		 * It determines if the object is contained with the list 
		 * @param element - the element in question for searching 
		 * @return - the true if element was fun
		 */
		public boolean contains(E element) {
			if(this.data == element) {
				return true;
			} else if(this.next == null) {
				return false;
			} else {
				return this.next.contains(element);
			}
		}
	}
	/**
	 * ListIterator class to help traverse through the list
	 * @author Eric McAllister
	 *
	 */
	public class ListIterator implements Iterator<E> {
		/** This is a variable to hold the front of the linkedlist*/
		private ListNode current;
		/**
		 * Assigns the current value to front making a reference to transverse
		 */
		public ListIterator() {
			current = front; 
		}
		/**
		 * This boolean operation will return true if there is an element after the current
		 * Variable
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}
		/**
		 * This method will move current up to the next node and return the data of the Node
		 * before him.
		 */
		@Override
		public E next() {
			if(!hasNext()) return null;
			E result = current.data;
			current = current.next;
			return result;
		}
		
	}
}
