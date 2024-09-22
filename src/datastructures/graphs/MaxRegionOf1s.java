package datastructures.graphs;

//Time complexity: O(ROW * COL). In the worst case, all the cells will be visited so the time complexity is O(ROW * COL).
//Auxiliary Space: O(ROW * COL). To store the visited nodes O(ROW * COL) space is needed. since input mat is reused, it will O(1)

//https://leetcode.com/problems/shortest-bridge/solutions/189321/java-dfs-find-the-island-bfs-expand-the-island/
//In this above link prob, use DFS to find one island. Then apply BFS to join with next island
public class MaxRegionOf1s {
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int max = 0;
        int rows = grid.length, cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    int area = findArea(i, j, rows, cols, grid);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    //DFS
    int findArea(int i, int j, int rows, int cols, int[][] grid){
        if(i<0 ||j<0 ||i>=rows || j >=cols || grid[i][j]==0){
            return 0;
        }
        int area =1;
        grid[i][j]=0;
        for(int a=i-1;a<=i+1;a++){
            for(int b=j-1;b<=j+1;b++){
                area +=findArea(a,b, rows, cols, grid);
            }
        }
        return area;
    }
}


