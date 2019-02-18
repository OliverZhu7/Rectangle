package Rectangle1;

import junit.framework.TestCase;

public class databaseTest extends TestCase {
	
	private node root;
	private node leftfromroot;
	private node rightfromroot;
	private Rectangles rect1;
	private Rectangles rect2;
	private Rectangles rect3;
	private Rectangles rect4;
	private Rectangles rect5;
	private Rectangles rect6;
	private database base1;
	private database base2;
	private node first1; 
	private node second1;
	private node second2;
	private node Third1;
	private node Third2;
	private node Third3;
	private node Third4;
	
	
	/**
	 * this is the pre set up
	 */
	@SuppressWarnings("unchecked")
	
	
	public void setup() {
	 root = new node(rect1,leftfromroot,rightfromroot);
	 
	 rect1 = new Rectangles("one",10,10,1,1);
	 rect2 = new Rectangles("two",2,2,1,1);
	 base1 = new database();
	 base2 = new database();
	}
	
	/**
	 * this is the method test the getName method
	 */
	public void testinsert() {
		base1.insert("one", 10, 10, 5, 5);
		assertNotNull(base1.search("one"));
		
		
		//check the situation that is there is empty 
		node emptyroot = new node(null,null,null); 
		
		
		//test the situation that the rectangle is rejected.
		base2.insert("badsituation", -1, 0, 10, 1888);
		assertNull("Rectangle rejected: (badsituation, -1, 0, 10, 1888)");//, "Rectangle rejected: (badsituation, -1, 0, 10, 1888)");
    
		
	}
	
	/**
	 * THIS IS the method to test the insertHelp method 
	 */
	
	public void testinsertHelp() {
		leftfromroot = new node(rect1,null,null);
		rightfromroot = new node(rect2,null,null);
		assertEquals(root.getLeft(),leftfromroot);
		assertEquals(root.getRight(),rightfromroot);
				
	}

	/**
	 * this method is used to test the search method 
	 */
	public void testsearch() {
		base1.insert("search1", 100, 100, 10, 10);
		assertEquals(base1.search("search1"),"search1");
		
	}
	
	
	/**
	 * this method is used to test the searchHelp method 
	 */
	public void testsearchHelp() {
		rect3 = new Rectangles("three", 100, 100, 20, 20);
		rect4 = new Rectangles("four", 200, 200, 100, 100);
		rect5 = new Rectangles("five", 300, 200, 100, 20);
		rect6 = new Rectangles("six", 1000, 1000, 999,999);
		
		first1.setLeft(second1);
		first1.setRight(second2);
		second1.setLeft(Third1);
		second1.setRight(Third2);
		second2.setLeft(Third3);
		second2.setRight(Third4);
		
		
	}
	
	/**
	 * this method is used to test the remove method
	 */
	public void testRemove()
	{
		
	}


}
