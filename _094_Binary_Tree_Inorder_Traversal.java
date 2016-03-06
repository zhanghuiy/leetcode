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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        inorderTraversalRecursive(root, res);
        return res;
    }
    private void inorderTraversalRecursive(TreeNode node, List<Integer> res){
        if(node.left != null) inorderTraversalRecursive(node.left, res);
        res.add(node.val);
        if(node.right != null) inorderTraversalRecursive(node.right, res);
    }
}
