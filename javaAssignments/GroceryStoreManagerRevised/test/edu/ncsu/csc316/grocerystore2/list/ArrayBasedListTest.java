package edu.ncsu.csc316.grocerystore2.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This method test my implementation of the created data structure I named ArrayList
 * @author Eric W. McAllister
 *
 */
public class ArrayBasedListTest {

	ArrayBasedList<Integer> test = new ArrayBasedList<Integer>();
	/**
	 * This method test the construction of the arrayList
	 */
	@Test
	public void test() {
		assertEquals(0, test.size());
	}
	/**
	 * Testing that second constructor is created without errors 
	 */
	@Test
	public void testConstructor() {
		test = new ArrayBasedList<Integer>(10);
		assertEquals(0, test.size());
	}
	/**
	 * Testing the put method
	 */
	@Test
	public void testPut() {
		test.put(10, 5);
		assertTrue(5 == test.get(10));
	}
	/**
	 * This method test getting the size of the arrayList
	 */
	@Test
	public void testSize() {
		assertEquals(0, test.size());
		test.add(1);
		test.add(5);
		test.add(10);
		assertEquals(3, test.size());
		
	}
	/**
	 * This method tested if the data structure was empty or not 
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(0, test.size());
		assertTrue(test.isEmpty());
		test.add(2);
		assertFalse(test.isEmpty());
	}
	/**
	 * This was a method to get the data at a location in the arrayList
	 */
	@Test
	public void testGet() {
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		assertEquals(5, test.size());
		if(test.get(0) != 1) {
			fail();
		}
		int test2 = test.get(2);
		assertEquals(test2, 3);
	}
	
	/**
	 * This method added things to the arrayList
	 */
	@Test
	public void testAdd() {
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		assertEquals(5, test.size());
	}
}
