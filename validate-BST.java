/**implement a function to check if a binary tree is a BST **/

public class Solution {
    public static boolean checkBST(TreeNode root) {
        return checkBSTWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean checkBSTWithRange(TreeNode root, int min, int max) {
        if (root.left.val > root.val) return false;
        if (root.right.val < root.val) return false;
        if (!checkBSTWithRange(root.left, max, root.val)) return false;
        if (!checkBSTWithRange(root.right, root.val, max)) return false;
        return true;
    }
    public static void main(String args[]) {

    }
}
