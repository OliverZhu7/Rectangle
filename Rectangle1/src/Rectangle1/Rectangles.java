package Rectangle1;

public class Rectangles {
    private String name;
    private int x;
    private int y;
    private int w;
    private int h;
    // private Rectangles Parents;

    /**
     * the constructor of Rectangles
     * 
     * @param nameIn
     *            the name of rectangles
     * @param xIn
     *            x position of the rectangle
     * @param yIn
     *            y position of the rectangle
     * @param wIn
     *            the width of rectangles
     * @param hIn
     *            the height of rectangles
     */
    public Rectangles(String nameIn, int xIn, int yIn, int wIn, int hIn) {
        name = nameIn;
        x = xIn;
        y = yIn;
        w = wIn;
        h = hIn;
        // Parents = null;
    }

    /**
     * get the name of this rectangle
     * 
     * @return the name of this rectangle
     */
    public String getName() {
        return name;
    }

    /**
     * get the x position of the rectangle
     * 
     * @return x position of the rectangle
     */
    public int getX() {
        return x;
    }

    /**
     * get the y position of the rectangle
     * 
     * @return y position of the rectangle
     */
    public int getY() {
        return y;
    }

    /**
     * get the width of the rectangle
     * 
     * @return width of the rectangle
     */
    public int getW() {
        return w;
    }

    /**
     * get the height of the rectangle
     * 
     * @return height of the rectangle
     */
    public int getH() {
        return h;
    }

    /**
     * determine if this object is larger or equal than another rectangles
     * 
     * @param another
     *            rectangle's name
     * @return if this rectangle is larger or equal to another, return True
     */
    public boolean compareTo(Rectangles another) {
        return this.name.compareTo(another.getName()) >= 0;
    }

    /**
     * determine if this object has a specific size
     * 
     * @param xIn
     *            x position
     * @param yIn
     *            y position
     * @param wIn
     *            width
     * @param hIn
     *            height
     * @return true if the rectangle has a specific size
     */
    public boolean compareTo(int xIn, int yIn, int wIn, int hIn) {
        return x == xIn && y == yIn && w == wIn && h == hIn;
    }

    /**
     * determine if two rectangles intersect
     * 
     * @param obj
     *            another rectangle
     * @return true if they intersect
     */
    public boolean intersect(Rectangles obj) {
        int ox = obj.getX();
        int oy = obj.getY();
        int ow = obj.getW();
        int oh = obj.getH();
        return (x > ox && x < ox + ow && y > oy && y < oy + oh)
                || (x + w > ox && x + w < ox + ow && y > oy && y < oy + oh)
                || (x > ox && x < ox + ow && y + h > oy && y + h < oy + oh)
                || (x + w > ox && x + w < ox + ow && y + h > oy && y + h < oy + oh);
    }
}