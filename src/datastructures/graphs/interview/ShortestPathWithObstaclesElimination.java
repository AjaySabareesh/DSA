package datastructures.graphs.interview;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
//https://www.youtube.com/watch?v=VPleGcc1nZY
public class ShortestPathWithObstaclesElimination {
    class Node{
        int x,y,k,dist;
        Node(int x, int y, int k, int dist){
            this.x=x;
            this.y=y;
            this.k=k;
            this.dist=dist;
        }
        public String toString(){
            return x+","+y+","+k;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int r=grid.length, c=grid[0].length;
        if(k>=(r-1)+(c-1)){
            return r-1+c-1;
        }
        return bfs(grid, k,r,c);
    }

    int bfs(int[][] grid, int k, int r, int c){//k - removals allowed
        HashSet<String> vis=  new HashSet<>();
        Queue<Node> q= new ArrayDeque<>();
        Node src=new Node(0,0,k,0);
        q.add(src);
        vis.add(src.toString());
        while(!q.isEmpty()){
            Node n=q.poll();
            if(n.x==r-1 && n.y==c-1){
                return n.dist;
            }
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};
            for(int i=0;i<4;i++){
                int x1=n.x+dx[i];
                int y1=n.y+dy[i];
                if(x1>=0 && x1<r && y1>=0 && y1<c){
                    int newK=n.k-grid[x1][y1];
                    String key =x1+","+y1+","+newK;
                    if(newK>=0 && !vis.contains(key)){
                        q.add(new Node(x1,y1,newK,n.dist+1));
                        vis.add(key);
                    }
                }
            }
        }
        return -1;
    }
}
