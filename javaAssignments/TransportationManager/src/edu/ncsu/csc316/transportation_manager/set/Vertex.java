package edu.ncsu.csc316.transportation_manager.set;

import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
/**
 * Credit to Typos
 */
/**
 * Class for the vertex part of the graph 
 * @author Eric McAllister 
 *
 * @param <E> - the data type for the vertex that is comparable 
 */
public class Vertex<E extends Comparable<E>> implements Comparable<Vertex<E>> {
	/** The data to be placed inside the vertex for the graph*/
	public E value; 
	/** An ArrayBasedList of vertices that work as this vertex's neighbors*/
	public ArrayBasedList<Vertex<E>> neighbors;
	/**
	 * Constructor method for this vertex
	 * @param value - value that it assigns to the vertex
	 */
	public Vertex(E value) {
		this.value = value; 
		this.neighbors = new ArrayBasedList<Vertex<E>>();
	}

	@Override
	/**
	 * The value being compared to the value of o
	 * @param o - vertex to compare to this vertex
	 * @return the value of the compareTo method from value compared to o
	 */
	public int compareTo(Vertex<E> o) {
		return value.compareTo(o.value);
	}
	
	/**
	 * EqualsTo method that returns true if the two objects have the same value
	 * @param o - object to compare to see if it is equal to
	 * @return false if the values are not the same and true else 
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (o != null && o instanceof Vertex) {
			return this.value.compareTo(((Vertex<E>)o).value) == 0;
		}
		return false; 
	}

}
