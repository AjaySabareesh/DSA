package datastructures.graphs.interview;

import java.util.PriorityQueue;
//https://levelup.gitconnected.com/dijkstras-shortest-path-algorithm-in-a-grid-eb505eb3a290
////For shortest path in Weighted graph( diff weight in all directions), use  BFS with Dijkstra's algo

//TC-O(M*N) log(M*N)
public class ShortestPathInWeightedMatrix {
    public static void main(String[] args) {
        int[][] mat={
                {0, 5, 11, 13, 16, 5, 4, 19, 10, 18},
                {16, 1, 6, 17 ,2,  7, 1, 15, 16, 4},
                {4, 8, 11, 7, 11, 8,  4, 16, 11, 1},
                {1, 13, 3, 17, 11, 9, 14, 8 , 3,  5},
                {3, 16, 11, 13, 1, 3, 12, 14, 12, 13},
                {1, 1,  5,  16, 7, 6, 15, 15, 14, 3},
                {12,  18, 4, 15, 16, 8, 16, 17, 4, 1},
                {12, 5, 15, 10, 9, 19, 18, 7, 4, 7},
                {17, 3, 14, 16, 5, 14, 3, 19, 4, 19},
                {2, 11, 18, 10, 19, 2, 19, 13, 19, 0}
        };
//        int[][] mat={
//                {0, 5, 11, 13, 16, 5, 4, 19, 10, 18},
//                {16, 1, 6, 17 ,2,  7, 1, 15, 16, 4},
//                {4, 8, 11, 7, 11, 8,  4, 16, 11, 1},
//                {1, 13, 3, 17, 11, 9, 14, 8 , 3,  5},
//                {1, 16, 11, 13, 1, 3, 12, 14, 12, 13},
//                {1, 1,  5,  16, 7, 6, 15, 15, 14, 3},
//                {1,  18, 4, 15, 16, 8, 16, 17, 4, 1},
//                {1, 5, 15, 10, 9, 19, 18, 7, 4, 7},
//                {1, 3, 14, 16, 5, 14, 3, 19, 4, 19},
//                {2, 1, 1, 1, 19, 2, 1, 1, 1, 0}
//        };
        new ShortestPathInWeightedMatrix().shortestPath(mat);
    }

    void shortestPath(int[][] mat){
        int m=mat.length, n=mat[0].length;
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        bfs(0,0,m-1, n-1, mat, m, n, dist);
    }

    void bfs(int sX, int sY,int desX,int desY,int[][] mat, int m, int n, int[][] dist){
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Node> q= new PriorityQueue<>((a,b) -> a.dist - b.dist);
        q.add(new Node(sX, sY, null, 0));

        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.x==desX && node.y==desY){
                System.out.println("Distance "+node.dist);
                printPath(node);
                return;
            }
            if(visited[node.x][node.y]){
                continue;
            }
            visited[node.x][node.y]=true;
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};
            for(int i=0;i<4;i++){
                int x1=node.x+dx[i], y1=node.y+dy[i];
                if(isValid(x1,y1,m,n) && !visited[x1][y1] && ( dist[node.x][node.y]+mat[x1][y1]) < dist[x1][y1]){
                    dist[x1][y1]=dist[node.x][node.y]+mat[x1][y1];
                    q.add(new Node(x1,y1,node, dist[x1][y1]));
                }
            }

        }
    }

    boolean isValid(int x, int y, int m, int n){
        return x>=0 && x<m && y>=0 && y<n;
    }

    void printPath(Node n){
        if(n!=null){
            printPath(n.prev);
            System.out.print(n);
        }
    }

    class Node{
        int x, y;
        Node prev;
        int dist;

        Node(int x, int y, Node prev, int dist){
            this.x=x;
            this.y=y;
            this.prev=prev;
            this.dist=dist;
        }

        public String toString(){
            return "("+this.x+","+this.y+") ";
        }
    }
}
