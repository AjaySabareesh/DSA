package datastructures.binarySearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/14425/concise-o-log-n-binary-search-solution/
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/48493/compact-and-clean-c-solution/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        // find the index of the smallest value(1st element) using binary search.
        while(left<right){
            if(nums[left]<nums[right]){//this is optional
                break;
            }
            int mid=(left+right)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        int st=left;
        int n=nums.length;
        left=0;
        right=n-1;
        if(target>=nums[st]&&target<=nums[right]){
            left=st;
        }else{
            right=st;
        }
        while(left<=right){
            int mid=(left+right)/2;//braces are critical here
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
//        if(nums==null || nums.length==0) return -1;
//        int l=0, r=nums.length-1, m=0;
//        // find out the index of the smallest element.
//        while(l<r){
//            m = (l+r)/2;
//            if(nums[m] > nums[r]){
//                l = m+1;
//            }else{
//                r = m;
//            }
//        }
//
//        // since we now know the start, find out if the target is to left or right of start in the array.
//        int s = l;
//        l = 0; r = nums.length-1;
//        if(target >= nums[s] && target <= nums[r]){
//            l = s;
//        }else{
//            r = s;
//        }
//        // the regular search.
//        while(l<=r){
//            m = (l+r)/2;
//            if(nums[m]==target) return m;
//            else if(nums[m] > target) r = m-1;
//            else l=m+1;
//        }
//
//        return -1;
    }
}
