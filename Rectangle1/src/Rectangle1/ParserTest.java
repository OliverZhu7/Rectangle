

import junit.framework.TestCase;
/**
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version this is the 2/19/2019 version 
 * this is the Parser Test class
 *
 */
public class ParserTest extends TestCase {

    private Parser parser1;


    /**
     * this method is used for set up for test cases
     */
    public void setUp() {
        
        parser1 = new Parser("SyntaxTest.txt");
        
    }

    /**
     * this method is used to test the parserFile method
     */
    public void testParserFile() {

        boolean success = parser1.parseFile();
        assertTrue(success);
        System.out.println(parser1.parseFile());

    }

    /**
     * this method is used to test the checkDimension method
     */
    public void testCheckDimension() {
        //assertFalse(parser1.checkDimension(0, 0, 1, 1));
        assertTrue(parser1.checkDimension(1, 1, 1, 1));
        assertFalse(parser1.checkDimension(0, 0, 1025, 1));
        assertFalse(parser1.checkDimension(0, 0, 1, 1025));
        assertFalse(parser1.checkDimension(-1, 1, 1, 1));
        assertFalse(parser1.checkDimension(0, -1, 1, 1));
        assertFalse(parser1.checkDimension(-1, -1, 1, 1));
        assertFalse(parser1.checkDimension(-1, -1, -1, 1));
        assertFalse(parser1.checkDimension(-1, -1, -1, -1));
        assertFalse(parser1.checkDimension(0, 0, 0, 0));
        assertFalse(parser1.checkDimension(0, 0, 1, 0));
    }

}
