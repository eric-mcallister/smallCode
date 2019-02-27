package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
/**
 * Test class for the adjacency list 
 * 
 * @author Eric McAllister
 *
 */
public class AdjacencyListTest {


	/**
	 * Testing the adjacencyList class
	 */
	@Test
	public void testAdjacenyList() {
		Highway x = new Highway(0, 1, 23.4, 123.4);
		Highway a = new Highway(1, 2, 30.2, 100.2);
		Highway b = new Highway(2, 3, 23.4, 123.3);
		Highway c = new Highway(2, 1, 30.2, 100.2);
		Highway d = new Highway(3, 1, 27.7, 145.7);
		Highway e = new Highway(2, 4, 25.2, 160.4);
		
		ArrayBasedList<Highway> list = new ArrayBasedList<Highway>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(x);
		list.add(d);
		list.add(e);
		
		AdjacencyList adj = new AdjacencyList(list);
		adj.add(a);
		adj.add(b);
		adj.add(c);
		adj.add(d);
		adj.add(x);
		adj.add(e);
		assertEquals("AdjacencyList[\n" + 
				"   City 0: -> Highway[city1=0, city2=1, cost=23.4, asphalt=123.4] -> Highway[city1=0, city2=1, cost=23.4, asphalt=123.4]\n" + 
				"   City 1: -> Highway[city1=0, city2=1, cost=23.4, asphalt=123.4] -> Highway[city1=0, city2=1, cost=23.4, asphalt=123.4] -> Highway[city1=1, city2=2, cost=30.2, asphalt=100.2] -> Highway[city1=1, city2=2, cost=30.2, asphalt=100.2] -> Highway[city1=2, city2=1, cost=30.2, asphalt=100.2] -> Highway[city1=2, city2=1, cost=30.2, asphalt=100.2] -> Highway[city1=3, city2=1, cost=27.7, asphalt=145.7] -> Highway[city1=3, city2=1, cost=27.7, asphalt=145.7]\n" + 
				"   City 2: -> Highway[city1=1, city2=2, cost=30.2, asphalt=100.2] -> Highway[city1=1, city2=2, cost=30.2, asphalt=100.2] -> Highway[city1=2, city2=1, cost=30.2, asphalt=100.2] -> Highway[city1=2, city2=1, cost=30.2, asphalt=100.2] -> Highway[city1=2, city2=3, cost=23.4, asphalt=123.3] -> Highway[city1=2, city2=3, cost=23.4, asphalt=123.3] -> Highway[city1=2, city2=4, cost=25.2, asphalt=160.4] -> Highway[city1=2, city2=4, cost=25.2, asphalt=160.4]\n" + 
				"   City 3: -> Highway[city1=2, city2=3, cost=23.4, asphalt=123.3] -> Highway[city1=2, city2=3, cost=23.4, asphalt=123.3] -> Highway[city1=3, city2=1, cost=27.7, asphalt=145.7] -> Highway[city1=3, city2=1, cost=27.7, asphalt=145.7]\n" + 
				"   City 4: -> Highway[city1=2, city2=4, cost=25.2, asphalt=160.4] -> Highway[city1=2, city2=4, cost=25.2, asphalt=160.4]\n" + 
				"]", adj.toString());
	}

}
