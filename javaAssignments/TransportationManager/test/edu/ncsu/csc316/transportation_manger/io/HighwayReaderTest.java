package edu.ncsu.csc316.transportation_manger.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
/**
 * Test class for the highway reader 
 * @author Eric McAllister
 *
 */
public class HighwayReaderTest {

	private String filename = "input/highways_small.txt"; 
	
	/**
	 * Method to test the highway reading
	 */
	@Test
	public void testHighwayReader() {
		HighwayReader reader = new HighwayReader(filename);
		ArrayBasedList<Highway> list = reader.getList();
		assertEquals(6, list.size());
		assertEquals(list.get(0).getAsphalt(), 77.0, 2);
		assertEquals(list.get(1).getAsphalt(), 122.0, 2);
		assertEquals(list.get(2).getAsphalt(), 144.0, 2);
	}

}
