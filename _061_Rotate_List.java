/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode fast = head;
        int length = 1;
        while( fast.next != null ){
            fast = fast.next;
            length ++;
        }
        k = k % length;
        if( k == 0 ){
            return head;
        }
        ListNode slow = head;
        for(int i = 0; i < length-k-1; i++){
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
 }
// public class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         int n = 1;
//         ListNode last = head;
//         while(last.next != null){
//             last = last.next;
//             n ++;
//         }
//         k = k % n;
//         if( k == 0){
//             return head;
//         }
//         ListNode newFirst = head;
//         int firstPosition = 0;
//         while( firstPosition != n - k - 1){
//             newFirst = newFirst.next;
//             firstPosition++;
//         }
//         ListNode newLast = newFirst;
//         newFirst = newFirst.next;
//         newLast.next = null;
//         last.next = head;
//         return newFirst;
//     }
// }
