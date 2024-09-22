package datastructures.graphs.interview;

import java.util.ArrayDeque;
import java.util.Queue;
//
//Build electricity network
//
//        Imagine we are an electricity infrastructure company and we build an electricity network in a new country. We want to connect all cities in the country to one electricity network. Country has roads and many farms. Farm owners don't allow us to build on their ground. This means we can only use roads.
//        We can picture the country as a matrix there:
//        - `1` - is a road
//        - `0` - is farm or just place there we can not build
//        - `-1` - is cities that we want to connect
//
//        Input: int[][]
//
//        Output any on you choice:
//        - int[][] with map there to build network
//        - unsorted list of cell coordinates there to build the network
//        - unsorted list of vertexes there to build network
//
//        Example:
//        1 | 1  | 1   | 1  | 1  | -1
//        1 | 0  | 0   | 0  | 0  |  1
//        1 | 0  | -1  | 0  | 0  |  1
//        1 | 0  | 1   | 1  | 1  |  1
//        1 | 0  | 1   | 0  | 0  |  1
//        1 | 1  | 1   |  1 | 1  | -1
//
//        Example builded road:
//        1 | 1  | 1      | 1    | 1    | -1*
//        1 | 0  | 0     | 0    | 0    |  1*
//        1 | 0  | -1*  | 0   | 0     |  1*
//        1 | 0  | 1*    | 1*  | 1*   |  1*
//        1 | 0  | 1      | 0    | 0    |  1*
//        1 | 1   | 1      |  1   | 1    | -1*


//For shortest path in unweighted graph( equal weight in all directions), use simple BFS
//For shortest path in Weighted graph( diff weight in all directions), use  BFS with Dijkstra's algo

//TC- O(M*N)
public class BuildElectricityNetwork {
    class Node{
        int x, y;
        Node prev;
        Node(int x, int y, Node prev){
            this.x=x;
            this.y=y;
            this.prev=prev;//Use prev node to print the path
        }

        public String toString(){
            return "(" + x+","+y+")";
        }
    }
    void shortestPath(int[][] mat){
        int m=mat.length, n=mat[0].length;
        boolean[][] visited = new boolean[m][n];
        outerLoop:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    bfs(mat,i, j, visited);
                    break outerLoop;
                }
            }
        }
    }

    void bfs(int[][] mat, int x, int y, boolean[][] visited){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,null));
        visited[x][y]=true;//For Unweighted graph, we can do simple BFS and visited can be marked here itself
                            //If it is Weighted, then we have to mark visited only while polling out
        while(!q.isEmpty()){
            Node n=q.poll();
            if(mat[n.x][n.y]==-1 && !(n.x ==x && n.y==y)){
                //dest reached
                System.out.println();
                printPath(n);//don't return here as we want to find other destinations with -1 as well
            }
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};
            for(int i=0;i<4;i++){
                int x1=n.x+dx[i];
                int y1=n.y+dy[i];
                if(isValid(x1,y1, mat.length, mat[0].length) && !visited[x1][y1] && mat[x1][y1]!=0){
                    q.add(new Node(x1,y1, n));
                    visited[x1][y1]=true;
                }
            }
        }
    }

    boolean isValid(int x, int y, int m, int n){
        return(x>=0 && x<m && y>=0 && y<n);
    }

    void printPath(Node n){
        if(n!=null){
            printPath(n.prev);
            System.out.print(n +" ");
        }
    }

    public static void main(String[] args) {
        int[][] mat={
                {1, 1, 1, 1, 1, -1},
                {1, 0, 0, 0 ,0, 1},
                {1, 0, -1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, -1}
        };
        new BuildElectricityNetwork().shortestPath(mat);
    }
}
