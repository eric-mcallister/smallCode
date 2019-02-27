package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the graph
 * @author Eric McAllister
 *
 */
public class GraphTest {

	/**
	 * Method to test the aspects of the graph class
	 */
	@Test
	public void testGraph() {
		Graph<Character, Integer> graph = new Graph<Character, Integer>();
		WeightedEdge<Character, Integer> edge = new WeightedEdge<Character, Integer>('K', 'W', 1);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('K', 'R', 1);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('R', 'Q', 1);
		graph.insertEdge(edge);
		
		assertEquals(4, graph.numOfVertices());
		assertEquals(3, graph.numOfEdges());
		
		edge = new WeightedEdge<Character, Integer>('K', 'T', 4);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('Q', 'T', 4);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('K', 'T', 2);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('A', 'T', 5);
		graph.insertEdge(edge);
		edge = new WeightedEdge<Character, Integer>('T', 'R', 45);
		graph.insertEdge(edge);
		assertEquals(8, graph.numOfEdges());
		
	}

}
