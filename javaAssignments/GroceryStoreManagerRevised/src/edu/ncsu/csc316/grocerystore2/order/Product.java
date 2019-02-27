package edu.ncsu.csc316.grocerystore2.order;

/**
 * This class represents the products in the grocery store system 
 * @author Eric W. McAllister
 *
 */
public class Product {

	private static final int INIT_FREQUENCY = 1;
	/** A string to represent the brand name of a product*/
	private String brand;
	/** A string to represent the description of a product*/
	private String description;
	/** An integer to represent the frequency a product appears in code*/
	private int frequency;
	/** Hash code for locating and reducing collisions*/
	private int hash = 0;
		
	/**
	 * This is the class constructor with initializes all the variables using the private 
	 * helper methods 
	 * @param brand - the brand name of the product 
	 * @param description - the description of a product 
	 */
	public Product(String brand, String description) {
		setBrand(brand);
		setDescription(description);
		setFrequency(INIT_FREQUENCY);
		setHash(brand);
	}
	/**
	 * Getter method for the hash 
	 * @return - the hash of the object
	 */
	public int getHash() {
		return hash;
	}
	/**
	 * The position in the array of the object 
	 * @return - the index position
	 */
	public int getPosition() {
		String num = Integer.toString(hash);
		int size = num.length();
		String a = num.substring(size - 4, size);
		return Integer.valueOf(a);
	}
	/**
	 * Sets the hash code for this object based on the brand
	 * @param s - the string to create hash with
	 */
	private void setHash(String s) {
		for(int i = 0; i < s.length(); i++) {
			hash = hash << 5;
			hash += (int) s.charAt(i);
		}
	}
	/**
	 * Increments the frequency of an object
	 */
	public void incrementFrequency() {
		frequency++;
	}

	/**
	 * A getter method that returns the brand name
	 * @return - the brand name
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * A getter method that returns the description 
	 * @return - the description 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * A getter method that returns the frequency a product is mentioned in the file
	 * @return - the frequency 
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * A private setter method for the brand of an item. Once set it should not be changed
	 * @param brand
	 */
	private void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * A private setter method for the description of an item. Once set it should not be changed
	 * @param description
	 */
	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * A private setter method for the frequency of an product. The initial frequency should always be 1. 
	 * @param frequency - the amount of times it appears 
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * This method is used to be compared to another product 
	 * @param other - the other product that will be compared vesus the current class 
	 * @return - it returns 0 if they are same and a positive number if this class is bigger negative else 
	 */
	public int compareTo(Product other) {
		if(this.getBrand().compareTo(other.getBrand()) == 0) {
			return this.getDescription().compareTo(other.getDescription());
		} else {
			return this.getBrand().compareTo(other.getBrand());
		}
	}
	/**
	 * A method that takes the information given in this class an outputs it as a proper string
	 * @return A string containing the appropriate 
	 */
	@Override
	public String toString() {
		return "Product [brand=" + brand + ", description=" + description + ", frequency=" + frequency + "]";
	}

	
}