package datastructures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//The main optimization lies in the fact that smallest element have higher chance of contributing in LIS.
//https://www.geeksforgeeks.org/collections-binarysearch-java-examples/
//https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
public class LIS {
    public int lengthOfLIS(int[] nums) {
        //TC-O(N Log N)- we are using patient sort
        //Patience sort will give len of LIS, but if we want the actual LIS - then use tabulation and build the matrix (O(N^2))
        //Then go from right to left picking the element at LIS length, then decreasing the len by 1, picking the elem of that elem
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                int insPos = Collections.binarySearch(list, num);
                if (insPos < 0) {//if the element is not present, binarySearch will give -insertion position Index -1
                    if (-insPos > list.size()) {
                        list.add(num);
                    } else {
                        list.set(-insPos - 1, num);
                    }
                }
            }

        }
        return list.size();

        //TC - O(N^2), SC - O(N)
        //Top down with memoization
//        int maxLength(String S){
//            int n=S.length();
//            if(n<=1){
//                return n;
//            }
//            int max=0;
//            Integer[] dp=new Integer[n];
//
//            for(int i=n-1;i>=0;i--){
//                max = Math.max(max,solve(i, S, dp));
//            }
//            return max;
//        }
//
//
//        //longest subsequence ending at index idx
//        int solve(int idx, String S, Integer[] dp){
//            if(idx==0){
//                return 1;
//            }
//            if(dp[idx]!=null){
//                return dp[idx];
//            }
//            int curr = S.charAt(idx);
//            int len=1;
//            for(int j=idx-1;j>=0;j--){
//                int prev = S.charAt(j);
//                if(curr>prev){
//                    len = Math.max(len, 1+solve(j, S,dp));
//                }
//            }
//
//            return dp[idx]=len;
//        }

        //TC - O(N^2), SC - O(N^2)
        //Top down with memoization
//        int maxLength(String S){
//            int n=S.length();
//            if(n<=1){
//                return n;
//            }
//            Integer[][] dp=new Integer[n+1][n+1];
//            return solve(0, -1, S, n, dp);
//        }
//
//        int solve(int idx, int prev, String S,int n, Integer[][] dp){
//            if(idx==n){
//                return 0;
//            }
//            if(dp[idx][prev+1]!=null)
//                return dp[idx][prev+1];
//
//            int excl = solve(idx+1, prev, S, n, dp);
//            int incl = Integer.MIN_VALUE;
//            if(prev==-1 || S.charAt(idx)>S.charAt(prev))
//                incl = 1 + solve(idx+1, idx, S, n, dp);
//
//            return dp[idx][prev+1] = Math.max(incl, excl);
//        }
//
//        Collections.binarySearch(list, num) method - internal cde

//        int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
//            int low = 0;
//            int high = list.size()-1;
//
//            while (low <= high) {
//                int mid = (low + high) >>> 1;
//                Comparable<? super T> midVal = list.get(mid);
//                int cmp = midVal.compareTo(key);
//
//                if (cmp < 0)
//                    low = mid + 1;
//                else if (cmp > 0)
//                    high = mid - 1;
//                else
//                    return mid; // key found
//            }
//            return -(low + 1);  // key not found
//        }
//DP Approach TC - O(N^2)
//        int n=nums.length;
//        if(n==1){
//            return 1;
//        }
//        int[] dp = new int[n];
//        for(int i=0;i<n;i++){
//            dp[i]=1;
//        }
//        int max =1;
//        for(int i=1;i<n;i++){
//            for(int j=0;j<i;j++){
//                if(nums[i]>nums[j]&&dp[i]<1+dp[j]){
//                    dp[i]=1+dp[j];
//                    max=Math.max(max,dp[i]);
//                }
//            }
//        }
//        return max;
    }

//    https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
}


