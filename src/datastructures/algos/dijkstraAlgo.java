package datastructures.algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Single src shortest path algo, cannot be used with neg weights
//Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree.
//TC - O(V + E log E) or O(V + E log V)
//SC - O(V)

//Bellman Ford Algo - https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/?ref=lbp
// (small alteration to above code in gfg link. if we are counting intermediate nodes/edges, use prev dist and curr dist similar to Bellman ford code used in below link so that it works properly
//https://www.geeksforgeeks.org/maximum-cost-path-from-source-node-to-destination-node-via-at-most-k-intermediate-nodes/
//otherwise, we can even use BFS with nodes step count to find shortest path with k intermediate nodes
//single src shortest path algo , works with neg weights but not with neg cycle
//https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/361711/java-dfs-bfs-bellman-ford-dijkstra-s/
//https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/340911/understanding-bellman-ford/

//Floyd Warshall Algo - https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/?ref=lbp
//All src shortest path algo, works with neg weights but not with neg cycle
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solutions/

//Dijkstra - V + ElogE - SSSP Single Source Shortest Path
//Bellman Ford - VE - SSSP
//Floyd Warshall - V^3 - MSSP
//https://leetcode.com/discuss/general-discussion/969327/Graph-Algorithms-One-Place-or-Dijkstra-or-Bellman-Ford-or-Floyd-Warshall-or-Prims-or-Kruskals-or-DSU
public class dijkstraAlgo {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    //Use BFS along with priority queue heap
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] wt = new int[V];
        boolean[] spt = new boolean[V];//is included or not in the shortest path, optional - not required, dist will take care
        for(int i=0;i<V;i++){
            wt[i]=Integer.MAX_VALUE;
        }
        wt[S]=0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b)->a.dist-b.dist);//sorted by node weight. In case of Prim's algo for MST, it is done by edge weight
        queue.add(new Pair(S,0));
        while(!queue.isEmpty()){
            int u = queue.poll().node;
            if(spt[u]){
                continue;
            }
            spt[u] = true;
            for(ArrayList<Integer> list:adj.get(u)){
                int v = list.get(0);
                if(!spt[v] && wt[u]+list.get(1) <wt[v]){
                    wt[v]=wt[u]+list.get(1);
                    queue.add(new Pair(v, wt[v]));
                }
            }
        }
        return wt;
    }
}
