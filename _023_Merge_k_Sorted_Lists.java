import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int count = 0;
        Comparator<QueueElement> comp = new Comparator<QueueElement>(){
            public int compare(QueueElement e1, QueueElement e2){
                if(e1.getVal() < e2.getVal()){
                    return -1;
                }else if(e1.getVal() == e2.getVal()){
                    return 0;
                }else{
                    return 1;
                }
            }
        };
        PriorityQueue<QueueElement> q = new PriorityQueue<>(11, comp);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                QueueElement e = new QueueElement(lists[i].val, i);
                q.add(e);
                count++;
                lists[i] = lists[i].next;
            }
        }
        if(count == 0){
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        while(!q.isEmpty()){
            QueueElement e = q.poll();
            int val = e.getVal();
            int pos = e.getPos();
            ListNode newNode = new ListNode(val);
            newNode.next = null;
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
            if(lists[pos] != null){
                q.add(new QueueElement(lists[pos].val, pos));
                lists[pos] = lists[pos].next;
            }
        }
        return head;
    }

    public class QueueElement{
        int val;
        int pos;
        public int getVal(){
            return this.val;
        }
        public int getPos(){
            return this.pos;
        }
        public QueueElement(int val, int pos){
            this.val = val;
            this.pos = pos;
        }
    }
}
