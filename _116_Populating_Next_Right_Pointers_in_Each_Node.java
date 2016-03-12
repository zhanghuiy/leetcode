/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        connectHelper(root.left, root.right);
    }

    private void connectHelper(TreeLinkNode n1, TreeLinkNode n2){
        n1.next = n2;
        if(n1.left != null){ // assume that a perfect BST is given
            connectHelper(n1.right, n2.left);
            connectHelper(n1.left,n1.right);
            connectHelper(n2.left,n2.right);
        }
    }
}
