package datastructures.dynamicProgramming;

//https://leetcode.com/problems/house-robber-ii/description/
//Since House[1] and House[n] are adjacent, they cannot be robbed together.
// Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers more money. Now the problem has degenerated to the House Robber, which is already been solved.
public class HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int ans1 = rob(nums,0,n-1);
        int ans2 = rob(nums,1,n);
        return Math.max(ans1,ans2);
    }

    int rob(int[] nums, int st, int end){
        int prev2=0, prev1=0;
        for(int i=st;i<end;i++){
            int curr = Math.max(prev1, prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    //Top Down approach
//    public int rob(int[] nums) {
//        int n=nums.length;
//        Integer[] dp = new Integer[n+1];
//        return rob(nums, n, dp);
//    }
//
//    int rob(int[] nums, int n, Integer[] dp){
//        if(n<1){
//            return 0;
//        }
//        if(n==1){
//            return dp[n]=nums[n-1];
//        }
//        if(dp[n]!=null){
//            return dp[n];
//        }
//        return dp[n]= Math.max(rob(nums,n-1, dp), rob(nums,n-2,dp)+nums[n-1]);
//    }
//}

    //DP array approach
//    public int rob(int[] nums) {
//        if(nums.length==1){
//            return nums[0];
//        }
//        int[] dp=new int[nums.length+1];
//        dp[0]=0;
//        dp[1]=nums[0];
//        for(int i=2;i<=nums.length;i++){
//            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
//        }
//        return dp[nums.length];
//    }
}
