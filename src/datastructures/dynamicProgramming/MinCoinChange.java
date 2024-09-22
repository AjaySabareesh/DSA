package datastructures.dynamicProgramming;

//Double knapsack problem - another variation of 0/1 knapsack problem
//https://www.geeksforgeeks.org/double-knapsack-dynamic-programming/
public class MinCoinChange {
//Top down approach with memoization
public int change(int amount, int[] coins) {
    Integer[][] dp = new Integer[coins.length][amount+1];
    int ans =solve(0, coins, amount, dp);
    return ans == Integer.MAX_VALUE ? -1:ans;
}


    //top down
    int solve(int idx, int[] coins,int target,Integer[][] dp  ){
        if(target<0){
            return Integer.MAX_VALUE;
        }
        if(target==0){
            return 0;
        }
        if(idx==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        int incl = Integer.MAX_VALUE;
        int temp = solve(idx, coins, target-coins[idx], dp);//pick
        if(temp!=Integer.MAX_VALUE){//use 1+ logic only if resp is not MAX_VALUE
            incl = 1+temp;
        }

        int excl = solve(idx+1, coins, target, dp);//not pick
        return dp[idx][target]=Math.min(incl, excl);
    }
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0){
//            return 0;
//        }
//        int[][] dp= new int[coins.length][amount+1];
//        for(int i=0;i<coins.length;i++){
//            dp[i][0]=0;
//        }
//        for(int i=0;i<coins.length;i++){
//            for(int j=1;j<=amount;j++){
//                if(i==0){
//                    dp[i][j]= j<coins[i]? Integer.MAX_VALUE : 1+dp[i][j-coins[i]];
//                }else{
//                    dp[i][j]= j<coins[i]? dp[i-1][j] : Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
//                }
//            }
//        }
//        return dp[coins.length-1][amount] == Integer.MAX_VALUE ? -1: dp[coins.length-1][amount] ;
//    }

    //1-D approach
//    int[] dp=new int[amount+1];
//    dp[0]=0;
//    for(int i=1;i<=amount;i++){
//        dp[i]=Integer.MAX_VALUE;
//    }
//    for(int coin:coins){
//        for(int i=1;i<=amount;i++){
//            dp[i] = (i<coin)?dp[i]:Math.min(dp[i], dp[i-coin]!=Integer.MAX_VALUE ?1+dp[i-coin]:Integer.MAX_VALUE);
//        }
//    }
//        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount] ;
}
