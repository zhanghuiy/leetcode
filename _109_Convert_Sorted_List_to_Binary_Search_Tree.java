/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    // if we traverse the BST using DFS in in-order
    // we can get the nodes with the same order with the List
    // we can use a global variable to store the index of list
    // of pass the position by return value
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode pivot = head;
        while(pivot != null){
            length ++;
            pivot= pivot.next;
        }
        if(length == 0) return null;
        TreeNode root = new TreeNode(0);
        sortedListToBST_helper(root, head, 0, length-1);
        return root;
    }

    private ListNode sortedListToBST_helper(TreeNode root, ListNode head, int start, int end){
        if(start == end){
            root.val = head.val;
            root.left = null;
            root.right = null;
            return head.next;
        }else{
            int mid = start + (end - start) / 2;
            root.left = null;
            root.right = null;
            if(mid - start >= 1){
                root.left = new TreeNode(0);
                head = sortedListToBST_helper(root.left, head, start, mid-1);
            }
            root.val = head.val;
            head = head.next;
            if(end - mid >= 1){
                root.right = new TreeNode(0);
                head = sortedListToBST_helper(root.right, head, mid+1, end);
            }
        }
        return head;
    }
}
