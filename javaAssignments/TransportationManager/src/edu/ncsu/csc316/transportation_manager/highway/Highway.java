package edu.ncsu.csc316.transportation_manager.highway;


/**
 * Class to store the highway values
 * 
 * @author Eric Mcallister
 *
 */
public class Highway implements Comparable<Highway> {
	/** The first city in the data*/
	private int city1;
	/** The second city in the data*/
	private int city2;
	/** The cost to make this highway*/
	private double cost;
	/** The cost in asphalt to make this highway*/
	private double asphalt;
	/** Data to store in an array of the first and second city*/
	private int data[]; 
	/** Variable to store the first city in the highway*/
	private City u;
	/** Variable to store the second city in the highway*/
	private City v; 

	
	/**
	 * Constructs a Highway with the given information
	 * @param city1 city1 of the highway
	 * @param city2 city2 of the highway
	 * @param cost cost of building the highway
	 * @param asphalt amount (in miles) of asphalt needed to build the highway
	 */
	public Highway(int city1, int city2, double cost, double asphalt) {
		setFirstCity(city1);
		setSecondCity(city2);
		setCost(cost);
		setAsphalt(asphalt);
		data = highwayData();
		u = new City(city1);
		v = new City(city2);
	}
	/**
	 * returns the first city 
	 * @return - the city u
	 */
	public City getU(){
		return u;
	}
	/**
	 * returns the second city 
	 * @return - the city v
	 */
	public City getV(){
		return v;
	}
	/**
	 * Constructs the highway data array of city 1 and city 2
	 * @return - the array of cities 
	 */
	public int[] highwayData() {
		data = new int[2];
		data[0] = city1; 
		data[1] = city2;
		return data; 
	}
	
	/**
	 * Setter for the asphalt 
	 * @param asphalt - instance variable for asphalt  
	 */
	private void setAsphalt(double asphalt) {
		this.asphalt = asphalt;
	}
	/**
	 * Setter for the second city 
	 * @param city2 - the second city to be set
	 */
	private void setSecondCity(int city2) {
		this.city2 = city2;
	}
	/**
	 * Setter for the first city 
	 * @param city1 - the first city to set 
	 */
	private void setFirstCity(int city1) {
		this.city1 = city1;
	}
	/**
	 * The cost of the highway returned 
	 * @return - the cost of the highway 
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * Setting the cost of the highway 
	 * @param cost - the cost to set 
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * Getter method for the asphalt to return 
	 * @return - the asphalt 
	 */
	public double getAsphalt() {
		return asphalt;
	}
	
	/**
	 * The string representation of the highway 
	 * @return the string representation of the class 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Highway[city1=");
		sb.append(data[0] + ",");
		sb.append(" city2=" + data[1]);
		sb.append(", cost=" + getCost());
		sb.append(", asphalt=" + getAsphalt() + "]");
		return sb.toString();
	}


	@Override
	/**
	 * Compares this highway to another highway object
	 * @param o - a highway to compare this one to
	 * @return a value representing the comparison 
	 */
	public int compareTo(Highway o) {
		if (highwayData()[0] != o.highwayData()[0]) {
			return highwayData()[0] - o.highwayData()[0];
		} else if (highwayData()[1] != o.highwayData()[1]) {
			return highwayData()[1] - o.highwayData()[1];
		} else if (getCost() != o.getCost()) {
			return (int) (getCost() - o.getCost());
		} else if (getAsphalt() != o.getAsphalt()) {
			return (int) (getAsphalt() - o.getAsphalt());
		} else 
			return 0; 
	}
	
}
