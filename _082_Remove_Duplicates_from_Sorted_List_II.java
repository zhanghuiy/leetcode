/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pivot = new ListNode(0); // pivot->head->...
        pivot.next = head;
        ListNode slow = pivot;
        ListNode fast = head;
        while(slow != null && slow.next != null){
            fast = slow.next;
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            if(slow.next == fast){
                // an unique element found
                slow = slow.next;
            }else{
                // duplicate elements
                slow.next = fast.next;
            }
        }
        return pivot.next;
    }
    public ListNode deleteDuplicates_version_1(ListNode head) {
        if(head == null) return head;
        ListNode pivot = new ListNode(0);
        pivot.next = head;
        ListNode slow = pivot;
        ListNode fast = pivot;
        while(slow.next != null && slow.next.next != null){
            if(slow.next.val == slow.next.next.val){
                // eliminate duplicat elements
                fast = slow.next;
                int val = fast.val;
                while(fast != null && fast.val == val){
                    fast = fast.next;
                }
                slow.next = fast;
            }else{
                // find an unique element
                slow = slow.next;
            }
        }
        return pivot.next;
    }
}
