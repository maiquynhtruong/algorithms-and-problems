public class Solution {
    int sum = 8;
    public int findPaths(TreeNode root, int runningSum) {
        if (root == null) return 0;
        if (root.val + runningSum < sum) {
            runningSum += root.val;
            return findPaths(root.left, runningSum) + findPaths(root.right, runningSum);
        }
        if (root.val + runningSum > sum) {
            if (root.val > sum) runningSum = 0;
            else runningSum = root.val;
            return findPaths(root.left, runningSum) + findPaths(root.right, runningSum);
        }
        if (root.val + runningSum == sum) {
            runningSum = 0;
            return 1 + findPaths(root.left, runningSum) + findPaths(root.right, runningSum);
        }
    }
    public static void main(String args[]) {
        
    }
}
