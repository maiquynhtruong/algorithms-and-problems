// http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
// http://ideone.com/wQzwrU

public class Main {
	static class Node {
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	Node root;
	//static int min = Integer.MAX_VALUE;
	int traverse(Node root) {
		if (root == null) 
			return 0;
		if (root.leftChild == null && root.rightChild == null)
			return 1;
		if (root.rightChild == null && root.leftChild != null)
			return traverse(root.leftChild) + 1;
		if (root.leftChild == null && root.rightChild != null) 
			return traverse(root.rightChild) + 1;
		return Math.min(traverse(root.leftChild), traverse(root.rightChild)) + 1;
	}

	public static void main(String[] args) {
		Main tree = new Main();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
		tree.root.rightChild = new Node(3);
		tree.root.leftChild.leftChild = new Node(6);
		tree.root.leftChild.rightChild = new Node(9);
		tree.root.rightChild.leftChild = new Node(7);
		tree.root.rightChild.rightChild = new Node(5);
		tree.root.leftChild.leftChild.leftChild = new Node(14);
		tree.root.rightChild.rightChild.rightChild = new Node(10);
		System.out.println(tree.traverse(tree.root));
	}
}