/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // check the validity of input
        ListNode dummy = head;
        for(int i = 1; i <= n; i++){
            if(dummy == null) return head;
            dummy = dummy.next;
        }

        // put a dummy node in front of head;
        // to ensure consistency when m equals to 1
        dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i = 0; i < n - m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }


        return dummy.next;
    }
}
