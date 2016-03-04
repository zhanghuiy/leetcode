/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        ListNode mid = head;

        mid.next = right.next;
        right.next = mid;
        if(left == head){
            head = right;
        }
        right = mid;
        while(right.next != null && right.next.next != null){
            left = mid;
            mid = mid.next;
            right = mid.next;
            mid.next = right.next;
            right.next = mid;
            left.next = right;
            right = mid;
        }
        return head;
    }
}
