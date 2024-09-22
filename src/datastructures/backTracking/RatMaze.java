package datastructures.backTracking;

import java.util.ArrayList;

//DFS with backtracking
//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//Time Complexity: O(3^(m*n)), because on every cell we have to try 3 different directions ( as the src direction will be already visited)
//Auxiliary Space: O(m*n), Maximum Depth of the recursion tree(auxiliary space).
public class RatMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> resPath = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        int srcRow = 0, srcCol = 0;
        traverseMatrix(srcRow,srcCol,n,visited,"",m,resPath);
        return resPath;
    }

    static void traverseMatrix(int currRow, int currCol, int dest, boolean[][] visited, String path,int[][] m,ArrayList<String> resPath) {
        if (currRow < 0 || currRow > dest - 1 || currCol < 0 || currCol > dest - 1) {
            return;
        }
        if (m[currRow][currCol] == 0 || visited[currRow][currCol]) {
            return;
        }
        if (currRow == dest - 1 && currCol == dest - 1) {
            //System.out.println(path);
            resPath.add(path);
            return;
        }
        visited[currRow][currCol] = true;
        traverseMatrix(currRow + 1, currCol, dest, visited, path + "D", m, resPath);
        traverseMatrix(currRow, currCol - 1, dest, visited, path + "L", m, resPath);
        traverseMatrix(currRow, currCol + 1, dest, visited, path + "R", m, resPath);
        traverseMatrix(currRow - 1, currCol, dest, visited, path + "U", m, resPath);
        visited[currRow][currCol] = false;
    }

//we can also reuse input gris for visited
    // static void traverseMatrix(int currRow, int currCol, int dest,  String path,int[][] m,ArrayList<String> resPath) {
    //	 if(currRow<0||currRow>dest-1||currCol<0||currCol>dest-1) {
    //		 return;
    //	 }
    //	 if(m[currRow][currCol]==0) {
    //		 return;
    //	 }
    //	 if(currRow==dest-1 && currCol==dest-1) {
    //		 //System.out.println(path);
    //		 resPath.add(path);
    //		 return;
    //	 }
    //	 m[currRow][currCol]=0;
    //	 traverseMatrix(currRow+1, currCol, dest, path+"D",m,resPath);
    //	 traverseMatrix(currRow, currCol-1, dest, path+"L",m,resPath);
    //	 traverseMatrix(currRow, currCol+1, dest, path+"R",m,resPath);
    //	 traverseMatrix(currRow-1, currCol, dest, path+"U",m,resPath);
    //	 m[currRow][currCol]=1;
    // }
}
