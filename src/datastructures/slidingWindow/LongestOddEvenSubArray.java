package datastructures.slidingWindow;

public class LongestOddEvenSubArray {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n=nums.length;
        int max=0;

        // int left=0, right=0;
        // while(left<=right && right<n){
        //     if(nums[right]>threshold){
        //         left=right+1;
        //         right=right+1;
        //         continue;
        //     }
        //     if(nums[left]%2!=0){
        //         left++;
        //         if(left>right){
        //             right++;
        //         }
        //         continue;
        //     }
        //     if(right-left>=1 && nums[right-1]%2 == nums[right]%2){
        //         left=right;
        //         right=right+1;
        //         continue;
        //     }
        //     max = Math.max(max,right-left+1);
        //     right++;
        // }

        for(int left=0;left<n;left++){
            if(nums[left]<=threshold && nums[left]%2==0){
                int right=left;
                while(right<n && nums[right]<=threshold && (right-left==0 ? true : (nums[right]%2!=nums[right-1]%2))){
                    right++;
                }
                max = Math.max(max,right-left);
            }
        }
        return max;
    }
}
