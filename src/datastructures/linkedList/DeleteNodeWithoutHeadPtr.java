package datastructures.linkedList;

public class DeleteNodeWithoutHeadPtr {
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    //No head ptr ref and node to be deleted won't be the last element
    void deleteNode(Node del)
    {
        // Your code here
        del.data=del.next.data;
        del.next=del.next.next;
    }
}
