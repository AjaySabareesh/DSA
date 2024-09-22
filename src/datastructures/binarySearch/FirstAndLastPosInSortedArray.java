package datastructures.binarySearch;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1, -1};
        }
        int l=0, r=nums.length-1;
        int st=-1, end=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                //ans
                st = mid;
                r=mid-1;//go in the left again
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        l=0; r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                //ans
                end = mid;
                l=mid+1;//go in right again
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return new int[]{st, end};
    }
}
