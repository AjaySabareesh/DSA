package datastructures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class BottomView {
    //Function to return a list containing the bottom view of the given tree.
    // Time Complexity: O(N )
    // Auxiliary Space: O(N)
    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        root.hd=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left=0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            map.put(node.hd, node.data);
            left=Math.min(left, node.hd);
            if(node.left!=null){
                node.left.hd=node.hd-1;
                queue.add(node.left);
            }
            if(node.right!=null){
                node.right.hd=node.hd+1;
                queue.add(node.right);
            }
        }
        while(map.containsKey(left)){
            res.add(map.get(left));
            left++;
        }
        return res;
    }
}
