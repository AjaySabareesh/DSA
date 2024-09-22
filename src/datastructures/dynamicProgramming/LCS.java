package datastructures.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class LCS {
    static int lcs(int x, int y, String s1, String s2)
    {
        int[][] dp = new int[x+1][y+1];
        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){//Imp:here, we shd i-1 and j-1 as we are increasing dp size by +1 , but orig is dp index -1
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }

    //https://www.programiz.com/dsa/longest-common-subsequence
    public static List<Integer> longestCommonSubsequence(List<Integer> s1, List<Integer> s2) {
        int x=s1.size(),y =s2.size();
        int[][] dp = new int[x+1][y+1];
        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++){
                if(s1.get(i-1)==s2.get(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int maxLen = dp[x][y];

        Integer[] lcs = new Integer[maxLen];
        int i= x, j=y;
        int temp = maxLen;
        while(i>0 && j>0){
            if(s1.get(i-1)==s2.get(j-1)){
                lcs[temp-1]=s1.get(i-1);
                i--;
                j--;
                temp--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        List<Integer> res = Arrays.asList(lcs);

        return res;
    }

}
