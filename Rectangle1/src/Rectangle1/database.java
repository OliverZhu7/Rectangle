package Rectangle1;



public class database {
    /**
     * root of BST
     */
    private node root;
    /**
     * determine if one method do any operation at least one time
     */
    private boolean doSomething;
    /**
     * help variable for search method
     */
    private String tempInfo;

    /**
     * the constructor of database. construct a tree with no root
     */
    public database() {
        root = null;
        doSomething = false;
        tempInfo = "";
    }

    /**
     * Insert a rectangle named <name> with upper left corner (x, y), width w and
     * height h. It is permissible for two or more rectangles to have the same name,
     * and it is permissible for two or more rectangles to have the same spatial
     * dimensions and position. The name must begin with a letter, and may contain
     * letters, digits, and underscore characters. Names are case sensitive. A
     * rectangle should be rejected for insertion if its height or width are not
     * greater than 0. All rectangles must fit within the ¡°world box" that is 1024
     * by 1024 units in size and has upper left corner at (0, 0). If a rectangle is
     * all or partly out of this box, it should be rejected for insertion.
     * 
     * @param nameIn
     * @param xIn
     * @param yIn
     * @param wIn
     * @param hIn
     */
    public void insert(String nameIn, int xIn, int yIn, int wIn, int hIn) {
        // if the x and y larger then 0, and this rectangle is in 1240*1240, then
        if (wIn > 0 && hIn > 0 && xIn >= 0 && yIn >= 0 && xIn + wIn <= 1240 && yIn + hIn <= 1240) {
            // create a new rectangle
            Rectangles newRec = new Rectangles(nameIn, xIn, yIn, wIn, hIn);
            // create a new node
            node newNode = new node();
            // put rectangle into the node
            newNode.setElement(newRec);
            // if there is no root, the tree is empty
            if (root == null) {
                // this new node become the root
                root = newNode;
            }
            // the tree has a root, the tree is not empty
            else {
                insertHelp(root, newNode);
            }
            // the rectangle cannot be insert
        } else {
            System.out.println(
                    "Rectangle rejected: (" + nameIn + ", " + xIn + ", " + yIn + ", " + wIn + ", " + hIn + ")");
        }

    }

    /**
     * find where should the new node be put
     * 
     * @param parents
     *            the upper node
     * @param child
     *            object node should be put
     */
    public void insertHelp(node parents, node child) {
        // parents is large or equal to child, child less than parents
        if (((Rectangles) parents.getElement()).compareTo((Rectangles) child.getElement())) {
            // there is a node in left side of parents
            if (parents.getLeft() != null) {
                // put the left side node and object in another insertHelp
                // function
                insertHelp(parents.getLeft(), child);
            }
            // the left side of parents is empty
            else {
                // put the new node in left side of this parents
                parents.setLeft(child);
            }
        }
        // child is larger or equal to parents
        else {
            // there is a node on the right of this parents
            if (parents.getRight() != null) {
                // put the right side node and the objective in another
                // insertHelp
                insertHelp(parents.getRight(), child);
            }
            // there is not any node in right side
            else {
                // put the new node in right side of this parents
                parents.setRight(child);
            }
        }
    }

    /**
     * Return the information about the rectangle(s), if any, that have name name.
     * If there are more than one rectangle with the same name, you should return
     * the info for all of them.
     * 
     * @param name
     *            objective's name
     * @return information if find some rectangles, or not found if nothing found
     */
    public String search(String name) {
        searchHelp(root, name);
        // if find some rectangles
        if (doSomething) {
            // create a new String
            String temp = new String();
            temp = tempInfo;
            // reset tempInfo
            tempInfo = "";
            // reset doSomething
            doSomething = false;
            return temp;
        }
        // report reject directly
        System.out.println("Rectangle not found: " + name);
        return "Rectangle not found: " + name;
    }

    /**
     * help section for search a specific name rectangle by recursion
     * 
     * @param current
     * @param name
     *            objective name
     */
    private void searchHelp(node current, String name) {
        // if left side has node
        if (current.getLeft() != null) {
            // re-run by left node
            searchHelp(current.getLeft(), name);
        }
        // if right side has node
        if (current.getRight() != null) {
            // re-run by right node
            searchHelp(current.getRight(), name);
        }
        // if current rectangle has the objective name
        if (((Rectangles) current.getElement()).getName().equals(name)) {
            // we find at least one rectangle
            doSomething = true;
            // add information to tempInfo
            tempInfo += "(" + name + ", " + ((Rectangles) current.getElement()).getX() + ", "
                    + ((Rectangles) current.getElement()).getY() + ", " + ((Rectangles) current.getElement()).getW()
                    + ", " + ((Rectangles) current.getElement()).getH() + ")" + "\n";
        }
    }

    /**
     * Remove the rectangle with name <name>. If two or more rectangles have the
     * same name, then any one such rectangle may be removed. If no rectangle exists
     * with this name, it should be so reported.
     * 
     * @param name
     */
    public void remove(String name) {
        // there is at least one node in the tree
        if (root != null) {
            // if root is the node should be removed
            if (((Rectangles) root.getElement()).getName().equals(name)) {
                // we will remove root, so we did remove a rectangle
                doSomething = true;
                // if there is a node on the right side of root
                if (root.getRight() != null) {
                    // find the leftest node on the right side of root, and put
                    // the left side of root into left side of the leftest node of
                    // right side
                    findLeftest(root.getRight()).setLeft(root.getLeft());
                    // let the right side node become new root
                    root = root.getRight();
                    // re-run remove() function from new root to avoid the
                    // new root is also node should be removed
                    remove(name);
                }
                // if there is no node on right side
                else {
                    // let the left side node become root
                    root = root.getLeft();
                }
            }
            // root is not the node should be removed
            else {
                // create a temp node called current, let it equal to root
                node current = root;
                removeHelp1(current, name);
            }

        }
        // if this method do nothing
        if (doSomething == false) {
            // report reject directly
            System.out.println("Rectangle rejected " + name);
        }
        // reset doSomething
        doSomething = false;
    }

    /**
     * help method for remove a specific name.
     * 
     * @param current
     * @param nameIn
     */
    private void removeHelp1(node current, String nameIn) {
        // if the name is larger than or equal to current node's element's name
        // (but actually cannot be equal)
        if (nameIn.compareTo(((Rectangles) current.getElement()).getName()) >= 0
                // and current node's right side has a node
                && current.getRight() != null) {
            // if the name is equal to right side node's element's name
            if (nameIn.equals(((Rectangles) current.getRight().getElement()).getName())) {
                // if the right side of right side is not null
                if (current.getRight().getRight() != null) {
                    // find the leftest node of RIGHT RIGHT node, and put the LEFT of RIGHT to the
                    // left of the leftest
                    findLeftest(current.getRight().getRight()).setLeft(current.getRight().getLeft());
                    // remove the right by set the right in RIGHT RIGHT
                    current.setRight(current.getRight().getRight());
                }
                // if the RIGHT RIGHT is null
                else {
                    // remove the right by set right in RIGHT LEFT
                    current.setRight(current.getRight().getLeft());
                }
                // we did remove a rectangle
                doSomething = true;
                // re-run the current, to protect from the new right also need be removed
                removeHelp1(current, nameIn);
            }
            // the object is in right side but not the directly right node
            else {
                // run removeHelp by right side node
                removeHelp1(current.getRight(), nameIn);
            }
        }
        // the objective is in left side
        else if (nameIn.compareTo(((Rectangles) current.getElement()).getName()) < 0
                // and current node's left side has a node
                && current.getLeft() != null) {
            // if the name is equal to left side node's element's name
            if (nameIn.equals(((Rectangles) current.getLeft().getElement()).getName())) {
                // the LEFT RIGHT position has a node
                if (current.getLeft().getRight() != null) {
                    // fin the leftest node of LEFT RIGHT node, and set its left in LEFT LEFT
                    findLeftest(current.getLeft().getRight()).setLeft(current.getLeft().getLeft());
                    // set current left in LEFT RIGHT
                    current.setLeft(current.getLeft().getRight());
                }
                // the LEFT RIGHT position is null
                else {
                    // set current left in LEFT LEFT
                    current.setLeft(current.getLeft().getLeft());
                }
                // we did remove a rectangle
                doSomething = true;
                // re-run the current, to protect from the new left also need be removed
                removeHelp1(current, nameIn);
            }
            // the object is in left side but not the directly left node
            else {
                // run removeHelp by left side node
                removeHelp1(current.getLeft(), nameIn);
            }
        }
    }

    /**
     * Remove the rectangle with the specified dimensions. If two or more rectangles
     * have the same dimensions, then any one such rectangle may be removed. If no
     * rectangle exists with these dimensions, it should be so reported.
     * 
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void remove(int x, int y, int w, int h) {
        // there is at least one node in the tree
        if (root != null) {
            // if root is the node should be removed
            if (((Rectangles) root.getElement()).getX() == x && ((Rectangles) root.getElement()).getY() == y
                    && ((Rectangles) root.getElement()).getW() == w && ((Rectangles) root.getElement()).getH() == h) {
                // we will remove root, so we did remove a rectangle
                doSomething = true;
                // if there is a node on the right side of root
                if (root.getRight() != null) {
                    // find the leftest node on the right side of root, and put
                    // the left side of root into left side of the leftest node of
                    // right side
                    findLeftest(root.getRight()).setLeft(root.getLeft());
                    // let the right side node become new root
                    root = root.getRight();
                    // re-run remove() function from new root to avoid the
                    // new root is also node should be removed
                    remove(x, y, w, h);
                }
                // if there is no node on right side
                else {
                    // let the left side node become root
                    root = root.getLeft();
                }
            }
            // root is not the node should be removed
            else {
                // create a temp node called current, let it equal to root
                node current = root;
                removeHelp2(current, x, y, w, h);
            }

        }
        // if this method do nothing
        if (doSomething == false) {
            // report reject directly
            System.out.println("Rectangle rejected " + x + y + w + h);
        }
        // reset doSomething
        doSomething = false;
    }

    /**
     * help method for remove a specific size and position rectangle by recursion.
     * 
     * @param current
     * @param x
     * @param y
     * @param w
     * @param h
     */
    private void removeHelp2(node current, int x, int y, int w, int h) {
        // if left side has node
        if (current.getLeft() != null) {
            // re-run by left node
            removeHelp2(current.getLeft(), x, y, w, h);
            // left node is the node should be removed
            if (((Rectangles) current.getLeft().getElement()).compareTo(x, y, w, h)) {
                // LEFT RIGHT has node
                if (current.getLeft().getRight() != null) {
                    // put left side of left node to left side of leftest node of RIGHT RIGHTT node
                    findLeftest(current.getLeft().getRight()).setLeft(current.getLeft().getLeft());
                    // set left in LEFT RIGHT
                    current.setLeft(current.getLeft().getRight());
                }
                // there is no node in right of left node
                else {
                    current.setLeft(current.getLeft().getLeft());
                }
                // we did remove a rectangle
                doSomething = true;
            }
        }
        // if right side has node
        if (current.getRight() != null) {
            // re-run by right node
            removeHelp2(current.getRight(), x, y, w, h);
            // right node is the node should be removed
            if (((Rectangles) current.getRight().getElement()).compareTo(x, y, w, h)) {
                // RIGHT RIGHT has node
                if (current.getRight().getRight() != null) {
                    // put left side of right node to left side of leftest node of RIGHT RIGHT node
                    findLeftest(current.getRight().getRight()).setLeft(current.getRight().getLeft());
                    // set right in RIGHT RIGHT
                    current.setRight(current.getRight().getRight());
                }
                // there is no node in right of right node
                else {
                    current.setRight(current.getRight().getLeft());
                }
                // we did remove a rectangle
                doSomething = true;
            }
        }
    }

    /**
     * Report all rectangles currently in the database that intersect the query
     * rectangle specified by the regionsearch parameters. For each such rectangle,
     * list out its name and coordinates. regionsearch command should be rejected if
     * the height or width is not greater than 0. However, it is (syntactically)
     * acceptable for the region search rectangle to be all or partly outside of
     * 1024 by 1024 world box.
     * 
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void regionsearch(int x, int y, int w, int h) {
        // determine if both length and width larger than zero
        if (w > 0 && h > 0) {
            // create a new rectangle with specific size
            Rectangles temp = new Rectangles("temp", x, y, w, h);
            // run help method
            regionsearchHelp(root, temp);
            // if this method do nothing
            if (doSomething == false) {
                // report not found
                System.out.println("Rectangle not found: (" + x + y + w + h + ")");
            }
            // reset doSomething
            doSomething = false;
        }
        // reject this order
        else {
            System.out
                    .println("Rectangles intersecting region (" + x + ", " + y + ", " + w + ", " + h + ") is rejected");
        }
    }

    /**
     * help method for regionsearch. compare each rectangle in BST with temp
     * rectangles we created with specific size, if they intersect with each other,
     * report
     * 
     * @param current
     *            current node need to be operated
     * @param require
     *            temp rectangle with required size and position
     */
    private void regionsearchHelp(node current, Rectangles require) {
        // if left side has node
        if (current.getLeft() != null) {
            // re-run by left node
            regionsearchHelp(current.getLeft(), require);
        }
        // if right side has node
        if (current.getRight() != null) {
            // re-run by right node
            regionsearchHelp(current.getRight(), require);
        }
        // if current rectangle intersects the objective
        if (((Rectangles) current.getElement()).intersect(require)) {
            // we find at least one rectangle
            doSomething = true;
            // print information of this rectangle
            System.out.println("(" + ((Rectangles) current.getElement()).getName() + ", "
                    + ((Rectangles) current.getElement()).getX() + ", " + ((Rectangles) current.getElement()).getY()
                    + ", " + ((Rectangles) current.getElement()).getW() + ", "
                    + ((Rectangles) current.getElement()).getH() + ")");
        }
    }

    /**
     * Report all pairs of rectangles within the database that intersect.
     */
    public void intersections() {
        // print title
        System.out.println("Intersection pairs: ");
        // run help section
        intersectionsHelp(root, root);
    }

    /**
     * recursion to compare each node to each one else
     * 
     * @param out
     *            node we token to compare
     * @param in
     *            node we token to be compared
     */
    private void intersectionsHelp(node out, node in) {
        // if left side has node
        if (out.getLeft() != null) {
            // re-run by left node
            intersectionsHelp(out.getLeft(), in);
        }
        // if right side has node
        if (out.getRight() != null) {
            // re-run by right node
            intersectionsHelp(out.getRight(), in);
        }
        // if left side has node
        if (in.getLeft() != null) {
            // re-run by left node
            intersectionsHelp(out, in.getLeft());
        }
        // if right side has node
        if (in.getRight() != null) {
            // re-run by right node
            intersectionsHelp(out, in.getRight());
        }
        if (((Rectangles) out.getElement()).intersect((Rectangles) in.getElement())) {
            System.out.println("(" + ((Rectangles) out.getElement()).getName() + ", "
                    + ((Rectangles) out.getElement()).getX() + ", " + ((Rectangles) out.getElement()).getY() + ", "
                    + ((Rectangles) out.getElement()).getW() + ", " + ((Rectangles) out.getElement()).getH() + ") and ("
                    + ((Rectangles) in.getElement()).getName() + ", " + ((Rectangles) in.getElement()).getX() + ", "
                    + ((Rectangles) in.getElement()).getY() + ", " + ((Rectangles) in.getElement()).getW() + ", "
                    + ((Rectangles) in.getElement()).getH() + ")");
        }
    }

    // public void dump() {
    //
    // }

    /**
     * help method to find a lowest node from one specific node
     * 
     * @param ori
     *            is "root" of sub tree in which we want to find the lowest node
     * @return a node which is lowest under ori
     */
    private node findLeftest(node ori) {
        // if there is a node on left side of current
        if (ori.getLeft() != null) {
            // re-run this function by left side node
            return findLeftest(ori.getLeft());
            // if there is no left side
        } else {
            // return itself
            return ori;
        }
    }
}