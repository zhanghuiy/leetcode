/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ml = null;
        ListNode ml_head = ml;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    if(ml == null){
                        ml = l1;
                        ml_head = l1;
                    }else{
                        ml.next = l1;
                        ml = ml.next;
                    }
                    l1 = l1.next;
                }else{
                    if(ml == null){
                        ml = l2;
                        ml_head = l2;
                    }else{
                        ml.next = l2;
                        ml = ml.next;
                    }
                    l2 = l2.next;
                }
            }else if(l1 != null){
                if(ml == null){
                    ml = l1;
                    ml_head = l1;
                }else{
                    ml.next = l1;
                    ml = ml.next;
                }
                l1 = l1.next;
            }else{
                if(ml == null){
                    ml = l2;
                    ml_head = l2;
                }else{
                    ml.next = l2;
                    ml = ml.next;
                }
                l2 = l2.next;
            }
        }
        return ml_head;
    }
}
