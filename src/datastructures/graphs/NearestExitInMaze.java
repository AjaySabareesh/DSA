package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.Queue;
//TC-O(M*N), SC-O(M*N)
//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
public class NearestExitInMaze {
    class Node{
        int x,y, moves;
        Node(int x, int y, int moves){
            this.x=x;
            this.y=y;
            this.moves=moves;
        }
    }
    //BFS
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows=maze.length;
        int cols=maze[0].length;
        Queue<Node> queue= new ArrayDeque<>();
        queue.add(new Node(entrance[0],entrance[1],0));
        while(!queue.isEmpty()){
            Node n=queue.poll();
            if(maze[n.x][n.y]=='+'){
                continue;
            }
            if((n.x==0||n.x==rows-1||n.y==0||n.y==cols-1)&&!(n.x==entrance[0]&&n.y==entrance[1])){
                return n.moves;
            }
            maze[n.x][n.y]='+';
            for(int i=-1;i<=1;i=i+2){
                addValidNode(n.x+i,n.y,rows,cols,n.moves+1,queue, maze);
                addValidNode(n.x,n.y+i,rows,cols,n.moves+1,queue, maze);
            }
        }
        return -1;
    }

    void addValidNode(int x, int y, int rows, int cols,int moves, Queue<Node> queue,char[][] maze){
        if(x<0||x>rows-1||y<0||y>cols-1||maze[x][y]=='+'){
            return;
        }
        queue.add(new Node(x,y,moves));
    }

    //Checking node validity from queue - both approaches are fine
//        public int nearestExit(char[][] maze, int[] entrance) {
//            int rows=maze.length;
//            int cols=maze[0].length;
//            Queue<Node> queue= new ArrayDeque<>();
//            queue.add(new Node(entrance[0],entrance[1],0));
//            while(!queue.isEmpty()){
//                Node n=queue.poll();
//                if(n.row<0||n.row>rows-1||n.col<0||n.col>cols-1||maze[n.row][n.col]=='+'){
//                    continue;
//                }
//                if((n.row==0||n.row==rows-1||n.col==0||n.col==cols-1)&&!(n.row==entrance[0]&&n.col==entrance[1])){
//                    return n.moves;
//                }
//                maze[n.row][n.col]='+';
//                for(int i=-1;i<=1;i=i+2){
//                    queue.add(new Node(n.row+i,n.col,n.moves+1));
//                    queue.add(new Node(n.row,n.col+i,n.moves+1));
//                }
//            }
//            return -1;
//        }

}
