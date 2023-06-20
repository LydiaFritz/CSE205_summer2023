/**
 * 
 */
package bst;


/**
 * @author lfritz4
 *
 */
public class BinSearchTree<T extends Comparable> {

	// node class
	public class Node {
		public T value;
		public Node left, right;

		Node(T v) {
			value = v;
		}

		void addChild(T value) {
			if (value.compareTo(this.value) < 0) {
				if (this.left == null) {
					this.left = new Node(value);
				} else {
					this.left.addChild(value);
				}
			} else if (value.compareTo(this.value) > 0) {
				if (this.right == null)
					this.right = new Node(value);
				else
					this.right.addChild(value);
			}
		}
	}

	private Node root;
	private int nodeCount;

	public BinSearchTree() {
		root = null;
		nodeCount = 0;
	}

	public boolean containsItem(T val) {
		return containsItem(val, root);
	}

	private boolean containsItem(T val, Node curr) {
		if (curr == null)
			return false;
		else if (val.equals(curr.value))
			return true;
		else {
			if (val.compareTo(curr.value) < 0)
				return containsItem(val, curr.left);
			else
				return containsItem(val, curr.right);
		}
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public boolean add(T val) {
		if (root == null) {
			root = new Node(val);
			nodeCount++;
			return true;
		}
		if (!containsItem(val, root)) {
			root.addChild(val);
			nodeCount++;
			return true;
		}
		return false;
	}

	// traversal method 1
	public void print1() {
		print1(root);
	}

	private void print1(Node curr) {
		if (curr != null) {
			System.out.print(curr.value + " ");
			print1(curr.left);
			print1(curr.right);
		}
	}

	// traversal method 2
	public void print2() {
		print2(root);
	}

	private void print2(Node curr) {
		if (curr != null) {
			print2(curr.left);
			print2(curr.right);
			System.out.print(curr.value + " ");
		}
	}

	// traversal method 3
	public void print3() {
		print3(root);
	}

	private void print3(Node curr) {
		if (curr != null) {
			print3(curr.left);
			System.out.print(curr.value + " ");
			print3(curr.right);
		}
	}

	public void remove(T val) {
		remove(val, root);
	}

	private void remove(T val, Node curr) {

		Node parent = null;
		// look for the node
		while (curr != null) {

			// found it
			if (curr.value.equals(val)) {

				// we found the node, check num children

				// is it a leaf?
				if (curr.left == null && curr.right == null) {
					// is it the root?
					if (parent == null) {
						root = null;
					} else if (parent.left == curr) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				}

				// 1 child on right?
				else if (curr.left == null) {
					// child is on the right
					// is it the root?
					if (parent == null) {
						root = curr.right;
					}
					// is curr the left or the right?
					else if (parent.right == curr) {
						parent.right = curr.right;
					} else {
						parent.left = curr.right;
					}
				}

				// 1 child on left?
				else if (curr.right == null) {
					if (parent == null) {
						root = curr.left;
					} else if (parent.left == curr)
						parent.left = curr.right;
					else
						parent.right = curr.left;
				}

				// 2 children
				else {
					// Find successor (leftmost child of right subtree)
					Node successor = curr.right;

					while (successor.left != null) {
						// keep going left
						successor = successor.left;
					}

					// get the data in the successor
					T successor_data = successor.value;
					// remove the successor node
					remove(successor.value, root);
					// overwrite the data in curr with this data
					curr.value = successor_data;
				}
				// node is removed, return
				return;

			}
			// search left subtree
			else if (val.compareTo(curr.value) < 0) {
				remove(val, curr.left);
			}
			// search right subtree
			else {
				remove(val, curr.right);
			}

		}
	}

}
