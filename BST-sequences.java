/** A binary search tree was cretated by traversing thorugh an array from left to right and inserting each element. 
Given a BST with distinct elements, print all possible arrys that oculd have led to this tree.
Example:

   2
  / \
 1   3
 Output: {2, 1, 3}, {2, 3, 1}
 **/
public class Solution {
     public void BSTSequences (TreeNode root, List<Integer> curList) {
//         List<Integer> curList = new ArrayList<Integer>();
        if (root == null) return;
        curList.add(root);
        if (root.left != null) curList.add(root.left);
        if (root.right != null) curList.add(root.right);
        BSTSequences(root.left, curList);
        BSTSequences(root.right, curList);
        if (root.right != null) curList.add(root.right);
        if (root.left != null) curList.add(root.left);
        BSTSequences(root.right, curList);
        BSTSequences(root.left, curList);
     }
    public static void main(String args[]) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();   
    }
}
