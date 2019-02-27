package edu.ncsu.csc316.transportation_manager.util;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Class to test type
 * @author Eric McAllister
 *
 */
public class TypeTest {
	/**
	 * Method to test the type
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testType() {
		Type t1 = Type.COST;
		Type t2 = Type.ASPHALT;
		Type t3 = Type.COST;
		
		assertEquals(t1.name(), t3.name());
		assertFalse(t1.name() == t2.name());
		
		try {
			Type t4 = Type.valueOf("COST");
			assertEquals(t4.name(), t1.name());
		} catch(Exception e) {
			fail();
		}
		try {
			t2.valueOf(null);
		} catch(Exception e) {
			assertTrue(t3.name().equals("COST"));
		}
	}

}
