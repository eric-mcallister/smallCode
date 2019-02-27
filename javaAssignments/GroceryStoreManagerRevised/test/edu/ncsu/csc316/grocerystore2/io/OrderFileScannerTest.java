package edu.ncsu.csc316.grocerystore2.io;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test file for the scanner
 * @author Eric McAllister
 *
 */
public class OrderFileScannerTest {
	/** The string filename to find the products*/
	String filename = "input/test.txt";
	/**
	 * The method testing the scanner
	 */
	@Test
	public void testOrderFileScanner() {
		try {
			OrderFileScanner scanner = new OrderFileScanner(filename);
			assertTrue(scanner.getDictionary().size() > 0);
		} catch (Exception e) {
			fail();
		}
		
		try {
			@SuppressWarnings("unused")
			OrderFileScanner scanner = new OrderFileScanner(filename + "1");
			fail();
		} catch (Exception e) {
			assertEquals("File Issues", e.getMessage());
		}
	}

}
