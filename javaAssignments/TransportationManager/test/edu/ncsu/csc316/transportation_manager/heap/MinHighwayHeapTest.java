package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.transportation_manager.highway.Highway;
/**
 * Test class for min-highway 
 * 
 * @author Eric McAllister
 *
 */
public class MinHighwayHeapTest {

	/**
	 * Testing the minhighwayheap class 
	 */
	@Test
	public void testMinHighwayHeap() {
		MinHighwayHeap test = new MinHighwayHeap("COST");
		Highway x = new Highway(0, 1, 23.4, 123.4);
		Highway a = new Highway(1, 2, 30.2, 100.2);
		Highway b = new Highway(2, 3, 23.4, 123.3);
		Highway d = new Highway(3, 1, 27.7, 145.7);
		test.insert(x);
		test.insert(a);
		test.insert(b);
		test.insert(d);
		assertEquals(4, test.size());
		assertEquals("Heap[\n" + 
				"   Highway[city1=0, city2=1, cost=23.4, asphalt=123.4],\n" + 
				"   Highway[city1=3, city2=1, cost=27.7, asphalt=145.7],\n" + 
				"   Highway[city1=2, city2=3, cost=23.4, asphalt=123.3],\n" + 
				"   Highway[city1=1, city2=2, cost=30.2, asphalt=100.2]\n" + 
				"]", test.toString());
		assertEquals(x.toString(), test.deleteMin().toString());
	} 

}
