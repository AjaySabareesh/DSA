package datastructures.slidingWindow;

import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/1175088/c-maximum-sliding-window-cheatsheet-template/
public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        int left=0;
        int n=nums.length;
        long sum = 0;
        int maxFreq =0;

        Arrays.sort(nums);

        for(int right = 0; right<nums.length; right++){
            sum += nums[right];

            //invalid
            while ( (long)nums[right] * (right-left+1) > sum + k ) {
                sum -= nums[left];
                left++;
            }
            //valid
            maxFreq = Math.max(maxFreq, right-left+1);
        }

        return maxFreq;
    }
}
