package datastructures.trees;

import java.util.HashMap;

//Using DP here - include the node and exclude the node, and select the max among the two
public class MaxSumOfNonAdjNodes {
    //Function to return the maximum sum of non-adjacent nodes.
    HashMap<Node, Integer> maxSumMap = new HashMap<>();

    int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }
        if (maxSumMap.containsKey(root)) {
            return maxSumMap.get(root);
        }
        int incl = root.data;
        if (root.left != null) {
            incl += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        if (root.right != null) {
            incl += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }
        int excl = getMaxSum(root.left) + getMaxSum(root.right);
        int max = Math.max(incl, excl);
        maxSumMap.put(root, max);
        return max;
    }
}
