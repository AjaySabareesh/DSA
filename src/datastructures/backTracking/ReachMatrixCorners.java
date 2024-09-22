package datastructures.backTracking;

import java.util.ArrayList;
import java.util.List;

//DFS backtracking with multiple destinations

//Time Complexity: O(3^(m*n)), because on every cell we have to try 3 different directions.
//Auxiliary Space: O(m*n), Maximum Depth of the recursion tree(auxiliary space).
public class ReachMatrixCorners {
    List<String> res = new ArrayList<>();

    List<String> solve(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        dfs(x, y, matrix, m, n, "");
        return res;
    }

    void dfs(int x, int y, int[][] matrix, int m, int n, String path) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || matrix[x][y] == 0) {
            return;
        }
        if ((x == 0 && y == 0) || (x == 0 && y == n - 1) || (x == m-1 && y == 0) || (x == m-1 && y == n-1)) {
            res.add(path);
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] dir = {'U', 'D', 'L', 'R'};

        matrix[x][y] = 0;//to mark as visited;
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i], y1 = y + dy[i];
            dfs(x1, y1, matrix, m, n, path + dir[i]);
        }
        matrix[x][y] = 1;//backtrack
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 0, 0, 1, 0, 0, 1, 1},
                        {1, 1, 1, 0, 0, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 1, 0, 0, 1},
                        {0, 1, 1, 1, 1, 0, 0, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 0, 1}
                };
        System.out.println(new ReachMatrixCorners().solve(matrix, 4, 2));
    }
}
