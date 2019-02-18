package Rectangle1;

import junit.framework.TestCase;
public class RectanglesTest extends TestCase {
	
	private Rectangles rect1;
	private Rectangles rect2;
	private Rectangles rect3;
	
	/**
	 * this is the pre set up
	 */
	public void setUp() {
	 rect1 = new Rectangles("one",10,10,1,1);
	 rect2 = new Rectangles("two",10,10,1,1);
	 rect3 = new Rectangles("three",2,2,1,1);
	}
	
	/**
	 * this is the method test the getName method
	 */
	public void testGetName() {
		assertEquals("one", rect1.getName());
	}
	
	/**
	 * this is the method test the getX method
	 */
	public void testgetX() {
		assertEquals(10, rect1.getX());
	}
	
	/**
	 * this is the method test the getY method
	 */
	public void testgetY() {
		assertEquals(10, rect1.getY());
	}
	
	
	/**
	 * this is the method test the getH method
	 */
	public void testgetH() {
		assertEquals(1, rect1.getH());
	}
	
	
	/**
	 * this is the method test the getW method
	 */
	public void testgetW() {
		assertEquals(1, rect1.getW());
	}
	
	
	/**
	 * this is the method test the CompareTo method
	 */
	public void testCompareTo() {
		assertTrue(rect1.compareTo(10, 10, 1, 1));
		assertTrue(rect1.compareTo(4, 4, 1, 1));
	}
	
	/**
	 * this is the method test the another CompareTo method
	 */
	public void testCompareTo1() {
		assertTrue(rect1.compareTo(rect2));
		assertFalse(rect1.compareTo(rect3));
		
	}
	
	
	/**
	 * this is the method test the another CompareTo method
	 */
	public void testIntersect() {
		assertFalse(rect1.intersect(null));
		// assertFalse(rect1.compareTo(rect3));
		assertTrue(rect1.intersect(rect2));
		
	}
	

	
	
	

}
