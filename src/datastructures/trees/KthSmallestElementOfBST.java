package datastructures.trees;

//Time Complexity: O(n) where n is the size of BST
//Auxiliary Space: O(1)
//https://www.youtube.com/watch?v=wGXB9OWhPTg
//https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
public class KthSmallestElementOfBST {
    // Return the Kth smallest element in the given BST in O(1) space
    //Using morris Inorder traversal
    public int KthSmallestElement(Node root, int K) {
        int count = 0;
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                count++;
                if(count==K){
                    return curr.data;
                }
                curr=curr.right;
            }else{
                Node pre=curr.left;
                while(pre.right!=null &&pre.right!=curr){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }else{
                    pre.right=null;
                    count++;
                    if(count==K){
                        return curr.data;
                    }
                    curr=curr.right;
                }
            }
        }

        return -1;
    }
}
