/** Given a sorted (increasing) array with unique integers, create a BST with minimal height **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {this.val = val;}
}
public class Solution {
    public TreeNode createTree(TreeNode root, int[] arr, int start, int end) {
        if (root.left == null && root.right == null) return root;
        TreeNode leftSubtree = createTree(new TreeNode(arr[(end - start) / 4]), arr, 0, (end - start) / 2);
        TreeNode rightSubtree = createTree(new TreeNode(arr[3 * (end - start) / 4]), (end - start) / 2 + 1, end);
        root.left = leftSubtree;
        root.right = rightSubtree;
    }
    public static void main(String args[]) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        createTree(new TreeNode(arr[arr.length/2]), arr, 0, arr.length);
    }
}
    
    
