/** Given a sorted (increasing) array with unique integers, create a BST with minimal height **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
public class Solution {
    public TreeNode createTree(int[] arr, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(arr[(end + start) / 2]);
        TreeNode leftSubtree = createTree(arr, 0, (end + start) / 2 - 1);
        TreeNode rightSubtree = createTree(arr, (end + start) / 2 + 1, end);
        root.left = leftSubtree;
        root.right = rightSubtree;
    }
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        createTree(arr, 0, arr.length);
    }
}
    
    
