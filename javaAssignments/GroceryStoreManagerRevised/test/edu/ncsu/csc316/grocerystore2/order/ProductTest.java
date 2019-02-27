package edu.ncsu.csc316.grocerystore2.order;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class test the Product object 
 * @author Eric W. McAllister
 *
 */
public class ProductTest {

	Product product = new Product("Ice Cream", "Cold Stone renowed and famous ice cream");
	/**
	 * This test that the proper brand name is being used 
	 */
	@Test
	public void testGetBrand() {
		assertEquals(product.getBrand(), "Ice Cream");
	}
	/**
	 * This test that the description was properly set 
	 */
	@Test
	public void testGetDescription() {
		assertEquals(product.getDescription(), "Cold Stone renowed and famous ice cream");
	}
	/**
	 * This test that the frequency will be set to 1 at the start 
	 */
	@Test
	public void testGetFrequency() {
		assertEquals(product.getFrequency(), 1);
	}
	/**
	 * This method test the formula for Product being changed to a string by the requirements given  
	 */
	@Test
	public void testToString() {
		String string = "Product [brand=" + product.getBrand() +
				", description=" + product.getDescription() + ", frequency=" + product.getFrequency() + "]";
		assertEquals(string, product.toString());
	}
	/**
	 * Testing the hash method and getting the position in the array for a value
	 */
	@Test
	public void testHash() {
		assertEquals(product.getHash(), -2073386867);
		assertEquals(6867, product.getPosition());
	}

}
