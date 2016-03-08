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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preRight < preLeft) return null;
        int inSplit = inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        while(inSplit <= inRight && inorder[inSplit] != preorder[preLeft]){
            inSplit ++;
        }
        int leftCount = inSplit - inLeft;
        int rightCount = inRight - inSplit;
        if(leftCount == 0){
            root.left = null;
        }else{
            root.left = buildTreeHelper(preorder, preLeft+1, preLeft+leftCount, inorder, inLeft, inSplit-1);
        }
        if(rightCount == 0){
            root.right = null;
        }else{
            root.right = buildTreeHelper(preorder, preLeft+leftCount+1, preRight, inorder, inSplit+1, inRight);
        }
        return root;
    }

    public TreeNode buildTree_Copy_Array(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int pivot = 0;
        while(pivot < inorder.length && inorder[pivot] != preorder[0]){
            pivot ++;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1,1+pivot), Arrays.copyOfRange(inorder, 0,pivot));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1+pivot, preorder.length), Arrays.copyOfRange(inorder, pivot+1,inorder.length));
        return root;
    }
}
