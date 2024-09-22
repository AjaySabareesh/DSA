package datastructures.graphs;

//Time complexity: O(n*m).
//Auxiliary Space: O(n*m). O(ROW * COL), as to do DFS we need extra auxiliary stack space.
public class NumberOfIslands {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count =0 ;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    isIsland(visited, i, j, rows, cols, grid);
                    count++;
                }
            }
        }
        return count;
    }
    //Using DFS
    void isIsland(boolean[][] visited, int i, int j, int rows, int cols,char[][] grid){
        if(i<0||j<0||i>=rows||j>=cols||visited[i][j]||grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        isIsland(visited, i-1,j,rows, cols, grid);
        isIsland(visited, i+1,j,rows, cols, grid);
        isIsland(visited, i,j-1,rows, cols, grid);
        isIsland(visited, i,j+1,rows, cols, grid);

        isIsland(visited, i-1,j-1,rows, cols, grid);
        isIsland(visited, i-1,j+1,rows, cols, grid);
        isIsland(visited, i+1,j-1,rows, cols, grid);
        isIsland(visited, i+1,j+1,rows, cols, grid);
    }

    //approach 2 - w.o using separate visited matrix
    private void checkIsland(char[][] inputMatrix, int i, int j, int rows, int cols) {
        if(i<0||j<0||i>=rows||j>=cols||inputMatrix[i][j]=='0') {
            return;//edges
        }
        inputMatrix[i][j]='0';//Making 1 to 0
        checkIsland(inputMatrix, i, j-1,rows,cols);
        checkIsland(inputMatrix, i, j+1,rows,cols);
        checkIsland(inputMatrix, i-1, j,rows,cols);
        checkIsland(inputMatrix, i+1, j,rows,cols);

        checkIsland(inputMatrix, i-1, j-1,rows,cols);
        checkIsland(inputMatrix, i-1, j+1,rows,cols);
        checkIsland(inputMatrix, i+1, j-1,rows,cols);
        checkIsland(inputMatrix, i+1, j+1,rows,cols);

    }
}
