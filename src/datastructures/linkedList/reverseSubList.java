package datastructures.linkedList;

public class reverseSubList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        Node prevToM = null, nextToN=null, nodeM=null, nodeN=null;
        int count =0;
        Node curr = head, next=null,prev=null;
        boolean reverse=false;
        while(curr!=null){
            count++;
            if(count==m){
                nodeM=curr;
                reverse=true;
            }else if(count==m-1){
                prevToM=curr;
            }
            if(count==n){
                nodeN=curr;
            }else if(count==n+1){
                reverse=false;
                nextToN=curr;
            }
            if(reverse){
                next= curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }else{
                curr=curr.next;
            }
        }
        if(prevToM!=null){
            prevToM.next=nodeN;
        }
        if(nodeM!=null){
            nodeM.next=nextToN;
        }
        if(m==1){
            return nodeN;
        }else{
            return head;
        }
    }
}
