package datastructures.algos;

import java.util.PriorityQueue;
import java.util.Queue;

//Imp: MST is only for Undirected graphs. Prim's or Kruskal's algorithm is used to find the minimal spanning tree (MST)
// of an undirected graph. But they do not give the optimal result when applied to directed graphs
//MST using prims algo - with optimizations
public class  MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int min =0 ;
        int v =points.length;
        boolean[] mst = new boolean[v];
        int[] dist = new int[v];//Not mandatory, added for optimization
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Pair> queue = new PriorityQueue<>((a, b)-> a.wt-b.wt);
        queue.add(new Pair(0, 0));
        int cnt=0;//no of vertices connected
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int i=p.node;
            if(mst[i]){
                continue;
            }
            mst[i]=true;
            dist[i]=p.wt;
            min += p.wt;
            cnt++;
            if(cnt==v){//Further optimization
                break;
            }
            for(int j=0;j<v;j++){
                if(i!=j && !mst[j]){
                    int wt = getDist(points, i, j);
                    if(dist[j]>wt){//Not mandatory, added for optimization
                        dist[j]=wt;
                        queue.add(new Pair(j, wt));
                    }
                }
            }
        }
        return min;
    }

    int getDist(int[][] points, int i, int j){
        return Math.abs(points[i][0]-points[j][0]) +  Math.abs(points[i][1]-points[j][1]);
    }
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
}

//Same Problem - Using Prims with Adj Matrix:
//class Solution {
//    public int minCostConnectPoints(int[][] points) {
//        int v = points.length;
//        boolean[] mst = new boolean[v];
//        int[] dist = new int[v];
//        int[][] adj = new int[v][v];
//        for(int i=0;i<v;i++){
//            dist[i]=Integer.MAX_VALUE;
//            for(int j=0;j<v;j++){
//                if(i==j){
//                    adj[i][j]=0;
//                }else{
//                    adj[i][j] = getDist(points, i, j);
//                }
//            }
//        }
//
//        dist[0]=0;
//        for(int cnt=0;cnt<v-1;cnt++){
//            int min = getMin(dist, mst, v);
//            mst[min]=true;
//            for(int j=0;j<v;j++){
//                if(adj[min][j]!=0 && !mst[j] && dist[j] > adj[min][j]){
//                    dist[j] = adj[min][j];
//                }
//            }
//        }
//
//        int minDist = 0 ;
//        for(int i:dist){
//            minDist += i;
//        }
//        return minDist;
//
//    }
//
//    int getDist(int[][] points, int a, int b){
//        int[] point1 = points[a];
//        int[] point2 = points[b];
//        return Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1]);
//    }
//
//    int getMin(int[] dist, boolean[] mst, int v){
//        int min = Integer.MAX_VALUE;
//        int minIdx=0;
//        for(int i=0;i<v;i++){
//            if(!mst[i] && dist[i]<min){
//                min=dist[i];
//                minIdx=i;
//            }
//        }
//        return minIdx;
//    }
//}
