package datastructures.dynamicProgramming;

//https://leetcode.com/problems/coin-change-ii/
public class CoinChangePossibleWays {
    //Top down approach with memoization
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return solve(0, coins, amount, dp);
    }

    int solve(int idx, int[] coins,int target,Integer[][] dp  ){
        if(target==0){
            return 1;
        }
        if(target<0||idx==coins.length){
            return 0;
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        int ans = 0;
        ans += solve(idx, coins, target-coins[idx], dp);//pick
        ans += solve(idx+1, coins, target, dp);//not pick
        return dp[idx][target]=ans;
    }
//    public int change(int amount, int[] coins) {
//        //Using 2-D array approach
//        // int m=coins.length;
//        // int[][] dp= new int[m+1][amount+1];
//        // for(int i=0;i<=m;i++){
//        //     dp[i][0]=1;
//        // }
//        // for(int i=1;i<=m;i++){
//        //     for(int j=0;j<=amount;j++){
//        //         dp[i][j]=coins[i-1]>j?dp[i-1][j]:dp[i-1][j]+dp[i][j-coins[i-1]];
//        //     }
//        // }
//        // return dp[m][amount];
//
//        //Using 1-D array approach
//        int[] dp = new int[amount+1];
//        dp[0]=1;
//        for(int coin:coins){
//            for(int i=1;i<=amount;i++){
//                dp[i] = dp[i] + (i>=coin ? dp[i-coin] : 0 );
//            }
//        }
//        return dp[amount];
//    }
}
