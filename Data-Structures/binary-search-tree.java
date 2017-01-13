/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BST {
    public static TreeNode successor(TreeNode cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode temp = null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                temp = root.right;
                root.right = null;
                return temp;
            } else if (root.right == null) {
                temp = root.left;
                root.left = null;
                return temp;
            }
            temp = successor(root.right);
            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        }
        return root; 
    }
}
