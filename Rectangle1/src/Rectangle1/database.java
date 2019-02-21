/**
 * 
 * @author Zichen Zhu(zichen), Jingyuan Qi(jingyq1)
 * @version 2/21/2019
 * @param <T> is the object
 */
public class Database<T> {

	private static Node<Rectangles> root;

	private boolean doSomething;
	/**
	 * help variable for search method
	 */
	private String tempInfo;
	/**
	 * count how many Node<Rectangles> does this tree have
	 */
	private int count;
	/**
	 * temp Node<Rectangles> if we need do some temp change to BST
	 */
	private Node<Rectangles> tempRoot;

	/**
	 * protect from print in recursion
	 */

	/**
	 * the constructor of Database. construct a tree with no root
	 */
	public Database() {
		root = null;
		doSomething = false;
		tempInfo = "";
		count = 0;
		// Node<Rectangles> tempRoot = new Node<Rectangles>();
	}

	/**
	 * Insert a rectangle named <name> with upper left corner (x, y), width w and
	 * height h. It is permissible for two or more rectangles to have the same name,
	 * and it is permissible for two or more rectangles to have the same spatial
	 * dimensions and position. The name must \ begin with a letter, and may contain
	 * letters, digits, and underscore characters. Names are case sensitive. A
	 * rectangle should be rejected for insertion if its height or width are not
	 * greater than 0. All rectangles must fit within the ï¿½world box" that is 1024
	 * by 1024 units in size and has upper left corner at (0, 0). If a rectangle is
	 * all or partly out of this box, it should be rejected for insertion.
	 * 
	 * @param nameIn is the
	 * @param xIn    is the
	 * @param yIn    is the
	 * @param wIn    is the
	 * @param hIn    is the
	 * @return true if the insert sucessufully
	 */
	public boolean insert(String nameIn, int xIn, int yIn, int wIn, int hIn) {
		// if the x and y larger then 0, and this rectangle is in 1240*1240,
		// 1240 is changed to 1024 by ZHU
		char c = nameIn.charAt(0);
		// System.out.println("in insert");
		// MAKEUP ZHU Character.isAlphabetic(c)
		if (wIn > 0 && hIn > 0 && xIn >= 0 && yIn >= 0 && xIn + wIn <= 1024 && yIn + hIn <= 1024
				&& Character.isAlphabetic(c)) {

			Rectangles newRec = new Rectangles(nameIn, xIn, yIn, wIn, hIn);
			// create a new Node<Rectangles>
			Node<Rectangles> newNode = new Node<Rectangles>();
			// put rectangle into the Node<Rectangles>
			newNode.setElement(newRec);
			// if there is no root, the tree is empty
			if (root == null) {
				// this new Node<Rectangles> become the root
				root = newNode;

			}
			// the tree has a root, the tree is not empty
			else {
				insertHelp(root, newNode);
			}
			System.out.println(
					"Rectangle accepted: (" + nameIn + ", " + xIn + ", " + yIn + ", " + wIn + ", " + hIn + ")");
			return true;
		}
		// the rectangle cannot be insert
		else {
			System.out.println(
					"Rectangle rejected: (" + nameIn + ", " + xIn + ", " + yIn + ", " + wIn + ", " + hIn + ")");
			return false;

		}

	}

	/**
	 * find where should the new Node<Rectangles> be put
	 * 
	 * @param parents the upper Node<Rectangles>
	 * @param child   object Node<Rectangles> should be put
	 */
	public void insertHelp(Node<Rectangles> parents, Node<Rectangles> child) {
		// child larger or equal than parents
		if (((Rectangles) child.getElement()).compareTo((Rectangles) parents.getElement())) {
			// there is a Node<Rectangles> in left side of parents
			if (parents.getRight() != null) {
				// put the left side Node<Rectangles> and object in another
				// insertHelp
				// function
				insertHelp(parents.getRight(), child);
			}
			// the left side of parents is empty
			else {
				// put the new Node<Rectangles> in left side of this parents
				parents.setRight(child);
			}
		}
		// child is less to parents
		else {
			// there is a Node<Rectangles> on the right of this parents
			if (parents.getLeft() != null) {
				// put the right side Node<Rectangles> and the objective in
				// another
				// insertHelp
				insertHelp(parents.getLeft(), child);
			}
			// there is not any Node<Rectangles> in right side
			else {
				// put the new Node<Rectangles> in right side of this parents
				parents.setLeft(child);
			}
		}
	}

	/**
	 * Return the information about the rectangle(s), if any, that have name name.
	 * If there are more than one rectangle with the same name, you should return
	 * the info for all of them.
	 * 
	 * @param name objective's name
	 * @return information if find some rectangles, or not found if nothing found
	 */
	public boolean search(String name) {
		if (root == null) {
			System.out.println("Rectangle not found: " + name);
			return false;
		}
		searchHelp(root, name);
		// if find some rectangles
		if (doSomething) {
//            // create a new String
//            String temp = new String();
//            
//            temp = tempInfo;
//            // reset tempInfo
			tempInfo = "";
			// reset doSomething
			doSomething = false;
			return true;
		}
		// report reject directly
		System.out.println("Rectangle not found: " + name);
		return false;
	}

	/**
	 * help section for search a specific name rectangle by recursion
	 * 
	 * @param current
	 * @param name    objective name
	 */
	private void searchHelp(Node<Rectangles> current, String name) {
		// if left side has Node<Rectangles>
		if (current.getLeft() != null) {
			// re-run by left Node<Rectangles>
			searchHelp(current.getLeft(), name);
		}
		// if right side has Node<Rectangles>
		if (current.getRight() != null) {
			// re-run by right Node<Rectangles>
			searchHelp(current.getRight(), name);
		}
		// if current rectangle has the objective name
		if (((Rectangles) current.getElement()).getName().equals(name)) {
			// we find at least one rectangle
			doSomething = true;
			System.out.println("Rectangle found: (" + name + ", " + ((Rectangles) current.getElement()).getX() + ", "
					+ ((Rectangles) current.getElement()).getY() + ", " + ((Rectangles) current.getElement()).getW()
					+ ", " + ((Rectangles) current.getElement()).getH() + ")");
		}
	}

	/**
	 * Remove the rectangle with name <name>. If two or more rectangles have the
	 * same name, then any one such rectangle may be removed. If no rectangle exists
	 * with this name, it should be so reported.
	 * 
	 * @param name is the thing
	 * @return true if successufully
	 */
	public boolean remove(String name) {
		// there is at least one Node<Rectangles> in the tree
		if (root != null) {
			// if root is the Node<Rectangles> should be removed
			if (((Rectangles) root.getElement()).getName().equals(name)) {
				// we will remove root, so we did remove a rectangle
				doSomething = true;
				// if there is a Node<Rectangles> on the right side of root
				if (root.getRight() != null) {
					// find the leftest Node<Rectangles> on the right side of
					// root, and put the left side of root into left side of the
					// leftest Node<Rectangles> of right side
					findLeftest(root.getRight()).setLeft(root.getLeft());
					// let the right side Node<Rectangles> become new root
					root = root.getRight();
				}
				// if there is no Node<Rectangles> on right side
				else {
					// let the left side Node<Rectangles> become root
					root = root.getLeft();
				}
			}
			// root is not the Node<Rectangles> should be removed
			else {
				// create a temp Node<Rectangles> called current, let it equal
				// to root
				Node<Rectangles> current = root;
				removeHelp1(current, name);
			}

		}
		// change it from doSomething = false
		// if this method do nothing
		if (!doSomething) {

			// report reject directly
			System.out.println("Rectangle rejected: " + name);

			return false;
		}
		doSomething = false;

		return true;
	}

	/**
	 * help method for remove a specific name.
	 * 
	 * @param current
	 * @param nameIn
	 */
	private void removeHelp1(Node<Rectangles> current, String nameIn) {
		// if the name is larger than or equal to current Node<Rectangles>'s
		// element's name
		// (but actually cannot be equal)
		if (nameIn.compareTo(((Rectangles) current.getElement()).getName()) > 0
				// and current Node<Rectangles>'s
				&& current.getRight() != null) {
			// if the name is equal to right side Node<Rectangles>'s element's
			// name
			if (nameIn.equals(((Rectangles) current.getRight().getElement()).getName())) {
				// if the right side of right side is not null
				if (current.getRight().getRight() != null) {
					// find the leftest Node<Rectangles> of RIGHT RIGHT
					// Node<Rectangles>, and put the
					// LEFT of RIGHT to the
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
			}
			// the object is in right side but not the directly right
			// Node<Rectangles>
			else {
				// run removeHelp by right side Node<Rectangles>
				removeHelp1(current.getRight(), nameIn);
			}
		}
		// the objective is in left side
		else if (nameIn.compareTo(((Rectangles) current.getElement()).getName()) < 0

				&& current.getLeft() != null) {
			// if the name is equal to left side Node<Rectangles>'s element's
			// name
			if (nameIn.equals(((Rectangles) current.getLeft().getElement()).getName())) {
				// the LEFT RIGHT position has a Node<Rectangles>
				if (current.getLeft().getRight() != null) {
					// fin the leftest Node<Rectangles> of LEFT RIGHT
					// Node<Rectangles>, and set its left
					// in LEFT LEFT
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
			}
			// the object is in left side but not the directly left
			// Node<Rectangles>
			else {
				// run removeHelp by left side Node<Rectangles>
				removeHelp1(current.getLeft(), nameIn);
			}
		}
	}

	/**
	 * Remove the rectangle with the specified dimensions. If two or more rectangles
	 * have the same dimensions, then any one such rectangle may be removed. If no
	 * rectangle exists with these dimensions, it should be so reported.
	 * 
	 * @param x is the position
	 * @param y is the position
	 * @param w is the position
	 * @param h is the position
	 * @return true if the successful
	 */
	public boolean remove(int x, int y, int w, int h) {
		// morePrint++;
		// there is at least one Node<Rectangles> in the tree
		if (root != null) {
			// if root is the Node<Rectangles> should be removed
			if (((Rectangles) root.getElement()).getX() == x && ((Rectangles) root.getElement()).getY() == y
					&& ((Rectangles) root.getElement()).getW() == w && ((Rectangles) root.getElement()).getH() == h) {
				// we will remove root, so we did remove a rectangle
				doSomething = true;
				// if there is a Node<Rectangles> on the right side of root
				if (root.getRight() != null) {
					// find the leftest Node<Rectangles> on the right side of
					// root, and put
					// the left side of root into left side of the leftest
					// Node<Rectangles>
					// of
					// right side
					findLeftest(root.getRight()).setLeft(root.getLeft());
					// let the right side Node<Rectangles> become new root
					root = root.getRight();
				}
				// if there is no Node<Rectangles> on right side
				else {
					// let the left side Node<Rectangles> become root
					root = root.getLeft();
				}
			}
			// root is not the Node<Rectangles> should be removed
			else {
				// create a temp Node<Rectangles> called current, let it equal
				// to root
				Node<Rectangles> current = root;
				removeHelp2(current, x, y, w, h);
			}

		}
		// if this method do nothing
		if (!doSomething) {
			System.out.println("Rectangle rejected: " + "(" + x + ", " + y + ", " + w + ", " + h + ")");
			return false;
		}
		// reset doSomething
		doSomething = false;
		return true;
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
	private void removeHelp2(Node<Rectangles> current, int x, int y, int w, int h) {
		// if left side has Node<Rectangles>
		if (current.getLeft() != null) {
			// left Node<Rectangles> is the Node<Rectangles> should be removed
			if (((Rectangles) current.getLeft().getElement()).compareTo(x, y, w, h)) {
				// LEFT RIGHT has Node<Rectangles>
				if (current.getLeft().getRight() != null) {
					// put left side of left Node<Rectangles> to left side of
					// leftest Node<Rectangles>
					// of RIGHT RIGHTT Node<Rectangles>
					findLeftest(current.getLeft().getRight()).setLeft(current.getLeft().getLeft());
					// set left in LEFT RIGHT
					current.setLeft(current.getLeft().getRight());
				}
				// there is no Node<Rectangles> in right of left
				// Node<Rectangles>
				else {
					current.setLeft(current.getLeft().getLeft());
				}
				// we did remove a rectangle
				doSomething = true;
			}
		}
		// if right side has Node<Rectangles>
		if (current.getRight() != null) {
			// right Node<Rectangles> is the Node<Rectangles> should be removed
			if (((Rectangles) current.getRight().getElement()).compareTo(x, y, w, h)) {
				// RIGHT RIGHT has Node<Rectangles>
				if (current.getRight().getRight() != null) {
					// put left side of right Node<Rectangles> to left side of
					// leftest Node<Rectangles>
					// of RIGHT RIGHT Node<Rectangles>
					findLeftest(current.getRight().getRight()).setLeft(current.getRight().getLeft());
					// set right in RIGHT RIGHT
					current.setRight(current.getRight().getRight());
				}
				// there is no Node<Rectangles> in right of right
				// Node<Rectangles>
				else {
					current.setRight(current.getRight().getLeft());
				}
				// we did remove a rectangle
				doSomething = true;
			}
		}
		if (current.getLeft() != null) {
			removeHelp2(current.getLeft(), x, y, w, h);
		}
		if (current.getRight() != null) {
			removeHelp2(current.getRight(), x, y, w, h);
		}
	}

	/**
	 * Report all rectangles currently in the Database that intersect the query
	 * rectangle specified by the regionsearch parameters. For each such rectangle,
	 * list out its name and coordinates. regionsearch command should be rejected if
	 * the height or width is not greater than 0. However, it is (syntactically)
	 * acceptable for the region search rectangle to be all or partly outside of
	 * 1024 by 1024 world box.
	 * 
	 * @param x is the position
	 * @param y is the position
	 * @param w is the position
	 * @param h is the position
	 * @return true if successful
	 */
	public boolean regionsearch(int x, int y, int w, int h) {
		if (h > 0 && w > 0) {
			System.out.println("Rectangles intersecting region (" + x + ", " + y + ", " + w + ", " + h + "):");
			// determine if both length and width larger than zero
			if (root != null) {
				// create a new rectangle with specific size
				Rectangles temp = new Rectangles("temp", x, y, w, h);
				// run help method
				regionsearchHelp(root, temp);
				// if this method do nothing
				if (!doSomething) {
					// report not found
					// changed by Zhu: Comment the following line
					return false;
				}
				// reset doSomething
				doSomething = false;
				return true;
			}
			return false;
		}
		// reject this order
		else {
			System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w + ", " + h + ")");
			return false;
		}
	}

	/**
	 * help method for regionsearch. compare each rectangle in BST with temp
	 * rectangles we created with specific size, if they intersect with each
	 * other,report
	 * 
	 * @param current current Node<Rectangles> need to be operated
	 * @param require temp rectangle with required size and position
	 */
	private void regionsearchHelp(Node<Rectangles> current, Rectangles require) {
		// if left side has Node<Rectangles>
		if (current.getLeft() != null) {
			// re-run by left Node<Rectangles>
			regionsearchHelp(current.getLeft(), require);
		}
		// if right side has Node<Rectangles>
		if (current.getRight() != null) {
			// re-run by right Node<Rectangles>
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
	 * Report all pairs of rectangles within the Database that intersect. rectangles
	 * who share the edge does not count the intersections
	 * 
	 * @return true if successful
	 */
	public boolean intersections() {
		// print title
		System.out.println("Intersection pairs:");
		if (root != null) {
			tempRoot = root;
			// run help section
			intersectionsHelp(tempRoot, tempRoot);
			if (doSomething) {
				doSomething = false;
				return true;
			}
		}
		return false;
	}

	/**
	 * recursion to compare each Node<Rectangles> to each one else
	 * 
	 * @param out Node<Rectangles> we token to compare
	 * @param in  Node<Rectangles> we token to be compared
	 */
	private void intersectionsHelp(Node<Rectangles> out, Node<Rectangles> in) {
		// if left side has Node<Rectangles>
		if (out.getLeft() != null) {
			// re-run by left Node<Rectangles>
			intersectionsHelp(out.getLeft(), in);
			out.setLeft(null);
		}
		// if right side has Node<Rectangles>
		if (out.getRight() != null) {
			// re-run by right Node<Rectangles>
			intersectionsHelp(out.getRight(), in);
			out.setRight(null);
		}
		// if left side has Node<Rectangles>
		if (in.getLeft() != null && in.getLeft() != out) {
			// re-run by left Node<Rectangles>
			intersectionsHelp(out, in.getLeft());
		}
		// if right side has Node<Rectangles>
		if (in.getRight() != null && in.getRight() != out) {
			// re-run by right Node<Rectangles>
			intersectionsHelp(out, in.getRight());
		}
		if (((Rectangles) out.getElement()).intersect((Rectangles) in.getElement())
				&& (out != tempRoot || in != tempRoot)) {
			doSomething = true;
			System.out.println("(" + ((Rectangles) out.getElement()).getName() + ", "
					+ ((Rectangles) out.getElement()).getX() + ", " + ((Rectangles) out.getElement()).getY() + ", "
					+ ((Rectangles) out.getElement()).getW() + ", " + ((Rectangles) out.getElement()).getH() + ") : ("
					+ ((Rectangles) in.getElement()).getName() + ", " + ((Rectangles) in.getElement()).getX() + ", "
					+ ((Rectangles) in.getElement()).getY() + ", " + ((Rectangles) in.getElement()).getW() + ", "
					+ ((Rectangles) in.getElement()).getH() + ")");
		}

	}

	/**
	 * Return a ï¿½dumpï¿½ of the BST. The BST dump should print out each BST
	 * Node<Rectangles> (use the in-order traversal). For each BST Node<Rectangles>,
	 * print that Node<Rectangles>'s depth and value (rectangle info). At the end,
	 * please print out the size of the BST.
	 * 
	 * @return true if successful
	 */
	public boolean dump() {
		// print title
		System.out.println("BST dump:");
		// if the tree is not empty
		if (root != null) {
			dumpHelp(root, 0);
			System.out.println("BST size is: " + count);
			count = 0;
			return true;
		} else {
			System.out.println("Node has depth 0, Value (null)");
			// Change by ZHU
			System.out.println("BST size is: " + 0);
		}

		return false;
	}

	/**
	 * help method for dump
	 * 
	 * @param current is the
	 */
	private void dumpHelp(Node<Rectangles> current, int level) {
		// if left side has Node<Rectangles>
		if (current.getLeft() != null) {
			// re-run by left Node<Rectangles>
			dumpHelp(current.getLeft(), level + 1);
		}
		System.out.println("Node has depth " + level + ", Value (" + ((Rectangles) current.getElement()).getName()
				+ ", " + ((Rectangles) current.getElement()).getX() + ", " + ((Rectangles) current.getElement()).getY()
				+ ", " + ((Rectangles) current.getElement()).getW() + ", " + ((Rectangles) current.getElement()).getH()
				+ ")");
		count++;
		// if right side has Node<Rectangles>
		if (current.getRight() != null) {
			// re-run by right Node<Rectangles>
			dumpHelp(current.getRight(), level + 1);
		}
	}

	/**
	 * help method to find a lowest Node<Rectangles> from one specific
	 * Node<Rectangles>
	 * 
	 * @param ori is "root" of sub tree in which we want to find the lowest
	 *            Node<Rectangles>
	 * @return a Node<Rectangles> which is lowest under ori
	 */
	private Node<Rectangles> findLeftest(Node<Rectangles> ori) {
		// if there is a Node<Rectangles> on left side of current
		if (ori.getLeft() != null) {
			// re-run this function by left side Node<Rectangles>
			return findLeftest(ori.getLeft());
			// if there is no left side
		} else {
			// return itself
			return ori;
		}
	}
}
