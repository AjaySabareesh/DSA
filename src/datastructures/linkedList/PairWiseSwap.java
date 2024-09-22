package datastructures.linkedList;

public class PairWiseSwap {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        // code here
        Node a = head, prev =null;
        head = a.next!= null ? a.next:a;
        while(a!=null && a.next!=null){
            Node b=a.next;
            Node c=b.next;
            b.next=a;
            a.next=c;
            if(prev!=null){
                prev.next=b;
            }
            prev=a;
            a=c;
        }
        return head;
    }
}
