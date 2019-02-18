package Rectangle1;

private static final String[] args = null;
//  On my honor: 
//
//  - I have not used source code obtained from another student,
//  or any other unauthorized source, either modified or
//  unmodified. 
//
//  - All source code and documentation used in my program is
//  either my original work, or was derived by me from the
//  source code published in the textbook for this course. 
//
//  - I have not discussed coding details about this project with
//  anyone other than my partner (in the case of a joint
//  submission), instructor, ACM/UPE tutors or the TAs assigned
//  to this course. I understand that I may discuss the concepts
//  of this program with other students, and that another student
//  may help me debug my program so long as neither of us writes
//  anything during the discussion or modifies any computer file
//  during the discussion. I have violated neither the spirit nor
//  letter of this restriction.


/**
 * For this project, you will create a 
 * simple spatial database for handling inserting, 
 * deleting, and performing queries on a collection of rectangles.
 *  The data structure used to store the 
 * collection will be the Binary Search Tree 
 * @author Zichen Zhu(zichen)
 *
 */
public class Main
{
	public static void Main(String[] args) {
	Parser parser = new Parser(args[0]);
    parser.parseFile();
	}

}
