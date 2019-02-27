package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Testing for heap node 
 * @author Eric McAllister
 *
 */
public class HeapNodeTest {

	/**
	 * Test class for the heap node
	 */
	@Test
	public void testHeapNode() {
		HeapNode<Integer, String> node = new HeapNode<Integer, String>(1, "A");
		HeapNode<Integer, String> node2 = new HeapNode<Integer, String>(5, "T");
		assertEquals("HeapNode [priority=1, data=A]", node.toString());
		assertTrue(node.compareTo(node2) < 0);
	}

}
