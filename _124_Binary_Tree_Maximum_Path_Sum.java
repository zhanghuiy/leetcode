/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPathSumHelper_better_style(root);
        return max;
    }
    private int maxPathSumHelper_better_style(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(maxPathSumHelper(root.left),0);
        int rightMax = Math.max(maxPathSumHelper(root.right),0);
        max = Math.max(leftMax+rightMax+root.val, max);
        return Math.max(leftMax,rightMax)+root.val;
    }
    private int maxPathSumHelper(TreeNode root){
        if(root == null) return 0;
        int leftMax = maxPathSumHelper(root.left);
        int rightMax = maxPathSumHelper(root.right);
        int sumUp = leftMax + rightMax + root.val;
        int curMax = Math.max(Math.max(Math.max(leftMax+root.val,rightMax+root.val), sumUp),root.val);
        max = Math.max(curMax, max);
        return Math.max(Math.max(leftMax,rightMax)+root.val, root.val);
    }
}
