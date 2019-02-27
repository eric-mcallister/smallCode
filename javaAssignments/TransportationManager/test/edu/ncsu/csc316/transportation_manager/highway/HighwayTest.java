package edu.ncsu.csc316.transportation_manager.highway;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the highway 
 * 
 * @author Eric McAllister
 *
 */
public class HighwayTest {

	/**
	 * Testing comparing and equals method in the highway class 
	 * as well as the class in general
	 */
	@Test
	public void testHighway() {
		Highway a = new Highway(1, 2, 30.2, 100.2);
		Highway b = new Highway(2, 3, 23.4, 12.3);
		Highway c = new Highway(2, 1, 30.2, 100.2);
		
		assertTrue(a.compareTo(b) < 0);
		
		assertEquals(53.6, a.getCost() + b.getCost(), 2);
		
		assertEquals(12.3, b.getAsphalt(), 2);
		
		assertEquals(1, a.highwayData()[0]);
		
		assertEquals(2, a.highwayData()[1]);
		
		assertEquals(-1, a.compareTo(c));
		
		String value = "Highway[city1=1, city2=2, cost=30.2, asphalt=100.2]";
		assertEquals(value, a.toString());
		
		
		Highway x = new Highway(5, 6, 10.4, 23.3);
		Highway y = new Highway(5, 6, 4.4, 23.3);
		
		assertEquals(6, x.compareTo(y));
		
		Highway q = new Highway(8, 9, 10.0, 12.0);
		Highway r = new Highway(8, 9, 10.0, 12.5);
		
		assertEquals(-.5, q.compareTo(r), 2);
	}

}
