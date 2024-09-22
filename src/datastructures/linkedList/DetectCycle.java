package datastructures.linkedList;

public class DetectCycle {
    class Node
    {
        int data;
        Node next;
//        boolean visited;
        Node(int d) {data = d; next = null; }
    }
    public static boolean detectLoop(Node head){
        // Add code here
        // while(head!=null){
        //     if(head.visited){
        //         return true;
        //     }
        //     head.visited=true;
        //     head=head.next;
        // }
        // return false;

        //Another approach
        /*By using Floyd’s Cycle-Finding Algorithm: This algorithm is used to find a loop in a linked list. It uses two pointers one moving twice as fast as the other one. The faster one is called the faster pointer and the other one is called the slow pointer, if both pointers meet then the cycle is present otherwise not.
         */
        Node slow=head,fast=head.next;
        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
