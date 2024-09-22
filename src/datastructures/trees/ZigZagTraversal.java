package datastructures.trees;

import java.util.ArrayList;
import java.util.Stack;

//Zig - left to right, Zag - right to left
public class ZigZagTraversal {
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        Stack<Node> temp = null;
        boolean leftToRight = true;
        curr.push(root);
        while(!curr.isEmpty()){
            Node node = curr.pop();
            res.add(node.data);
            if(leftToRight){
                if(node.left!=null){
                    next.push(node.left);
                }
                if(node.right!=null){
                    next.push(node.right);
                }
            }else{
                if(node.right!=null){
                    next.push(node.right);
                }
                if(node.left!=null){
                    next.push(node.left);
                }
            }
            if(curr.isEmpty()){
                temp=curr;
                curr=next;
                next=temp;
                leftToRight = !leftToRight;
            }
        }
        return res;
    }
}
