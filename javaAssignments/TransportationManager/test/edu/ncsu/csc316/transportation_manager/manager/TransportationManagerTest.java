package edu.ncsu.csc316.transportation_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the transportation manager
 * @author Eric McAllister
 *
 */
public class TransportationManagerTest {

	/** Pathway for the manager class to be tested with*/
	private String filename = "input/highways_small.txt"; 
	
	/**
	 * Testing the manager class 
	 */
	@Test
	public void testManager() {
		TransportationManager manager = new TransportationManager(filename);
		assertEquals("AdjacencyList[\n" + 
				"   City 0: -> Highway[city1=0, city2=3, cost=14.0, asphalt=144.0] -> Highway[city1=1, city2=0, cost=5.0, asphalt=101.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=77.0]\n" + 
				"   City 1: -> Highway[city1=1, city2=0, cost=5.0, asphalt=101.0] -> Highway[city1=1, city2=2, cost=6.0, asphalt=55.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=66.0]\n" + 
				"   City 2: -> Highway[city1=1, city2=2, cost=6.0, asphalt=55.0] -> Highway[city1=2, city2=0, cost=7.0, asphalt=77.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=122.0]\n" + 
				"   City 3: -> Highway[city1=0, city2=3, cost=14.0, asphalt=144.0] -> Highway[city1=3, city2=1, cost=10.0, asphalt=66.0] -> Highway[city1=3, city2=2, cost=12.0, asphalt=122.0]\n" + 
				"]", manager.getAdjacencyList());
	
		assertEquals("List[\n" + 
				"   Highway[city1=1, city2=0, cost=5.0, asphalt=101.0],\n" + 
				"   Highway[city1=1, city2=2, cost=6.0, asphalt=55.0],\n" + 
				"   Highway[city1=3, city2=1, cost=10.0, asphalt=66.0]\n" + 
				"]", manager.getMinimumHighways("COST"));
		

	}

}
