/** Given a binary tree, create a linked list of all nodes at each depth **/
public class Solution {
    List<List<Integer>> lists;
    public static void listOfDepths(TreeNode root, int level) {
        if (root == null) return;
        if (lists.size() == level) lists.add(new LinkedList<Integer>());
        lists.get(level).add(root.val);
        listOfDepths(root.left, level+1);
        listOfDepths(root.right, level+1);
    }
    public static void main(String args[]) {
        lists = new ArrayList<List<Integer>>();
        listsOfDepth(root, 0);
    }
  
}

