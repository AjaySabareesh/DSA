package datastructures.dynamicProgramming;
//https://leetcode.com/problems/unique-paths/description/
public class NumberOfUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//
//class Solution {
//    Integer[][] dp;
//    // public int uniquePaths(int m, int n) {
//    //     dp = new Integer[m][n];
//    //     return solve(m-1, n-1, m ,n);
//    // }
//
//    // int solve(int x, int y, int m , int n){
//    //     if(x<0||x>m-1 || y<0 || y>n-1){
//    //         return 0;
//    //     }
//    //     if(x==0 && y==0 ){
//    //         return 1;
//    //     }
//    //     if(dp[x][y]!=null){
//    //         return dp[x][y];
//    //     }
//    //     return dp[x][y] = solve(x,y-1, m, n) + solve(x-1, y, m, n);
//    // }
//
//    //if four directions are allowed, remove dp arr and use vis arr with back tracking
////TC - O(M*N) will chg to 3^(M*N) in 4 direction backtracking
//    public int uniquePaths(int m, int n) {
//        dp = new Integer[m][n];
//        return solve(0, 0, m ,n);
//    }
//
//    int solve(int x, int y, int m , int n){
//        if(x<0||x>m-1 || y<0 || y>n-1){
//            return 0;
//        }
//        if(x==m-1 && y==n-1 ){
//            return 1;
//        }
//        if(dp[x][y]!=null){
//            return dp[x][y];
//        }
//        return dp[x][y] = solve(x,y+1, m, n) + solve(x+1, y, m, n);
//    }
//}