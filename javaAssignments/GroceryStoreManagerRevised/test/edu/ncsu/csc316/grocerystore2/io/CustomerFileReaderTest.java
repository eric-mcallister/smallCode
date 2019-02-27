package edu.ncsu.csc316.grocerystore2.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.grocerystore2.customer.Customer;
import edu.ncsu.csc316.grocerystore2.list.ArrayBasedList;

/**
 * Test class for reading the file that will produce a list of customers 
 * @author Eric W. McAllister
 *
 */
public class CustomerFileReaderTest {

	String filename = "input/customers_small.txt";
	/**
	 * Test class that checks if the read file method is working correctly using the string filename
	 */
	@Test
	public void testReadFile() {
		try {
			CustomerFileReader reader = new CustomerFileReader(filename);
			ArrayBasedList<Customer> test = reader.returnList();
			assertTrue(!test.isEmpty());
		} catch (Exception e) {
			fail();
		}
		try {
			CustomerFileReader reader2 = new CustomerFileReader(filename + "1");
			ArrayBasedList<Customer> test2 = reader2.returnList();
			test2.get(0);
			fail();
		} catch (Exception e) {
			CustomerFileReader reader3 = new CustomerFileReader(filename);
			ArrayBasedList<Customer> test3 = reader3.returnList();
			assertFalse(test3.get(0).getCompanyName().equals(""));
		}
	}

}