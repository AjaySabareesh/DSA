package datastructures.dynamicProgramming;

import java.util.List;

//https://leetcode.com/problems/word-break/editorial/
public class WordBreak {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length()+1];
//        dp[0]=true;
//
//        for(int i=1;i<=s.length();i++){
//            for(String word:wordDict){
//                if(i>=word.length() && dp[i-word.length()]){
//                    if(s.substring(i-word.length(), i).equals(word)){
//                        dp[i]=true;
//                    }
//                }
//            }
//        }
//        return dp[s.length()];
//    }

    //Top down recursive approach
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[0] = true;
        return solve(s.length(), wordDict, s, dp);
    }


//TC - O(2^N), we can't memoize this solution
//   HashSet<String> set = new HashSet<>(wordDict);
//         return solve(0, s, set, "");
    // boolean solve(int idx, String s,HashSet<String> set, String res){
    //     if(idx==s.length()){
    //         return res.isEmpty();
    //     }
    //     res += s.charAt(idx);
    //     boolean ans = false;
    //     if(set.contains(res)){
    //         ans = ans || solve(idx+1, s, set, "");//dict check
    //     }
    //     ans = ans || solve(idx+1, s, set, res);//no dict check
    //     return ans;
    // }

//    Time complexity: O(n⋅m⋅k)
//    There are n states of dp(i). Because of memoization, we only calculate each state once.
//    To calculate a state, we iterate over m words, and for each word perform some substring operations which costs O(k).
//    Therefore, calculating a state costs O(m*K)
    boolean solve(int size, List<String> dict, String s, Boolean[] dp) {
        if (size == 0) {
            return true;
        }
        if (dp[size] != null) {
            return dp[size];
        }
        for (String word : dict) {
            int len = word.length();
            if (size >= len) {
                if (s.substring(size - len, size).equals(word) && solve(size - len, dict, s, dp)) {
                    return dp[size] = true;
                }
            }
        }
        return dp[size] = false;
    }

}