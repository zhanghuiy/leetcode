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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeAux(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTreeAux(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR){
        if(inR < inL) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int inMid = inL;
        while(inMid <= inR && inorder[inMid] != postorder[postR]) inMid ++;
        int leftNum = inMid - inL;
        int rightNum = inR - inMid;
        if(leftNum == 0){
            root.left = null;
        }else{
            root.left = buildTreeAux(inorder, inL, inMid-1, postorder, postL, postL+leftNum-1);
        }
        if(rightNum == 0){
            root.right = null;
        }else{
            root.right = buildTreeAux(inorder, inMid+1, inR, postorder, postL+leftNum, postR-1);
        }
        return root;
    }
}
