package datastructures.graphs;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        Integer[][] dp=new Integer[m][n];
        return solve(m-1, n-1, m, n, dp, grid);
    }

    int solve(int x, int y, int m , int n, Integer[][] dp, int[][] grid){
        if(x<0||x>m-1||y<0||y>n-1){
            return Integer.MAX_VALUE;
        }
        if(x==0&&y==0){
            return grid[0][0];
        }
        if(dp[x][y]!=null){
            return dp[x][y];
        }
        return dp[x][y]=grid[x][y] + Math.min(solve(x, y-1,m,n,dp,grid), solve(x-1,y,m,n,dp,grid));
    }

    //1-D tabulation approach
    // int[] dp = new int[n];
    // dp[0]=grid[0][0];
    // for(int j=1;j<n;j++){
    //     dp[j] = dp[j-1]+grid[0][j];
    // }
    // for(int i=1;i<m;i++){
    //     for(int j=0;j<n;j++){
    //         dp[j]= (j==0 ? dp[j]: Math.min(dp[j-1], dp[j])) + grid[i][j];
    //     }
    // }
    // return dp[n-1];

    //2-D tabulation approach
    // int[][] dp=new int[m][n];
    // dp[0][0]=grid[0][0];
    // for(int j=1;j<n;j++){
    //     dp[0][j]=dp[0][j-1]+grid[0][j];
    // }
    // for(int i=1;i<m;i++){
    //     dp[i][0]=dp[i-1][0]+grid[i][0];
    // }
    // for(int i=1;i<m;i++){
    //     for(int j=1;j<n;j++){
    //         dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
    //     }
    // }
    // return dp[m-1][n-1];
}
