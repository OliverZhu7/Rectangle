
// import student.TestCase;

import junit.framework.TestCase;

/**
 * @version this is the version for 2/19/2019
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 */

public class DatabaseTest extends TestCase {

    private Database base;


    /**
     * this is the pre set up
     */
    @SuppressWarnings("unchecked")

    public void setUp() {

        base = new Database();
    }


    /**
     * this is the method test the getName method
     */

    public void testInsert() {
        assertTrue(base.insert("topleftCorner", 0, 0, 7, 6));
        assertFalse(base.insert("aa", -1, 0, 7, 6));
        assertFalse(base.insert("aa", 0, -1, 7, 6));
        assertFalse(base.insert("aa", 0, 0, -1, 6));
        assertFalse(base.insert("aa", 0, 0, 7, -1));
        assertFalse(base.insert("aa", 0, 0, 7000, 6));
        assertFalse(base.insert("aa", 0, 0, 7, 6000));
        assertFalse(base.insert("233aa", 0, 0, 7, 6));

    }


    /**
     * this is the method to test insert
     */

    public void testInsert1() {
        System.out.println("11111111111111111111111111111");
        assertTrue(base.insert("ok1", 1, 1, 1, 1));
        assertTrue(base.insert("ok1", 1, 1, 1, 1));
        assertFalse(base.insert("xles", -1, 1, 1, 1));
        assertFalse(base.insert("yles", 1, -1, 1, 1));
        assertFalse(base.insert("wles", 1, 1, -1, 1));
        assertFalse(base.insert("hles", 1, 1, 1, -1));
        assertFalse(base.insert("xlar", 1, 1, 2000, 1));
        assertFalse(base.insert("ylar", 1, 1, 1, 2000));
    }


    /**
     * THIS IS the method to test the insertHelp method
     */

    public void testInsertHelp() {
        System.out.println("222222222222222222222222");
        assertTrue(base.insert("eee", 1, 1, 1, 1));
        assertTrue(base.insert("ddd", 1, 1, 1, 1));
        assertTrue(base.insert("ddd", 1, 1, 1, 1));
        assertTrue(base.insert("fff", 1, 1, 1, 1));
        assertTrue(base.insert("fff", 1, 1, 1, 1));
    }


    /**
     * this method is used to test the search method
     */
    public void testSearch() {
        System.out.println("33333333333333333333333333333");
        assertFalse(base.search("233"));
        base.insert("eee", 1, 1, 1, 1);
        assertFalse(base.search("233"));
        assertTrue(base.search("eee"));
    }


    /**
     * this is the method to test
     */
    public void testSearchHelp() {
        System.out.println("4444444444444444444444444444");
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        assertTrue(base.search("eee"));
        assertTrue(base.search("ddd"));
        assertTrue(base.search("fff"));
    }


    /**
     * this method is used to test the remove method
     */
    public void testRemove() {
        base.insert("bb", 2, 2, 2, 2);
        base.insert("aa", 2, 2, 2, 6);
        assertTrue(base.remove(2, 2, 2, 6));
        base.remove(2, 2, 2, 2);
        base.insert("bb", 2, 2, 2, 2);
        base.insert("cc", 2, 2, 2, 6);
        assertTrue(base.remove(2, 2, 2, 6));
        base.remove(2, 2, 2, 2);
        base.insert("aa", 1, 1, 1, 1);
        assertFalse(base.remove(3, 1, 1, 1));
        assertFalse(base.remove(1, 3, 1, 1));
        assertFalse(base.remove(1, 1, 3, 1));
        assertFalse(base.remove(1, 1, 1, 3));
        assertTrue(base.remove(1, 1, 1, 1));
        System.out.println("5555555555555555555555555555555");
        assertFalse(base.remove("233"));
        base.insert("eee", 1, 1, 1, 1);
        assertTrue(base.remove("eee"));
        base.insert("eee", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        assertTrue(base.remove("eee"));
        assertTrue(base.remove("fff"));
        // now only leave fff
        base.remove("fff");
        assertFalse(base.remove(2, 3, 3, 3));
        base.insert("eee", 1, 1, 1, 1);
        base.insert("eee", 1, 1, 1, 1);
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        assertTrue(base.remove(1, 1, 1, 1));
        // only ddd
    }


    /**
     * test
     */
    public void testRemoveHelp2() {
        System.out.println("6666666666666666666666666666");
        base.insert("eee", 1, 1, 1, 1);
        assertFalse(base.remove(2, 3, 3, 3));
        base.insert("ddd", 2, 1, 1, 1);
        base.insert("ddd", 2, 1, 1, 1);
        base.insert("ccc", 3, 1, 1, 1);
        assertTrue(base.remove(2, 1, 1, 1));
        base.insert("fff", 2, 1, 1, 2);
        base.insert("fff", 2, 1, 1, 2);
        base.insert("eee", 3, 1, 1, 1);
        assertTrue(base.remove(2, 1, 1, 2));
        assertFalse(base.remove(3, 3, 33, 3));
    }


    /**
     * test
     */
    public void testRemoveHelp() {
        System.out.println("7777777777777777777777777");
        base.insert("eee", 1, 1, 1, 1);
        assertFalse(base.remove("zzz"));
        assertFalse(base.remove("aaa"));
        base.insert("fff", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("ggg", 1, 1, 1, 1);
        base.insert("ccc", 1, 1, 1, 1);
        assertTrue(base.remove("fff"));
        assertTrue(base.remove("ggg"));
        base.insert("fff", 1, 1, 1, 1);
        base.insert("ggg", 1, 1, 1, 1);
        assertTrue(base.remove("ggg"));
        base.insert("ddd", 1, 1, 1, 1);
        assertTrue(base.remove("ddd"));
        assertTrue(base.remove("ccc"));
    }


    /**
     * this method is used to test the region search
     */
    public void testRegionSearch() {
        System.out.println("8888888888888888888888888");
        assertFalse(base.regionsearch(1, 1, -1, 1));
        assertFalse(base.regionsearch(1, 1, -1, -1));
        assertFalse(base.regionsearch(1, 1, 1, -1));
        base.insert("ddd", 1, 1, 1, 1);
        assertFalse(base.regionsearch(5, 5, 2, 1));
        assertTrue(base.regionsearch(1, 1, 1, 5));
    }


    /**
     * this method is used to test the intersection method
     */
    public void testRegionSearchHelp() {
        System.out.println("9999999999999999999999999999999999");
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("ccc", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        base.insert("eee", 1, 1, 1, 1);
        assertFalse(base.regionsearch(5, 5, 2, 1));
        assertTrue(base.regionsearch(1, 1, 1, 1));
    }


    /**
     * test
     */
    public void testIntersections() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        base.insert("ba", 1, 1, 1, 1);
        base.insert("bb", 3, 3, 3, 3);
        assertFalse(base.intersections());
        base.remove("bb");
        base.insert("ab", 1, 1, 1, 1);
        base.insert("aa", 1, 1, 1, 1);
        base.insert("aa", 1, 1, 1, 1);
        base.insert("aa", 1, 1, 1, 1);
        base.insert("aa", 1, 1, 1, 1);
        assertTrue(base.intersections());
        base.remove("ab");
        base.remove("aa");
        base.remove("aa");
        base.remove("aa");
        base.remove("aa");
        base.remove("ba");
        assertFalse(base.intersections());
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 2, 2, 1, 1);
        base.insert("fff", 3, 3, 1, 1);
        base.insert("ddd", 4, 4, 1, 1);
        base.insert("fff", 5, 5, 1, 1);
        base.insert("ccc", 6, 6, 1, 1);
        base.insert("eee", 7, 7, 1, 1);
        assertFalse(base.intersections());
    }


    /**
     * test
     */
    public void testIntersectionsHelp() {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 2, 2, 1, 1);
        base.insert("fff", 3, 3, 1, 1);
        base.insert("ddd", 4, 4, 1, 1);
        base.insert("fff", 5, 5, 1, 1);
        base.insert("ccc", 6, 6, 1, 1);
        base.insert("eee", 7, 7, 1, 1);
        assertFalse(base.intersections());
    }


    /**
     * this method is used to test the dump method
     */
    public void testDump() {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        assertFalse(base.dump());
        base.insert("eee", 1, 1, 1, 1);
        assertTrue(base.dump());
    }


    /**
     * this is the method used to test the dump
     */
    public void testDumpHelp() {
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ccc", 2, 2, 1, 1);
        base.insert("fff", 3, 3, 1, 1);
        base.insert("ddd", 4, 4, 1, 1);
        base.insert("fff", 5, 5, 1, 1);
        base.insert("aaa", 6, 6, 1, 1);
        base.insert("eee", 7, 7, 1, 1);
        assertTrue(base.dump());
    }


    /**
     * this is the method to test the region search, without the valid region
     */
    public void testregionSearch1() {
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        base.insert("eee", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        base.insert("ddd", 1, 1, 1, 1);
        base.insert("ccc", 1, 1, 1, 1);
        base.insert("fff", 1, 1, 1, 1);
        base.insert("eee", 1, 1, 1, 1);
        assertFalse(base.regionsearch(100, 100, 2, 1));
    }


    /**
     * this is a test for findLeftest
     */
    public void testFindLeftest() {
        base.insert("dd", 1, 1, 1, 1);
        base.insert("cc", 1, 1, 1, 1);
        base.insert("bb", 1, 1, 1, 1);
        base.insert("aa", 1, 1, 1, 1);
        assertEquals(((Rectangles)base.findLeftest(base.root).getElement())
            .getName(), "aa");
    }
}
