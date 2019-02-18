package Rectangle1;

import junit.framework.TestCase;

public class nodeTest extends TestCase {
	private node node1;
	private node node2;
	private node node3;
	private node node4;
	private node node5;
	private node node6;
	
	/**
	 * this is the pre set up
	 */
	public void setUp() {
	 node1 = new node("first",node2,node3);
	 node2 = new node("second",null,null);
	 node3 = new node("third",null,null);
	 node4 = new node("fourth",null,null);
	 node5 = new node("fifth",null,null);
	 node6 = new node(null,null,null);
	 
	}
	
	/**
	 * this is the method test the getName method
	 */
	public void testsetRight() {
		node3.setRight(node4);
		assertEquals(node3.getRight(),node4);		
	}
	
	/**
	 * this is the method test the getName method
	 */
	public void testsetLeft() {
		node3.setLeft(node4);
		assertEquals(node3.getLeft(),node4);	
	}
	
	/**
	 * this is the method test the getName method
	 */
	public void testsetElement() {
		node6.setElement("sixth");
		assertEquals(node6.getElement(),"sixth");
	}
	
	

}
