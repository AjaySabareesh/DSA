package datastructures.backTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
//https://leetcode.com/problems/permutations/solutions/3851232/beats-98-with-similar-problems-time-complexity-analysis/
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        sol(nums,new ArrayList<>());
        return res;
    }

    void sol(int[] nums, ArrayList<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            sol(nums , list);
            list.remove(list.size()-1);
        }
    }
}
