
//import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import javax.sound.sampled.Line;

/**
 * Parser class is used to scan through a file with a scanner and retrieve
 * specific values to create a list of rectangles. The scanner willl only
 * attempt to take any action its list if the correct command is input. An
 * invaild commands will nullify the line
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version 2/19/2019
 *
 */
public class Parser {


    private String inputFile;
    private Database list;
    private String command;
    private String lineName;
    private int lineX;
    private int lineY;
    private int lineW;
    private int lineH;
    private Scanner scanner;

    /**
     * this is the consturctor for parser, stores the filename and creates a nre
     * Skiplist
     * 
     * @param file is the file we want to exam 
     */
    public Parser(String file) {
        inputFile = file;
        list = new Database();

    }

    /**
     * function used to scan through the file input into the main program. if a
     * command is not found as the first string in the line, the line is skipped
     * 
     * @return boolean did the parsing succeed?
     * @precondition the file being input either doesn't exist or exists and
     *               contains the properly formatted commands and inputs
     */
    public boolean parseFile() {
        // Scanner scanner = null;
        // check to make sure that the file exists in the pwd
        try {
            scanner = new Scanner(new File(inputFile));
            while (scanner.hasNextLine()) { 
                parserHelp();
            }
            return true;
        } 
        catch (FileNotFoundException e) { // Create new scanner
            //e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * this is the parser help
     */
    public void parserHelp() {
        // Scanner scanner = null;
        String line = scanner.nextLine(); // Read the next command
        line = line.trim();
        if (!line.equals("")) {
            String[] parts = line.split("\\s+");
                 
            command = parts[0]; // this is the instruction
            switch (command) {
                case ("insert"): {
                    try {
                        lineName = parts[1]; // this is the rectangles's name
                        lineX = Integer.parseInt(parts[2]);
                        lineY = Integer.parseInt(parts[3]);
                        lineW = Integer.parseInt(parts[4]);
                        lineH = Integer.parseInt(parts[5]);
                        if (checkDimension(lineX, lineY, lineW, lineH)) {
                            list.insert(lineName, lineX, lineY, lineW, lineH);
                        //System.out.println(parts[0] + " " + part
                            //    + " " + parts[5] + "  T);
                        } 
                        else {
						/*
						 * System.out.println(new String().format( "Rectangle rejected: " +
						 * "(%s, %d, %d, %d, %d)", parts[1], lineX, lineY, lineW, lineH));
						 */
                        	System.out.println("Rectangle rejected: "+parts[1] + " " + lineX 
                        			+ " "+ lineY + " "+lineW +" "+ lineH+")");
                        }
                     
                    }
                    catch (Exception e) {
                        StringBuilder sb = new 
                                StringBuilder("Rectangle rejected: (");
                        for (int i = 1; i < parts.length; i++) {
                            if (i == parts.length - 1) {
                                sb.append(parts[i] + ")");
                            }
                            else {
                                sb.append(parts[i] + ", ");
                            }
                        }
                        System.out.println(sb.toString());
                    }
                    break;
                }
                case ("remove"): {
                    if (parts.length == 2) {
                        lineName = parts[1];
                        list.remove(lineName);
                    }
                    if (parts.length == 5) {
                        lineX = Integer.parseInt(parts[1]);
                        lineY = Integer.parseInt(parts[2]);
                        lineW = Integer.parseInt(parts[3]);
                        lineH = Integer.parseInt(parts[4]);
                        list.remove(lineX, lineY, lineW, lineH);
                    }
                    break;
                }
                case ("regionsearch"): {
                    // if(parts.length == 5)
                    lineX = Integer.parseInt(parts[1]);
                    lineY = Integer.parseInt(parts[2]);
                    lineW = Integer.parseInt(parts[3]);
                    lineH = Integer.parseInt(parts[4]);
                    list.regionsearch(lineX, lineY, lineW, lineH);
                   
                    break;
                }
                case ("intersections"): {
                    list.intersections();
                    break;
                }
                case ("search"): {
                    lineName = parts[1];
                    list.search(lineName);
                    break;
                }
                case ("dump"): {
                    //System.out.println("BST dump:");
                    list.dump();
                    break;
                }
                default: {
                    // scanner.nextLine();
                    break;
                }
            }

        }
    }



    /**
     * helper method to do math regarding the dimensions of the rectangle
     * 
     * @param x      coordinate
     * @param y      coordinate
     * @param width  of rectangle
     * @param height of rectangle
     * @return a boolean true or false
     */
    public boolean checkDimension(int x, int y, int width, int height) {
        return (width > 0 && height > 0 && x + width <= 1024 
                && y + height <= 1024 && x >= 0 && y >= 0);
    } // use it before insert
    // EVEN IF THERE WAS NO INTERSECTION, PRINT ""
    //REGIOIN SEARCH, IF THERE WAS NOT Valid THING

}
