package edu.ncsu.csc316.transportation_manager.set;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for the upTreeNode
 * @author Eric McAllister
 *
 */
public class UpTreeNodeTest {

	/**
	 * Method to test the UpTreeNodes 
	 */
	@Test
	public void testTreeNode() {
		UpTreeNode<Integer, String> node = new UpTreeNode<Integer, String>(1, "Jocelyn");
		UpTreeNode<Integer, String> node2 = new UpTreeNode<Integer, String>(2, "Flores");
		 
		UpTreeNode<Integer, String> node3 = new UpTreeNode<Integer, String>(3, "Sam");
		node.parent = node3;
		node2.parent = node3;
		UpTreeNode<Integer, String> node4 = new UpTreeNode<Integer, String>(1, "Jocelyn");
		
		assertFalse(node.sameParent(node4));
		assertTrue(node.sameParent(node2));
		assertTrue(node2.count == 1);
		assertNull(node4.parent);
	}

}
