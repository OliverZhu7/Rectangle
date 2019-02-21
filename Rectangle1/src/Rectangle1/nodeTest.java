
import junit.framework.TestCase;

/**
 * this the test class for rectangles class
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version this is the version 2/19/2019
 *
 */
public class NodeTest extends TestCase {
    // private Node<Rectangles> node1;
    // private Node<Rectangles> node2;
    private Node<Rectangles> node3;
    private Node<Rectangles> node4;
    // private Node<Rectangles> node6;
    private Rectangles rect1;

    /**
     * this is the pre set up
     */
    public void setUp() {
        // node1 = new Node("first", node2, node3);

        // node2 = new Node("second", null, null);
        node3 = new Node("third", null, null);
        node4 = new Node("fourth", null, null);
        // node6 = new Node<Rectangles>(null, null, null);
    }

    /**
     * this is the method test the getName method
     */
    public void testsetRight() {
        node3.setRight(node4);
        assertEquals(node3.getRight(), node4);
    }

    /**
     * this is the method test the getName method
     */
    public void testsetLeft() {
        node3.setLeft(node4);
        assertEquals(node3.getLeft(), node4);
    }

    /**
     * this is the method test the getName method
     */
    public void testsetElement() {
        Node<Rectangles> node6 = new Node<Rectangles>(null, null, null);
        node6.setElement(rect1);
        assertEquals(node6.getElement(), rect1);
    }

}
