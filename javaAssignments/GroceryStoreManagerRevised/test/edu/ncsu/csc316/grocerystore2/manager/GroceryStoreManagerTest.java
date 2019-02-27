package edu.ncsu.csc316.grocerystore2.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is to test the GroceryStoreManager as a more or less whole program
 * This method calls and uses all of the past classes to come to full functionality 
 * @author Eric W. McAllister
 *
 */
public class GroceryStoreManagerTest {
	/** This is a string constant for the relative path to the product file */
	public static final String PATH_TO_PRODUCT = "input/order_small.txt";
	/** This is a string constant for the relative path to the customer file */
	public static final String PATH_TO_CUSTOMER = "input/customers_small.txt"; 
	
	GroceryStoreManager manager = new GroceryStoreManager(PATH_TO_PRODUCT, PATH_TO_CUSTOMER);
	/**
	 * This method test that the manager class is empty, can get a product from the product list, as well as load all the customers 
	 */
	@Test
	public void testManager() {
		try {
			assertTrue(!manager.customerList.isEmpty());
			String product = manager.getProduct("Varsity", "ice cream");
			String product2 = manager.getProduct("Pack", "coffee");
			assertTrue(product2.length() > 0);
			assertTrue(product.length() > 0);
			String customerList = manager.getCustomers();
			assertTrue(customerList.length() > 0);
		} catch (Exception e) {
			fail();
		}
		
	}

}