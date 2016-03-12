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
    private int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sumNumbersHelper(root, 0);
        return totalSum;
    }
    private void sumNumbersHelper(TreeNode root, int partialSum){
        if(root.left == null && root.right == null){
            totalSum += partialSum*10+root.val;
        }else{
            if(root.left != null){
                sumNumbersHelper(root.left, partialSum*10+root.val);
            }
            if(root.right != null){
                sumNumbersHelper(root.right, partialSum*10+root.val);
            }
        }
    }
}
