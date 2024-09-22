package datastructures.graphs;

import java.util.*;

public class cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node ans = new Node(node.val);
        Queue<Node> q1= new ArrayDeque<>();
        q1.add(node);
        Queue<Node> q2= new ArrayDeque<>();
        q2.add(ans);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, ans);
        //BFS
        while(!q1.isEmpty()){
            Node n1=q1.poll();
            Node n2=q2.poll();
            for(Node child:n1.neighbors){
                if(map.containsKey(child)){
                    n2.neighbors.add(map.get(child));
                }else{
                    Node copy = new Node(child.val);
                    n2.neighbors.add(copy);
                    map.put(child, copy);
                    q1.add(child);
                    q2.add(copy);
                }
            }
        }
        return ans;
    }
}
