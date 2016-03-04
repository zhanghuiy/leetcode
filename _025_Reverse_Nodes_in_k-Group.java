/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null){
            return head;
        }
        ListNode ret = head;
        for(int i = 0; i < k - 1; i++){
            ret = ret.next;
            if(ret == null){
                return head;
            }
        }
        ret = null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode last_tail = null;
        int count = 0;
        while(fast != null){

            if(count == k - 1){

                count = 0;


                ListNode left = slow;
                ListNode mid = left.next;
                ListNode right = mid.next;

                while(mid != fast){
                    mid.next = left;
                    left = mid;
                    mid = right;
                    right = right.next;
                }
                mid.next = left;

                if(last_tail != null){
                    last_tail.next = fast;
                }
                last_tail = slow;
                slow.next = right;

                if(ret == null){
                    ret = fast;
                }
                fast = slow.next;
                slow = fast;

            }

            if(fast != null){
                fast = fast.next;
                count++;
            }
        }
        return ret;
    }
}
