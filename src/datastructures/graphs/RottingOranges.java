package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Queue;
//TC-O(M*N), SC-O(M*N)
//https://leetcode.com/problems/rotting-oranges/description/

//Word Ladder - BFS problem: https://www.youtube.com/watch?v=5iFZP-f40iI&list=PLtQWXpf5JNGLGkKSGYW6KA0Q71t__6CgQ&index=25
public class RottingOranges {
    class Node{
        int x,y,min;
        Node(int x, int y, int min){
            this.x=x;
            this.y=y;
            this.min=min;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int mins = 0;
        int fresh=0;
        Queue<Node> queue = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new Node(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        //BFS
        while(!queue.isEmpty()){
            Node node= queue.poll();
            mins=Math.max(mins,node.min);
            int[] dx=new int[]{-1,1,0,0};
            int[] dy=new int[]{0,0,-1,1};
            for(int i=0;i<4;i++){
                int x2=node.x+dx[i],y2=node.y+dy[i];
                if(x2>=0 && x2<m && y2>=0 && y2<n && grid[x2][y2]==1){
                    grid[x2][y2]=2;
                    fresh--;
                    queue.add(new Node(x2,y2,node.min+1));
                }
            }
        }

        return fresh==0?mins:-1;
    }
}
