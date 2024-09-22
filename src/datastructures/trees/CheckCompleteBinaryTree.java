package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
//https://stackoverflow.com/questions/34851512/why-null-values-are-not-allowed-in-arraydeque
public class CheckCompleteBinaryTree {
    //BFS
    public boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();//Imp: cannot use ArrayDeque as queue here coz Deque won't allow null values
        queue.add(root);
        boolean isNullExists = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                isNullExists = true;
            } else {
                if (isNullExists) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}
