package edu.ncsu.csc316.transportation_manager.highway;

import edu.ncsu.csc316.transportation_manager.set.UpTreeNode;
/**
 * Comparable city class to take parts of a highway 
 * and make it into smaller units to use
 * @author Eric McAllister
 *
 */
public class City implements Comparable<City> {
	/** The int value of the location number of the city*/
	public int cityAddress;
	/** A node for the city for combinations to form graphs*/
	public UpTreeNode<String, Integer> node;
	/**
	 * Constructor for the city class which sets the node and cityAddress
	 * @param cityAddress - integer for the city location
	 */
	public City(int cityAddress) {
		this.cityAddress = cityAddress;
		node = new UpTreeNode<String, Integer>(Integer.toString(cityAddress), cityAddress);
	}
	
	@Override
	/**
	 * Compares this city to another city
	 * @param o - another city to compare to the current class
	 * @return - an integer value of the comparison 
	 */
	public int compareTo(City o) {
		return this.cityAddress - o.cityAddress;
	}

}
