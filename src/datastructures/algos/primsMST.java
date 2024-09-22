package datastructures.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//
//Time Complexity: O(E*log(E)) or O(E*log(V)) where E is the number of edges
//        Auxiliary Space: O(V+2E) O(V^2) where V is the number of vertex
//keep a parent[] arr for each vertices if we want to print the MST https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
//or maintain a list of edges forming MST

//Prims is best to use for dense graphs (complete graph) and it is suitable only for connected graphs
//Kruskal is best to use for graph with less edges or disconnected components

//https://open.kattis.com/problems/muddyhike - can be solved with Prims algo taking matrix values as edge weights
public class primsMST {
    int spanningTree(int V, int E, int edges[][]){
        List<List<Edge>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int st = edge[0];
            int end = edge[1];
            int w=edge[2];
            if(st!=end){//removing self loops
                adjList.get(st).add(new Edge(st,end,w));
                adjList.get(end).add(new Edge(end,st,w));
            }
        }
//In general, Priority Queue doesn't allow null values.Also, priority queues do not order equal-priority items based on arrival time.
//If you want to do that, you need to create your own comparison function that compares not only the priority value
// but also the arrival time (or perhaps a monotonically increasing sequence number). The key here is that the priority queue itself doesn't care about insertion order.
        int weight=0;
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b)-> a.w-b.w);//parallel edges will be taken care by PQ
        boolean[] mst = new boolean[V];//similar to visited
        queue.add(new Edge(-1,0,0));
        int count=0;
        while(!queue.isEmpty()){
            Edge e = queue.poll();
            if(mst[e.end]){
                continue;
            }
            mst[e.end]=true;
            weight += e.w;
            if(++count==V){ //Pruning optimization - optional
                return weight;
            }
            for(Edge edge:adjList.get(e.end)){
                if(!mst[edge.end]){
                    queue.add(edge);
                }
            }

        }
        return weight;
    }

    class Edge{
        int st;
        int end;
        int w;

        Edge(int st,int end, int w){
            this.st=st;
            this.end=end;
            this.w = w;
        }
    }
}
