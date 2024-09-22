package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int m=grid.length, n=grid[0].length;

        Queue<Node> q = new ArrayDeque<>();
        outerloop:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i, j, m, n, grid, q);//mark -2 for visited island
                    break outerloop;
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            Node node = q.poll();
            int x= node.x, y=node.y;
            if(grid[x][y]==-1){
                continue;
            }
            if(grid[x][y]==1){
                return node.step-1;
            }
            grid[x][y]=-1;//visited water

            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};
            for(int i=0;i<4;i++){
                int x1=x+dx[i], y1=y+dy[i];
                if(x1>=0 && y1>=0 && x1<m && y1<n && grid[x1][y1]>=0){
                    q.add(new Node(x1,y1,node.step+1));
                }
            }
        }
        return -1;
    }


    class Node{
        int x,y, step;
        Node(int x, int y, int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
    }

    //dfs(i, j, m, n, grid, queue);//mark -2 for visited island and add to q
    void dfs(int x, int y, int m, int n, int[][] grid, Queue<Node> q){
        if(x<0||y<0||x>m-1||y>n-1||grid[x][y]!=1){
            return ;
        }
        grid[x][y]=-2;//
        q.add(new Node(x,y,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for(int i=0;i<4;i++){
            int x1=x+dx[i], y1=y+dy[i];
            dfs(x1,y1, m, n, grid, q);
        }
    }
}
