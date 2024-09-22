package datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//https://leetcode.com/problems/critical-connections-in-a-network/solutions/382638/dfs-detailed-explanation-o-e-solution/
//DFS
public class CriticalBridgesInGraph {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(List<Integer> conn: connections){
            int a=conn.get(0);
            int b=conn.get(1);
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] rank = new int[n];// this stores min rank which can be visited through that node
        Arrays.fill(rank, -2);//Used -2 instead of -1 here so that for node 0, rank-1 for parent check won't fail'
        dfs(0, 0, adj, rank);
        return res;
    }

    int dfs(int node, int myRank, ArrayList<Integer>[] adj, int[] rank){
        if(rank[node]!=-2){
            return rank[node];
        }
        rank[node]=myRank;
        int minRank = myRank;
        for(int next:adj[node]){
            if(rank[next]==myRank-1){
                continue;//parent node
            }
            int nextRank = dfs(next, myRank+1, adj, rank);
            if(nextRank > myRank){//this is a critical edge
                res.add(Arrays.asList(node, next));
            }
            minRank = Math.min(minRank,nextRank);
        }
        rank[node]=minRank;//this line is important to update the arr - this stores min rank which can be visited through that node
        return minRank;
    }
}
