package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//https://www.youtube.com/watch?v=UcDZM6Ap5P4
//https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=leetcode-75
//TC-O(Queries * (V+E)), SC - O(V+E)
public class EvaluateDivision {
    class Node{
        String key;
        double val;
        Node(String k, double v){
            this.key=k;
            this.val=v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        HashMap<String, List<Node>> adj = new HashMap<>();
        for(int i=0;i<values.length;i++){
            List<String> edge=equations.get(i);
            String a=edge.get(0), b=edge.get(1);
            double wt=values[i];
            adj.putIfAbsent(a, new ArrayList<>());
            adj.get(a).add(new Node(b, wt));
            adj.putIfAbsent(b, new ArrayList());
            adj.get(b).add(new Node(a, 1/wt));
        }
        for(int i=0;i<queries.size();i++){
            List<String> query= queries.get(i);
            res[i]=dfs(query.get(0),query.get(1),new HashSet<>(), adj);
        }
        return res;
    }

    double dfs(String src, String dest, HashSet<String> visited, HashMap<String, List<Node>> adj){
        if(!adj.containsKey(src)|| !adj.containsKey(dest)){
            return -1.0;
        }
        if(src.equals(dest)||visited.contains(src)){
            return 1.0;
        }
        visited.add(src);
        for(Node n: adj.get(src)){
            if(!visited.contains(n.key)){
                double ans = dfs(n.key, dest,visited, adj);
                if(ans!=-1.0){
                    return ans * n.val;
                }
            }
        }
        return -1.0;
    }
}
