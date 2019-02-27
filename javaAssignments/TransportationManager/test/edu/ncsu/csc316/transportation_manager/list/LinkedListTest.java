package edu.ncsu.csc316.transportation_manager.list;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
/**
 * Test class for the linked list
 * @author Eric McAllister
 *
 */
public class LinkedListTest {
	/** test linked list variable for testing the Linked List class*/
	LinkedList<String> test = new LinkedList<String>();
	/**
	 * This method test that the linked List is empty and starts out empty 
	 */
	@Test
	public void test() {
		assertEquals(0, test.size()) ;
	}
	/**
	 * This method checks if the is empty method is working correctly 
	 */
	@Test
	public void isEmpty() {
		assertTrue(test.isEmpty());
	}
	/**
	 * This mehtod test that the size method is working correctly especially when things are added 
	 */
	@Test
	public void testSize() {
		assertEquals(0, test.size());
		test.add("Tom");
		test.add("Jim");
		test.add("Karen");
		test.add("Sam");
		assertEquals(4, test.size());
	}
	/**
	 * This method test the add functionity of the list 
	 */
	@Test
	public void testAdd() {
		test = new LinkedList<String>();
		test.add("Cat");
		test.add("Dog");
		test.add("Bird");
//		assertEquals(test.get(0), "Bird");
//		assertEquals(test.get(1), "Dog");
		assertEquals(test.size(), 3);
	}
	/**
	 * This method test if anything is contained without the linkedList
	 */
	@Test
	public void testContains() {
		test.add("Cat");
		test.add("Dog");
		test.add("Bird");
		assertTrue(test.contains("Cat"));
		assertTrue(test.contains("Dog"));
		assertFalse(test.contains("Rat"));
	}
	/**
	 * This method test getting an object at a specific instance 
	 */
//	@Test
//	public void testGet() {
//		try {
//			test.add("King");
//			assertEquals(test.get(0), "King");
//			assertNull(test.get(-1));
//		} catch(Exception e) {
//			test.add("Light");
//			test.add("Darkness");
//			test.add("Ether");
//			assertEquals(test.get(0), "Ether");
//			assertEquals(test.get(1), "Darkness");
//			assertEquals(test.get(2), "Light");
//		}
//	}
	
	/**
	 * This method test the iterator to help move through the linked list
	 */
	@Test
	public void testIterator() {
		test.add("Ether");
		test.add("Light");
		test.add("Dark");
		Iterator<String> skip = test.iterator();
		if(skip.hasNext()) {
			assertEquals(skip.next(), "Dark");
		}
		assertEquals(3, test.size());
	}
}
