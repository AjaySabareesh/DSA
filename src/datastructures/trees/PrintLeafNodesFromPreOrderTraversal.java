package datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Logic:
//whenever there is a transition from left to right, the curr value will be > then prev value in BST.
// if thr is only one prev elem < then curr elm, then that could be the root of this right subtree, not the left subtree leaf
//https://www.youtube.com/watch?v=u7OpHQPkLHI
//Inorder Traversal: 10 20 30 100 150 200 300
//Preorder Traversal: 100 20 10 30 200 150 300
public class PrintLeafNodesFromPreOrderTraversal { //Tree is a BST
    public int[] leafNodes(int arr[], int N)
    {
        // code here
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for(int i=1;i<N;i++){
            if(arr[i]<stack.peek()){
                stack.push(arr[i]);
            }else{
                int temp = stack.pop();
                if(!stack.isEmpty() && arr[i]>stack.peek()){
                    while(!stack.isEmpty() && arr[i]>stack.peek()){
                        stack.pop();
                    }
                    res.add(temp);
                }
                stack.push(arr[i]);
            }
        }
        res.add(stack.pop());
        int[] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i]=res.get(i);
        }
        return resArr;
    }
}
