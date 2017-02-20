/**
 * The diameter of a tree is the number of nodes on the longest path between two leaves 
in the tree.
 * The diameter of a tree T is the largest of the following quantities:
 * the diameter of T's left subtree
 * the diameter of T's right subtree
 * the longest path between leaves that go through the root of T (can be computed from the heights
of all the subtrees of T)
 **/
class Node {
	int data;
	Node left, right;
	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
}
public class BinaryTree {
	Node root;
	int diameter(Node root) {
		if (root == null) return 0;
		// get heights of left and right subtrees
		int lheight = height(root.left);
		int rheight = height(root.right);

		// get the diameter of left and right subtrees
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		// return max of the three
		// 1) diameter of left subtree
		// 2) diameter of right subtree
		// 3) height of left subtree + height of right subtree + 1
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	/**
	 * computes the 'height' of a tree. Height is the number of nodes
	 * along the longest path from the root node down to the 
	 * farthest leaf node
	 **/
	int height(Node node) {
		if (node == null) return 0;		
		return 1 + Math.max(height(node.left), height(node.right));
	}
}

/** 
 * Optimization can be achieved by calculating the height in the same recursion rather
 * than call height() separately.
 **/

class Height {
	int val;
}
class BinaryTree2 {

	Node root;
	int helper(Node node, Height height) {
		/**
		 * hl -> height of left subtree
		 * hr -> height of right subtree
		 **/
		Height hl = new Height(), hr = new Height();
		if (node == null) {
			height.val = 0;
			return 0;
		}
		/**
		 * ldia -> diameter of left subtree
		 * rdia -> diameter of right subtree
		 **/
		hl.val++; hr.val++;
		int ldia = helper(node.left, hl);
		int rdia = helper(node.right, hr);
		// height of current node is max of heights of left and right subtrees plus 1
		height.val = Math.max(hl.val, hr.val) + 1;
		return Math.max(hl.val + hr.val + 1, Math.max(ldia, rdia));
	}
	int diameter() {
		Height height = new Height();
		return helper(root, height);
	}
	
}
