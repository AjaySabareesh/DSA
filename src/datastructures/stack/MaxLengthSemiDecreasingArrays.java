package datastructures.stack;

import java.util.Stack;

//https://leetcode.ca/2023-09-21-2863-Maximum-Length-of-Semi-Decreasing-Subarrays/
public class MaxLengthSemiDecreasingArrays {
    public int maxSubArrayLength(int[] nums) {
        int max =0;
        int n=nums.length;
        //Use monotonous decr stack to build the higher lesser value on right by traversing from end
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>0;i--){
            if(stack.isEmpty() || nums[i]<nums[stack.peek()]){
                stack.push(i);
            }
        }

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                max = Math.max(max, stack.pop()-i+1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{57,55,50,60,61,58,63,59,64,60,63};
        System.out.println(new MaxLengthSemiDecreasingArrays().maxSubArrayLength(nums));
    }

}
