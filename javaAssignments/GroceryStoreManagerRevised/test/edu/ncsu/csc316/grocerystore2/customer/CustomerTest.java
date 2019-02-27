package edu.ncsu.csc316.grocerystore2.customer;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * This class test if the Customer class is working properly 
 * @author Eric W. McAllister
 *
 */
public class CustomerTest {

	Customer customer = new Customer("C12345", "Cutco", "NC", "28367");
	
	/**
	 * This method test getting customer info
	 */
	@Test
	public void testGetCustomerId() {
		assertEquals(customer.getCustomerId(), "C12345");
	}
	/**
	 * This method test getting the company's name to verify where you got the product 
	 */
	@Test
	public void testGetCompanyName() {
		assertEquals(customer.getCompanyName(), "Cutco");
	}
	/**
	 * This method will test the get state efficently 
	 */
	@Test
	public void testGetState() {
		assertEquals(customer.getState(), "NC");
	}
	/**
	 * This test is about getting the zipcode of the customer
	 */
	@Test
	public void testGetZip() {
		assertEquals(customer.getZipcode(), "28367");
	}
	/**
	 * This method test how the information is going to be stored in a 2D message. 
	 */
	@Test
	public void testToString() {
		String string = "Customer [id=" + customer.getCustomerId() + ", company=" + customer.getCompanyName() +
				", state=" + customer.getState() + ", zipcode=" + customer.getZipcode() + "]";
		assertEquals(customer.toString(), string);
	}
	/**
	 * This method test how the customer class will be compared to other customer classes
	 * Returns positive if it is greater, 0 if equal, or it could turn negative if it's less 
	 */
	@Test
	public void testCompareTo() {
		Customer tom = new Customer("C342345", "Google", "CA", "23342");
		Customer sam = new Customer("C111111", "Apple", "NY", "28374");
		assertTrue(tom.compareTo(sam) > 0);
		assertTrue(sam.compareTo(tom) < 0);
		assertTrue(sam.compareTo(sam) == 0);
	}

}