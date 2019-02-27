package edu.ncsu.csc316.grocerystore2.customer;

/**
 * This class has the responsibility of taking data and putting it together
 * into one consistent class object. This object will be used later for data 
 * manipulation and display. This object is supposed to represent a customer 
 * in the system
 * 
 * @author Eric W. McAllister
 *
 */
public class Customer {

	/** A String containing data to represent the customers ID */
	String customerId;
	/** A string to represent the company's name*/
	String companyName;
	/** A string to represent the State a customer is from*/
	String state;
	/** An integer value to represent the zipcode of the customer*/
	String zipcode;
	
	/**
	 * A constructor for the class that assigns the fields customerID, companyName, state, and zipcode
	 * to the equivalent parameters in the constructor 
	 * @param customerId - the customer's name 
	 * @param companyName - the company the customer is from or represents 
	 * @param state - the state the customer hails from
	 * @param zipcode - the zipcode of the area the customer is from 
	 */
	public Customer(String customerId, String companyName, String state, String zipcode) {
		setCustomerId(customerId);
		setCompanyName(companyName);
		setZipcode(zipcode);
		setState(state);
	}

	/**
	 * Getter method for the customer's id
	 * @return the id of a customer
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Private setter method for the customerId. 
	 * This method is private because once the id is set we do not want it
	 * to be changed 
	 * @param customerId the id the customerId field will be set to 
	 */
	private void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * Getter method for the company name 
	 * @return - the field storing the information about the company's name 
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * A private method for setting the company name.
	 * The method is private because once the company name is set we do not 
	 * want it to be changed 
	 * @param companyName - the name that the company's name will be set to 
	 */
	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * This will get the state that the customer is from and return it
	 * @return - the field representing the state of a customer
	 */
	public String getState() {
		return state;
	}

	/**
	 * A private method setting the state of a customer.
	 * Once the state of a customer is set it is not to be changed - hence private. 
	 * @param state
	 */
	private void setState(String state) {
		this.state = state;
	}
	/**
	 * This method returns the zipcode of a customer
	 * 
	 * @return - the zipcode of a customer
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * A private method that sets the zipcode of a customer
	 * This method is private because once set it is not to be changed
	 * @param zipcode
	 */
	private void setZipcode (String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * A method that formats the data of the class into one string 
	 * @return A string containing the formating and inputed information for the toString needed to be outputed 
	 */
	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", company=" + companyName + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}

	/**
	 * A comparing method that will call the java string compare to method in order to compare this class to antoher
	 * class of the type customer. 
	 * @param other - the other customer it will be compared to 
	 * @return a number representing if this class is larger, smaller, or the same as the class in comparison
	 */
	public int compareTo(Customer other) {
		return this.getCustomerId().compareTo(other.getCustomerId());
	}
	
}