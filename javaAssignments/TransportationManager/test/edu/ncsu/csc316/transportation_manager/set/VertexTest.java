package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the vertex 
 * @author Eric
 *
 */
public class VertexTest {

	/**
	 * Method to test the Vertex class
	 */
	@Test
	public void testVertex() {
		Vertex<String> v1 = new Vertex<String>("XXXTENTACION");
		Vertex<String> v2 = new Vertex<String>("Moonlight");
		
		assertEquals("XXXTENTACION", v1.value);
		assertTrue(v1.compareTo(v2) > 0);
		
		Vertex<String> v3 = new Vertex<String>("Moonlight");
		assertTrue(v2.equals(v3));
		v2 = null;
		assertFalse(v3.equals(v2));
	}
}
