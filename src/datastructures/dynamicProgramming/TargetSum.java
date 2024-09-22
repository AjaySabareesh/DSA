package datastructures.dynamicProgramming;

import java.util.HashMap;

//https://leetcode.com/problems/target-sum/solutions/455024/dp-is-easy-5-steps-to-think-through-dp-questions/
//Without memoization, TC would be 2^(T* n) T-target, with memoization, TC - O(T*N) , SC- O(T*N)
//Try tabulation approach later
public class TargetSum {
    class Pair {
        int index;
        int target;

        Pair(int idx, int tar) {
            this.index = idx;
            this.target = tar;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return index == p.index && target == p.target;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + target;
            return result;
        }
    }

    HashMap<Pair, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        int idx = nums.length - 1;
        return ways(idx, target, nums);
    }

    int ways(int index, int sum, int[] nums) {
        if (index < 0 && sum == 0) {
            return 1;
        } else if (index < 0) {
            return 0;
        }
        Pair p = new Pair(index, sum);
        if (map.containsKey(p)) {
            return map.get(p);
        }
        int pos = ways(index - 1, sum + nums[index], nums);
        int neg = ways(index - 1, sum - nums[index], nums);
        map.put(p, pos + neg);
        return map.get(p);
    }
}
