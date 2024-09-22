package datastructures.dynamicProgramming;

//https://leetcode.com/problems/combination-sum-iv/
public class CombinationSum4PossibleWays {
//Top down with memoization
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp= new Integer[target+1];
        return solve(nums, target, dp);
    }

    //TC- O(T*N), SC - O(T)
    int solve(int[] nums, int target, Integer[] dp){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=null){
            return dp[target];
        }
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans+=solve(nums, target-nums[i], dp);
        }
        return dp[target]=ans;
    }

    //Similar to Coin change possible ways problem but pay attention to the
    //order of the loop - target is in outer loop(x-axis) and numbers are in inner loop(y-axis)
    //If we want to compute all possible order of combinations (permutations- order), use this approach with 1-D array
    //If ordering doesn't matter, use the other approach interchanging the loop order
//    public int combinationSum4(int[] nums, int target) {
//        int[] dp= new int[target+1];
//        dp[0]=1;
//        for(int i=1;i<=target;i++){
//            for(int num:nums){
//                dp[i] += i>=num ? dp[i-num] : 0;
//            }
//        }
//        return dp[target];
//    }
    ///this will work only with distinct +ve numbers
}
