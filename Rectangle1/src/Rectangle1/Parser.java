package Rectangle1;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.Line;

/**
 * Parser class is used to scan through a file with a scanner 
 * and retrieve specific values to create a list of rectangles. 
 * The scanner willl only attempt to take any action its list if the 
 * correct command is input. An invaild commands will nullify the line
 * 
 * @author zichen
 *
 */
public class Parser {

	//which is the inputfile 
	private String inputFile;
	
	// the SkipList will be defined as a class later
	private database list;
	private String Command;
	private String lineName;
	private int lineX;
	private int lineY;
	private int lineW;
	private int lineH;
	
	

	
	/**
	 * this is the consturctor for parser, stores the filename and creates a 
	 * nre Skiplist
	 * @param file
	 * @param List
	 */
	public Parser(String file)
	{
		inputFile = file;
		list = new database();
		
	}
	
	/**
     * function used to scan through the file input into the main program. if a
     * command is not found as the first string in the line, the line is skipped
     * 
     * @return boolean did the parsing succeed?
     * @precondition the file being input either doesn't exist or exists and
     *               contains the properly formatted commands and inputs
     */
    public boolean parseFile()
    {
        Scanner scanner = null;
        Exception d = null;
        // check to make sure that the file exists in the pwd
        try
        {
            scanner = new Scanner(new File(inputFile));
        }
        catch (FileNotFoundException e)
        { // Create new scanner
            d = e;
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (d == null) // if no error was found, let scanner go through file
        {
            while (scanner.hasNextLine()) ///
            { // While the scanner has information to read
                String line = scanner.nextLine(); // Read the next command
                if(!line.equals("")) {
                	String[] parts = line.split("\\s+");
                	Command = parts[0]; // this is the instruction 
                	lineName = parts[1]; //this is the rectangles's name 
                	lineX = Integer.parseInt(parts[2]); // this is the x position 
                	lineY = Integer.parseInt(parts[3]);  // this is the y position
                	lineW = Integer.parseInt(parts[4]);  // this is the line Width
                	lineY = Integer.parseInt(parts[5]);  // this is the line Height
                
                switch (parts[0])
                {
                    case ("insert"):
                    {
                    	if (checkDimension(lineX, lineY, lineW, lineH))
                    	list.insert(lineName, lineX, lineY, lineW, lineH);
                        break;                   	
                    }
                    case ("remove"):
                    {
                        list.remove(line);
                        break;
                    }
                    case ("regionsearch"):
                    {
                        list.regionsearch(lineX, lineY, lineW, lineH);
                        break;
                    }
                    case ("intersections"):
                    {
                        System.out.println("Intersection pairs:");
                        list.intersections();
                        break;
                    }
                    case ("search"):
                    {
                        list.search(line);
                        break;
                    }
                    case ("dump"):
                    {
                        System.out.println("SkipList dump:");
                        //list.dump();
                        break;
                    }
                    default:
                    {
                        scanner.nextLine();
                        break;
                    }
                }
            }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
   

    /**
     * checks for numeric nature of the string
     * 
     * @param str
     *            string taken to be checked
     * @return a boolean false or true.
     */
    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * helper method to do math regarding the dimensions of the rectangle
     * 
     * @param x
     *            coordinate
     * @param y
     *            coordinate
     * @param width
     *            of rectangle
     * @param height
     *            of rectangle
     * @return a boolean true or false
     */
    public boolean checkDimension(int x, int y, int width, int height)
    {
       // return !(width <= 0 || height <= 0 || x + width > 1024
        //        || y + height > 1024 || x < 0 || y < 0);
    	if (width > 0 && height > 0 && x + width <= 1024
    	               && y + height <= 1024 && x > 0 && y > 0)
    			return true;
    	
    	else 
    		return false;
    } // use it before insert 
	
}
