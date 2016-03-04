/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = null;
        int i = n;
        while( fast != null && i > 0 ){
            fast = fast.next;
            i--;
        }
        while( fast != null ){
            fast = fast.next;
            if(slow != null){
                slow = slow.next;
            }else{
                slow = head;
            }
        }
        if(slow != null){
            slow.next = slow.next.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
