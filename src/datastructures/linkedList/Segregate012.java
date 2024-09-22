package datastructures.linkedList;

public class Segregate012 {
    class Node
    {
        int data;
        Node next;
        boolean visited;
        Node(int d) {data = d; next = null; }

    }
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node head0=null,head1=null,head2=null,tail0=null,tail1=null,tail2=null;
        Node curr=head;
        while(curr!=null){
            int data = curr.data;
            if(data==0){
                if(head0==null){
                    head0=curr;
                    tail0=curr;
                }else{
                    tail0.next=curr;
                    tail0=curr;
                }
            }
            else if(data==1){
                if(head1==null){
                    head1=curr;
                    tail1=curr;
                }else{
                    tail1.next=curr;
                    tail1=curr;
                }
            }
            else if(data==2){
                if(head2==null){
                    head2=curr;
                    tail2=curr;
                }else{
                    tail2.next=curr;
                    tail2=curr;
                }
            }
            curr=curr.next;
        }
        if(tail0!=null)tail0.next=head1!=null?head1:head2;
        if(tail1!=null)tail1.next=head2;
        return head0!=null ? head0 :(head1!=null ? head1:head2);
    }
}
