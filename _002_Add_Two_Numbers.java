/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode tail;
        head = tail = null;

        int val = 0;
        int carry = 0;
        while(l1 != null || l2 != null){
            val = 0;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            val += carry;
            if(head == null){
                head = new ListNode(val % 10);
                head.next = null;
                tail = head;
            }else{
                tail.next = new ListNode(val % 10);
                tail.next.next = null;
                tail = tail.next;
            }
            carry = val / 10;
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
            tail.next.next = null;
            tail = tail.next;
            carry = 0;
        }

        return head;
    }
}
