package datastructures.slidingWindow;

import java.util.Stack;

public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;

        Stack<Integer> stack = new Stack<>();
        //Build possible left side of the ramp with max width by monotonous decreasing stack
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty() || nums[i]<nums[stack.peek()]){
                stack.push(i);
            }
        }

        //find the possible right side of ramp with max width
        for(int j=nums.length-1;j>=1;j--){
            while((!stack.isEmpty()) && nums[j]>=nums[stack.peek()]){
                ans = Math.max(ans, j-stack.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxWidthRamp().maxWidthRamp(new int[]{2,2,1}));
    }
}
