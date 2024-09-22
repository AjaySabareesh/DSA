package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//
//Time Complexity: O(M+N), M is the size of the first tree and N is the size of the second tree
//Auxiliary Space: O(H1 + H2), H1 is the height of the first tree and H2 is the height of the second tree
public class Merge2BST {
    //Function to return a list of integers denoting the node
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> res = new ArrayList<>();
        // Node curr1=root1, curr2=root2;
        Stack<Node> s1= new Stack();
        Stack<Node> s2= new Stack();
        stackLeft(s1, root1);
        stackLeft(s2, root2);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(s2.isEmpty()|| (!s1.isEmpty() && s1.peek().data<=s2.peek().data)){
                Node node = s1.pop();
                res.add(node.data);
                stackLeft(s1,node.right);
            }
            // else if(s1.isEmpty()|| (!s2.isEmpty() && s2.peek().data<=s1.peek().data)){
            else{
                Node node = s2.pop();
                res.add(node.data);
                stackLeft(s2,node.right);
            }
        }
        return res;
    }

    void stackLeft(Stack<Node> stack, Node node){String s="";s.contains("");
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}
