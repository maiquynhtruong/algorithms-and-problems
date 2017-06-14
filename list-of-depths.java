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
    
    List<List<TreeNode>> lists2 = new ArrayList<List<TreeNode>>();
    public static void listOfDepths(TreeNode root, int level) {
        if (root == null) return;
        List<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        while (current.size() > 0) {
            lists2.add(current);
            ArrayList<TreeNode> parents = current;
            current = new ArrayList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
    }
    
    public static void main(String args[]) {
        lists = new ArrayList<List<Integer>>();
        listsOfDepth(root, 0);
    }
  
}

