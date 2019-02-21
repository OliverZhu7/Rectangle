

import junit.framework.TestCase;

/**
 * this class is used to test the rectangles class
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version 2/19/2019
 *
 */

public class RectanglesTest extends TestCase {

    private Rectangles rect1;
    private Rectangles rect2;
    private Rectangles rect3;
    private Rectangles rect4;
    private Rectangles rect5;
    private Rectangles rect11;

    /**
     * this is the pre set up
     */
    public void setUp() {
        rect1 = new Rectangles("one", 10, 10, 1, 1);
        rect11 = new Rectangles("one", 10, 10, 1, 1);
        rect2 = new Rectangles("two", 11, 11, 5, 6);
        rect3 = new Rectangles("three", 10, 10, 4, 4);
        rect4 = new Rectangles("four", 8, 10, 20, 2);
        rect5 = new Rectangles("five", 8, 8, 6, 6);
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
        assertFalse(rect1.compareTo(4, 4, 1, 1));
        assertFalse(rect1.compareTo(10, 9, 1, 1));
        assertFalse(rect1.compareTo(9, 10, 1, 1));
        assertFalse(rect1.compareTo(10, 10, 2, 1));
        assertFalse(rect1.compareTo(10, 10, 1, 2));
    }

    /**
     * this is the method test the another CompareTo method
     */
    public void testCompareTo1() {
        assertFalse(rect1.compareTo(rect2));
        assertTrue(rect1.compareTo(rect11));
        assertTrue(rect2.compareTo(rect11));
        //(rect1.compareTo(rect3));

    }

    /**
     * this is the method test the another CompareTo method
     */
    public void testIntersect() {
        //assertFalse(rect1.intersect(null));
        assertFalse(rect1.intersect(rect2));
        assertTrue(rect2.intersect(rect4));
        assertTrue(rect3.intersect(rect5));
        
    }

}
