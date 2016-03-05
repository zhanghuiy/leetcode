/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightTail = rightHead;
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }



    public ListNode partition_version_1(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = null;
        ListNode index = head;
        ListNode tmp = null;
        head = left;
        while(index != null){
            if(index.val < x){
                if(right == null){
                    left.next = index;
                    left = left.next;
                    index = index.next;
                }else{
                    tmp = left.next;
                    left.next = index;
                    left = left.next;
                    index = index.next;
                    left.next = tmp;
                }
            }else{
                if(right == null){
                    right = index;
                    left.next = right;
                }else{
                    right.next = index;
                    right = right.next;
                }
                index = index.next;
                right.next = null;
            }
        }
        return head.next;
    }
}
