package edu.ncsu.csc316.transportation_manager.heap;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * The test class for heap
 * 
 * @author Eric McAllister
 *
 */
public class HeapTest {

	/**
	 * Test insert method for the heap class
	 */
	@Test
	public void testInsert() {
		Heap<Integer, String> test = new Heap<Integer, String>();
		assertEquals(0, test.size());
		test.insert(3, "Kiss");
		test.insert(0, "Me");
		test.insert(35, "I");
		test.insert(8, "Miss");
		test.insert(10, "You");
		assertEquals(5, test.size());
		assertEquals("HeapNode [priority=0, data=Me]", test.get(0).toString());
	}
	
	/**
	 * Test overloading the insert method for the heap class
	 */
	@Test
	public void testOverload() {
		Heap<Integer, String> test = new Heap<Integer, String>();
		for(int i = 0; i <= 1050; i++) {
			test.insert(i, "C");
		}
		assertEquals(1051, test.size());
	}
	
	/**
	 * Testing removeMin method in the heap class
	 */
	@Test
	public void testRemove() {
		Heap<Integer, String> test = new Heap<Integer, String>();
		test.insert(4, "Avengers");
		test.insert(5, "Batman");
		test.insert(10, "Spider-Man");
		test.insert(9, "John Wick");
		assertEquals("Avengers", test.get(0).data);
		test.removeMin();
		assertEquals("Batman", test.get(0).data);
	}

}
