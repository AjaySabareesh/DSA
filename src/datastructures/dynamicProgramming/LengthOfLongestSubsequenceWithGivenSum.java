package datastructures.dynamicProgramming;

import java.util.List;

//https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/solutions/4218724/take-not-take-using-recursion-memorisation-explained/
public class LengthOfLongestSubsequenceWithGivenSum {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer[][] dp = new Integer[nums.size()][target+1];
        int ans = solve(nums, target, 0, dp);
        return ans<0?-1:ans;//Imp: use ans<0 check to return -1 for invalid cases
    }

    int solve(List<Integer> nums, int target, int idx, Integer[][] dp){
        if(target==0){
            return 0;
        }
        if(target<0||idx==nums.size()){
            return Integer.MIN_VALUE;// if target is less then 0 or i is greater than nums size then its invalid case and just return with very small number
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        int incl = 1+solve(nums, target-nums.get(idx), idx+1, dp);
        int excl = solve(nums, target, idx+1, dp);

        return dp[idx][target]= Math.max(incl,excl);
    }
}

// public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//         Integer[][] dp = new Integer[nums.size()][target+1];
//          return solve(nums, target, 0, 0);
//     }

//     int solve(List<Integer> nums, int target, int idx, int size){
//         int max=-1;
//         if(target==0){
//             max = Math.max(max, size);
//             return size;
//         }
//         if(target<0||idx==nums.size()){
//             return -1;
//         }
//          int incl = solve(nums, target-nums.get(idx), idx+1, size+1);
//           int excl = solve(nums, target, idx+1, size);
//         return  max = Math.max(incl,excl);
//     }

