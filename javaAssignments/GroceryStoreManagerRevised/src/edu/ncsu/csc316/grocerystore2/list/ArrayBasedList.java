package edu.ncsu.csc316.grocerystore2.list;

/**
 * This class is for organizing data types together so that they can be easily grouped together
 * efficiently 
 * @author Eric W. McAllister
 *
 * @param <E> this is a generic class for storing many different data types
 */
public class ArrayBasedList<E> {
	/** An initial capacity value that stores how many values the array can hold before resize */
	public final static int CAPACITY = 100;
	/** An array of elements stored as a ListNode type */
	private Object[] elements; 
	/** An integer to get track of the size of the arrayList */
	private int size = 0; 
	
	/**
	 * This is the start constructor method that initializes the array 
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		elements = (E[]) new Object[CAPACITY];
	}
	/**
	 * Alternative constructor for array for custom capacity 
	 * @param size - the new capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int size) {
		elements = (E[]) new Object[size];
	}
	
	/**
	 * Returns the full array of data in order to set new data without reformating 
	 * @return - an array of elements 
	 */
	public Object[] getArray() {
		return elements;
	}
	
	/**
	 * This class returns the size of the array
	 * @return the size of the array
	 */
	public int size() {
		return this.size;
	}
	/**
	 * This class will return if the array is empty or not
	 * @return true if the array is empty else false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * This method will return the object at the index specified 
	 * @param index the index of the element you want to retrieve 
	 * @return the object at that current index 
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) elements[index];
	}
	/**
	 * This element adds an element to the index of the list
	 * 
	 * @param index - the index of where to place an object
	 * @param object - this is the element trying to be added into the arrayList
	 */
	public void put(int index, Object object) {
		if(index >= CAPACITY || (CAPACITY < size() && index > (size() * 2)))
			throw new IllegalArgumentException();
		elements[index] = object;
		size++;
	}

	/**
	 * This element adds an element to the end of the list and then resizes the array if there are too
	 * many elements already in the array. This resize will allow for the twice as many elements to be held
	 * @param object - this is the element trying to be added into the arrayList
	 */
	@SuppressWarnings("unchecked")
	public void add(Object object) {
		if(size < elements.length) {
			elements[size] = object;
			size = size + 1;
		} else {
			Object[] bigArray = (E[]) new Object[elements.length * 2];
			for(int i = 0; i < elements.length; i++) {
				bigArray[i] = elements[i];
			}
			elements = bigArray;
			add(object);
		}
	}

}