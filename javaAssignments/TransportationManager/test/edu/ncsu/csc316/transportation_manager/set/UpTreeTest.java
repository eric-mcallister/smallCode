package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the UpTree
 * @author Eric McAllister
 *
 */
public class UpTreeTest {

	/**
	 * Method to test the contents of the UpTree
	 */
	@Test
	public void testUpTree() {
		UpTree<Character, Integer> tree = new UpTree<Character, Integer>();
		
		UpTreeNode<Character, Integer> nodeA = new UpTreeNode<Character, Integer>('A', 1);
		
		UpTreeNode<Character, Integer> nodeB = new UpTreeNode<Character, Integer>('B', 2);

		UpTreeNode<Character, Integer> nodeC = new UpTreeNode<Character, Integer>('C', 3);
		
		tree.union(nodeA, nodeB);
		
		assertTrue(nodeB.parent.data.equals(nodeA.data));
		
		tree.union(nodeA, nodeC);
		
		assertEquals(nodeC.parent, nodeA);
		
		assertEquals(nodeA, tree.find(nodeA));
		
		assertEquals(nodeA, tree.find(nodeC));
	}

}
