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

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return  isValidBSTHelper(root, Integer.MIN_VALUE,  Integer.MAX_VALUE);
    }
    // ^
    // |
    // | optimized
    // |
    public boolean isValidBST_old(TreeNode root) {
        if(root == null) return true;
        long val = (long)root.val;
        return  isValidBSTHelper(root.left, Integer.MIN_VALUE,  val - 1) &&
                isValidBSTHelper(root.right, val + 1, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long min, long max){
        if(root == null) return true;
        long val = (long)root.val;
        if(val < min || val > max) return false;
        return isValidBSTHelper(root.left, min, val-1) && isValidBSTHelper(root.right, val+1, max );
    }
}
