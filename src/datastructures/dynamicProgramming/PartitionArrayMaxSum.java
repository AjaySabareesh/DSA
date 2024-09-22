package datastructures.dynamicProgramming;

//https://leetcode.com/problems/partition-array-for-maximum-sum/description/
public class PartitionArrayMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(k==0 || arr.length==0){
            return 0;
        }
        Integer[] dp = new Integer[arr.length];
        return solve(0, arr, k, dp);
    }

    //TC - O(N*K) , SC - O(N)
    int solve(int idx, int[] arr, int k, Integer[] dp){
        int n = arr.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        int max = 0;
        int maxResult = 0;
        for(int i=idx;i<idx+k && i<n;i++){
            max = Math.max(max, arr[i]);
            maxResult = Math.max(maxResult,(max * (i-idx+1)) + solve(i+1,arr, k, dp));
        }
        return dp[idx]=maxResult;
    }
}
