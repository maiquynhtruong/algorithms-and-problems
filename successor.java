/** Find the "next" node (in-order successor) of a given node in a binary search tree. Each node has a link to its parent**/
public class TreeNode {
    int val;
    TreeNode left, right, parent;
    public TreeNode(int val) {this.val = val);
}
public class Solution {
    public static TreeNode findSuccessor(TreeNode root) {
        if (root.right != null) return findLeftmostNode(root.right);
        else {
            TreeNode parent = root.parent;
            while (parent.val < root.val) {
                parent = parent.parent;   
            }
            return parent;
        }
    }
    
    public static TreeNode findLeftmostNode(TreeNode root) {
        if (root.left == null) return root;   
        while (root.left != null) root = root.left;
        return root;
    }
    public static void main(String args[]) {
           
    }
}
