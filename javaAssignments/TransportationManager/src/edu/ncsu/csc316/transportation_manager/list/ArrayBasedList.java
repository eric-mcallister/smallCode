package edu.ncsu.csc316.transportation_manager.list;
/**
 * Credit from Project 1
 */
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
		 * Returns the full array of data in order to set new data without reformatting 
		 * @return - an array of elements 
		 */
		public Object[] getArray() {
			return elements;
		}
		/**
		 * Alternative add method to add at an index 
		 * @param index - the location to add a variable 
		 * @param object - the object to add at the location 
		 */
		public void add(int index, Object object) {
			if(index < 0) {
				throw new IllegalArgumentException();
			}
			elements[index] = object;
			size++;
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
			if(index > size) {
				return null;
			}
			return (E) elements[index];
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
		/**
		 * Determines if a value is contained in the list 
		 * @param e - the data to check if it exist in the list 
		 * @return - true if it exist and false if not 
		 */
		public boolean contains(E e) {
			for(int i = 0; i < size(); i++) {
				if(get(i).equals(e))
					return true;
			}
			return false;
		}
		/**
		 * Return the index in the array of a piece of data 
		 * @param e - the data to check exist in the list 
		 * @return - the index of the element; if it doesn't exist (-1) 
		 */
		public int indexOf(E e) {
			for(int i = 0; i < size(); i++) {
				if(get(i).equals(e))
					return i; 
			}
			return -1; 
		}

	}
