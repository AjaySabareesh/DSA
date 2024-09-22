package datastructures.backTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
//revise palindromic subsequence explanation in above link
//Time Complexity: O(2^n) for generating a number of combinations.
//Auxiliary Space: If ‘k’ is the avg length of every combination and ‘t’ is the no. of combinations then space complexity would be O(k x t)
//Time Complexity: O(2^t * k) where t is the target, k is the average length
//        Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)
//        Why not (2^n) but (2^t) (where n is the size of an array)?
//        Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
public class UniqueCombinationsSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combs(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }

    void combs(int[] c, int st, int sum, ArrayList<Integer> list){
        if(sum==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum<0||st>=c.length){
            return;
        }
        for(int i=st;i<c.length;i++){
//            if(i>st && c[i-1]==c[i]){ //add this if we want to handle duplicates
//                continue;
//            }
            list.add(c[i]);
            combs(c,i,sum-c[i], list);// not i + 1 because we can reuse same elements
                                            //combs(c,st,sum-c[i], list); if we use st instead of i, it will give all permutations of answers with TC - O(n!)
            list.remove(list.size()-1);
        }
    }
}
