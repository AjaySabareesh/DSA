package datastructures.linkedList;

//TC- O(N), SC-O(1)
//https://www.youtube.com/watch?v=wjYnzkAhcNk
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow=0, fast=0;
        while(true){ //find the intersection point
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }

        //find the entry point of the loop by using the floyd's cycle detection principle
        //distance from start to loop entry pt = distance from intersection pt to loop entry pt'

        int slow2=0;
        while(slow!=slow2){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        return slow;
    }


//https://leetcode.com/problems/find-the-duplicate-number/solutions/1892872/c-6-approaches-interview-question/
    //another approach - using pointers
//        for(int i=0;i<nums.length;i++){
//        int idx = Math.abs(nums[i]);
//        if(nums[idx]<0){
//            return idx;
//        }
//        nums[idx]=-nums[idx];
//    }
//        return -1;
//}
}
