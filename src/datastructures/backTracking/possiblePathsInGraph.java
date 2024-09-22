package datastructures.backTracking;

import java.util.ArrayList;
import java.util.List;

//DFS with backtracking
//Time Complexity
//O(2^N) - There will be at most N-1 paths from the source node and every time we have two choices either to choose this path or not. So it each node has a two choices. So for N-1 nodes it has 2^(N-1) choices which is order of 2^N .
//
//Space Complexity
//O(N+E) - We will be traversing all the edges and all the nodes.
//https://www.geeksforgeeks.org/problems/count-the-paths4332/1
public class possiblePathsInGraph {
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        boolean[] visited= new boolean[n];
        List<Integer>[] adj= new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int a=edge[0], b=edge[1];
            adj[a].add(b);
        }
        return paths(s, d, visited, adj);
    }

    int paths(int s, int d, boolean[] visited, List<Integer>[] adj){
        if(visited[s]){
            return 0;
        }
        if(s==d){
            return 1;
        }
        visited[s]=true;
        int res=0;
        for(int i:adj[s]){
            res += paths(i,d,visited,adj);
        }
        visited[s]=false;
        return res;
    }
}
