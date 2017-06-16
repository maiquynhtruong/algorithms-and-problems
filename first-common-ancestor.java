/**FInd teh first common ancestor of two nodes in a binary tree (not a BST) **/
public class Solution {
    public TreeNode getCommonAncestor(TreeNode root) {
        if (!covers(root, p) || !covers(root, q)) {
            return root;
        } else if (covers(root, p)) {
            return q;
        } else if (covers(root, q)) {
            return p;
        }
        TreeNode parent = p.parent;
        TreeNode sibling = getSibling(p);
        while(!covers(sibling, q)) {
            sibling = getSibling(p)
            parent = parent.parent;
        }
        return parent;
    }
    public boolean covers(TreeNode root, TreeNode q) {
        if (root == null) return false;
        if (root == q) return true;
        return covers(root.left, q) || covers(root.right, q);
    }
    public TreeNode getSibling(TreeNode root) {
        if (root == null || root.parent == null) return null;
        TreeNode parent = root.parent;
        if (parent.left == node) return parent.right;
        else return parent.left;
    }
    public static void main(String args[]) {
        
    }
}
