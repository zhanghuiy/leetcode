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
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && slow.next != null){
            if(slow.val == slow.next.val){
                slow.next = slow.next.next;
            }else{
                slow = slow.next;
            }
        }
        return head;
    }
}
