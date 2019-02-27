package edu.ncsu.csc316.transportation_manager.highway;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for city 
 * @author Eric McAllister
 *
 */
public class CityTest {

	/**
	 * Testing the city class
	 */
	@Test
	public void test() {
		City a = new City(1);
		City b = new City(2);
		
		assertTrue(a.compareTo(b) < 0);
		
		assertTrue(a.node.data.equals(1));
	}

}
