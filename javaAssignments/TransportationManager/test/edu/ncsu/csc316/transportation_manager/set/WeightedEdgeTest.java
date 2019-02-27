package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the weightedEdge
 * @author Eric McAllister
 *
 */
public class WeightedEdgeTest {

	/**
	 * Method to test the weightedEdge class
	 */
	@Test
	public void testWeighted() {
		Vertex<String> v1 = new Vertex<String>("King of the Dead");
		Vertex<String> v2 = new Vertex<String>("Touch the river");
		
		Vertex<String> v3 = new Vertex<String>("XXXTentacion");
		Vertex<String> v4 = new Vertex<String>("Moonrock");
		WeightedEdge<String, Integer> edge = new WeightedEdge<String, Integer>(v1, v2, 5);
		WeightedEdge<String, Integer> edge2 = new WeightedEdge<String, Integer>(v3, v4, 2);
		
		assertTrue(edge.compareTo(edge2) > 0);
	}
}
