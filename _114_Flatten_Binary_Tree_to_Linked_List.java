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

    private TreeNode rightmost = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            rightmost = root;
            return;
        }
        if(root.left == null && root.right != null){
            flatten(root.right);
            return;
        }
        if(root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            return;
        }
        if(root.left != null && root.right != null){
            flatten(root.right);
            TreeNode rightRightmost = rightmost;
            flatten(root.left);
            TreeNode leftRightmost = rightmost;
            leftRightmost.right = root.right;
            root.right = root.left;
            root.left = null;
            rightmost = rightRightmost;
            return;
        }
    }

    // other's brilliant solution !
    private TreeNode prev = null;
    public void flatten_others(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


}
