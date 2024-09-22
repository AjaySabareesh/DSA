package datastructures.dynamicProgramming;
//https://leetcode.com/problems/jump-game/description/
public class canJump {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(max<i){
                return false;
            }else if(i==n-1){
                return true;
            }else {
                max=Math.max(max, i+nums[i]);
            }
        }
        return false;
    }
}
