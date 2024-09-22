package datastructures.trees;

import java.util.ArrayList;

//https://www.scaler.com/topics/boundary-traversal-of-binary-tree/
//Time complexity: O(n), n is the number of nodes in the tree. Since we are traversing each node at most once thus the worst case time complexity in this case would be the time taken to traverse each node once.
//Space Complexity: O(h), h is the height of a tree.Because at any time the maximum number of nodes in the recursion call stack would be the height of the tree.
public class BoundaryTraversalOfBT {
    ArrayList<Integer> boundary(Node node)
    {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(node.data);
        if(!isLeaf(node)){
            leftBoundary(node.left, res);
            leafNodes(node, res);
            rightBoundary(node.right, res);
        }
        return res;
    }

    boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }

    void leftBoundary(Node node, ArrayList <Integer> res){
        if(node == null){
            return;
        }
        while(!isLeaf(node)){
            res.add(node.data);
            node =  node.left != null ? node.left : node.right;
        }
    }

    void leafNodes(Node node, ArrayList <Integer> res){
        if(node == null){
            return;
        }
        if(isLeaf(node)){
            res.add(node.data);
        }else{
            leafNodes(node.left, res);
            leafNodes(node.right, res);
        }
    }

    void rightBoundary(Node node, ArrayList <Integer> res){
        if(node == null || isLeaf(node)){
            return;
        }
        rightBoundary((node.right != null ? node.right : node.left), res);
        res.add(node.data);
    }
}
