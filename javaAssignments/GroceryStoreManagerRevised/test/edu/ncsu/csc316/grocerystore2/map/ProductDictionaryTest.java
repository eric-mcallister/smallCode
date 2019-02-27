package edu.ncsu.csc316.grocerystore2.map;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.grocerystore2.io.OrderFileScanner;
import edu.ncsu.csc316.grocerystore2.order.Product;
/**
 * Test for the dictionary class 
 * @author Eric McAllister
 *
 */
public class ProductDictionaryTest {
	/** The String for the filename of the file*/
	String filename = "input/test.txt";
	/**
	 * Method testing the dictionary class
	 */
	@Test
	public void testConstruction() {
		OrderFileScanner scanner = new OrderFileScanner(filename);
		ProductDictionary dict = scanner.getDictionary();
		assertTrue(dict.size() > 0);
		Product test = dict.get("Wolf", "mustard");
		assertEquals(4, test.getFrequency());
	}

}
