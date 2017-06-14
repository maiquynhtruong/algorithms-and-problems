/** Given a binary tree, create a linked list of all nodes at each depth **/
public class Solution {
    List<List<Integer>> lists;
    public static void listOfDepths(TreeNode root, int level) {
        lists.get(level).add(root.left);
        lists.get(level).add(root.right);
        listOfDepths(root.left, level+1);
        listOfDepths(root.right, level+1);
    }
    public static void main(String args[]) {
        lists = new ArrayList<List<Integer>>();
        listsOfDepth(root, 0);
    }
  
}
