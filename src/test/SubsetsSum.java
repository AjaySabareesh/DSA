package test;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSum {

     List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(new SubsetsSum().returnResult());

    }
    List<List<Integer>> returnResult(){
        int[] nums={5,10,12,15,18};
        int target=30;

        System.out.println(isSubsetSumExists(0, nums, target));

        //Instead of using int and initializing it with -1.
        // we can use wrapper and chk for !=null in cases where 0 can be an answer
        Integer[][] dp = new Integer[nums.length][target+1];
        System.out.println(isSubsetSumExists(0, nums, target, dp));

        findSubsets(0, nums,target, new ArrayList<>());
        return res;
    }

    //this is DP
    //TC-O(2^N)
    boolean isSubsetSumExists(int idx, int[] nums, int target){
        if(target==0){
            return true;
        }
        if(target<0 || idx==nums.length){
            return false;
        }

        return isSubsetSumExists(idx+1,nums, target-nums[idx]) || isSubsetSumExists(idx+1,nums,target);
    }

    //https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    int isSubsetSumExists(int idx, int[] nums, int target, Integer[][] dp){
        if(target==0){
            return 1;
        }
        if(target<0 || idx>=nums.length){
            return 0;
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }

        if(isSubsetSumExists(idx+1,nums, target-nums[idx], dp)==1|| isSubsetSumExists(idx+1,nums,target, dp)==1){
            return dp[idx][target]=1;
        }
        return dp[idx][target]=0;
    }

    //this will be backtracking
     void findSubsets(int idx, int[] nums, int target, List<Integer> list){
         if(target==0){
             res.add(new ArrayList<>(list));
             return;
         }
        if(target<0||idx >=nums.length){
            return;
        }



//        for(int i=idx; i<nums.length;i++){
//            list.add(nums[i]);
//            findSubsets(i + 1, nums, target - nums[i], list);
//            list.remove(list.size()-1);
//        }

         //pick idx element
         list.add(nums[idx]);
         findSubsets(idx + 1, nums, target - nums[idx], list);
         list.remove(list.size()-1);

         //leave idx element
         findSubsets(idx + 1, nums, target, list);
    }

    //2^n
}

//
//
//    int[] set, int target
//
//1,2,3,4,5,-1,-2,0 	4
//
//        5,10,12,15,18	30
//
//
//        18,12
//        5,10,15
//
//        4,1
//        3,2
//        5,-1
//
//        Given: set of integers and target sum for subsets
//        Expected: set of subsets with sum = target
//
//        +ve
//        unique
//
//        subsetSum
//
