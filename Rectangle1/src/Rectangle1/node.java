package Rectangle1;

public class node<T> {
    private T element;
    private node Right;
    private node Left;
    // private Rectangles Parents;

    /**
     * 
     */
    public node() {
        element = null;
        Right = null;
        Left = null;
    }

    /**
     * 
     */
    public node(T object, node rightSide, node leftSide) {
        element = object;
        Right = rightSide;
        Left = leftSide;
    }

    /**
     * set the right side child of this node
     * 
     * @param RightIn
     *            right side of this node
     */
    public void setRight(node RightIn) {
        Right = RightIn;
    }

    /**
     * set the left side child of this node
     * 
     * @param LeftIn
     *            left side of this node
     */
    public void setLeft(node LeftIn) {
        Left = LeftIn;
    }

    /**
     * set the element
     * 
     * @param elementIn
     *            rectangle in this node
     */
    public void setElement(T elementIn) {
        element = elementIn;
    }

    /**
     * get the right side child of this node.
     * 
     * @return right side child
     */
    public node getRight() {
        return Right;
    }

    /**
     * get the left side child of this node
     * 
     * @return left side child
     */
    public node getLeft() {
        return Left;
    }

    /**
     * get the rectangle of this node
     * 
     * @return element of this node
     */
    public T getElement() {
        return element;
    }

    // /**
    // * determine if this object is larger or equal than another rectangles
    // *
    // * @param another
    // * rectangle's name
    // * @return if this rectangle is larger or equal to another, return True
    // */
    // public boolean compareTo(node another) {
    // return ((Rectangles)this.getElement()).getName().compareTo(
    // ((Rectangles)another.getElement()).getName()) >= 0;
    // }
}