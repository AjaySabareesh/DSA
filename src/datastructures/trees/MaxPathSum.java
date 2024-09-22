package datastructures.trees;

//https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
public class MaxPathSum {
    //Function to return maximum path sum from any node in a tree.
    int maxSum = Integer.MIN_VALUE;
    int findMaxSum(Node node)
    {
        findMaxSumUtil(node);
        return maxSum;
    }

    int findMaxSumUtil(Node node)
    {
        if(node==null){
            return 0;
        }
        int leftSum = findMaxSumUtil(node.left);
        int rightSum = findMaxSumUtil(node.right);
        int single_subtree_max = Math.max(Math.max(leftSum, rightSum) +node.data , node.data);
        //combining both sides if this is final result
        int combinedSum = node.data+leftSum+rightSum;
        maxSum = Math.max(maxSum, Math.max(single_subtree_max, combinedSum));
        //while returning, send only single subtree path max
        return single_subtree_max;
    }
}
