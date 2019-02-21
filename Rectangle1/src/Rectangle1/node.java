
/**
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version this is the version
 * @param <T>
 */
public class Node<T> {
    private T element;
    private Node<T> right;
    private Node<T> left;
    // private Node<T><Rectangles> abc;
    // private Rectangles Parents;

    /**
     * this is the Node
     */
    public Node() {
        element = null;
        right = null;
        left = null;
    }

    /**
     * @param object    is the node
     * @param rightSide is the rightNode
     * @param leftSide  is the left node
     */
    public Node(T object, Node<T> rightSide, Node<T> leftSide) {
        element = object;
        right = rightSide;
        left = leftSide;
    }

    /**
     * set the right side child of this Node<T>
     * 
     * @param rightIn right side of this Node<T>
     */
    public void setRight(Node<T> rightIn) {
        right = rightIn;
    }

    /**
     * set the left side child of this Node<T>
     * 
     * @param leftIn left side of this Node<T>
     */
    public void setLeft(Node<T> leftIn) {
        left = leftIn;
    }

    /**
     * set the element
     * 
     * @param elementIn rectangle in this Node<T>
     */
    public void setElement(T elementIn) {
        element = elementIn;
    }

    /**
     * get the right side child of this Node<T>.
     * 
     * @return right side child
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * get the left side child of this Node<T>
     * 
     * @return left side child
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * get the rectangle of this Node<T>
     * 
     * @return element of this Node<T>
     */
    public T getElement() {
        return element;
    }

    // /**
    // * determine if this object is larger or equal than another rectangles
    // *
    // * @param another
    // * rectangle's name
    // * @return if this rectangle is larger or equal to another,return True
    // */
    // public boolean compareTo(Node<T> another) {
    // return ((Rectangles)this.getElement()).getName().compareTo(
    // ((Rectangles)another.getElement()).getName()) >= 0;
    // }
}
