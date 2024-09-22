package datastructures.trees;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
public class CountNodesEqualToAvg {
    int count =0 ;
    public int averageOfSubtree(Node root) {
        if(root==null){
            return 0;
        }
        postTraverse(root);
        return count;
    }

    int[] postTraverse(Node node){
        if(node==null){
            return new int[]{0,0};//sum , nodes
        }
        int sum=node.data, nodes=1;
        int[] left = postTraverse(node.left);
        int[] right = postTraverse(node.right);
        sum += left[0]+right[0];
        nodes += left[1]+right[1];
        if((sum/nodes) ==  node.data){
            count++;
        }
        return new int[]{sum,nodes};
    }
}
