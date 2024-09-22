package datastructures.dynamicProgramming;

//https://leetcode.com/problems/unique-paths-ii/
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];//we can use 1-D array of size n as well here
        dp[0][0]=1;
        for(int j=1;j<n;j++){
            dp[0][j]=grid[0][j]==1?0:dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            dp[i][0]=grid[i][0]==1?0:dp[i-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]==1?0:(dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
