package datastructures.linkedList;

import java.util.PriorityQueue;
import java.util.Queue;

//similar thing with arrays: https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
public class MergeKSortedLists {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    //TC-O(N log K) - K lists, N - no. of nodes in each list
    //SC-O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((a, b)->a.val-b.val);
        for(ListNode n : lists) {
            if (n != null) {
                q.add(n);
            }
        }


        //Maintain start and tail. While q isNotEmpty, tail next = next from q.
        ListNode start = new ListNode(0);//dummy
        ListNode tail = start;
        while(!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            //BUT, if tail.next is NOT null, you will need to add that node to the queue.
            if(tail.next != null)
                q.add(tail.next);
        }
        return start.next;
    }
}
