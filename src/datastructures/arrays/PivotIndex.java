package datastructures.arrays;

//https://leetcode.com/problems/find-pivot-index/description/
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int right=0;
        int left=0;
        for(int i:nums){
            right +=i;
        }
        for(int i=0;i<nums.length;i++){
            right -= nums[i];
            if(right==left){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
