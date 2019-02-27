package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
import edu.ncsu.csc316.transportation_manager.list.ArrayBasedList;
import edu.ncsu.csc316.transportation_manger.io.HighwayReader;
/**
 * Test class for the minimumhighway
 * @author Eric McAllister
 *
 */
public class MinimumHighwayFinderTest {

	private String filename = "input/highways_small.txt"; 
	
	/**
	 * Method to test using Kruskal's algorithm
	 */
	@Test
	public void testKruskal() {
		HighwayReader reader = new HighwayReader(filename);
		ArrayBasedList<Highway> list = reader.getList();
		MinimumHighwayFinder finder = new MinimumHighwayFinder("COST", list);
		assertEquals("List[\n" + 
				"   Highway[city1=1, city2=0, cost=5.0, asphalt=101.0],\n" + 
				"   Highway[city1=1, city2=2, cost=6.0, asphalt=55.0],\n" + 
				"   Highway[city1=3, city2=1, cost=10.0, asphalt=66.0]\n" + 
				"]", finder.toString());
		
		reader = new HighwayReader("input/highways_medium.txt");
		finder = new MinimumHighwayFinder("COST", reader.getList());
		
		
		reader = new HighwayReader("input/highways_large.txt");
		finder = new MinimumHighwayFinder("COST", reader.getList());
		System.out.println(finder.toString());
	}
	
}
