package datastructures;
import java.util.*;
import java.lang.*;

//DFS Iterative approach
class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        stack.push(0);
        while(!stack.isEmpty()){
            int elem = stack.pop();
            if(visited[elem]){
                continue;
            }
            res.add(elem);
            visited[elem]=true;
            ArrayList<Integer> list = adj.get(elem);
            for(int i=list.size()-1;i>=0;i--){
                if(!visited[list.get(i)]){
                    stack.push(list.get(i));
                }
            }
        }

        return res;
    }
}