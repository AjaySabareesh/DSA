package datastructures.dynamicProgramming;

//https://leetcode.com/problems/decode-ways/solutions/30451/evolve-from-recursion-to-dp/
public class DecodeWays {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==1){
            return s.equals("0")?0:1;
        }
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||(s.charAt(i)=='2' &&s.charAt(i+1)<'7'))){
                    dp[i]+=dp[i+2];
                }
            }
        }

        return dp[0];
    }
//
//    public int numDecodings(String s) {
//        int n=s.length();
//        Integer[] mem=new Integer[n];
//        return s.length()==0?0:numDecodings(0,s,mem);
//    }
//    private int numDecodings(int idx, String s, Integer[] mem) {
//        int n=s.length();
//        if(idx==n) return 1;
//        if(s.charAt(idx)=='0') return 0;
//        if(mem[idx]!=null) return mem[idx];
//        int res=numDecodings(idx+1,s,mem);
//        if(idx<n-1&&(s.charAt(idx)=='1'||s.charAt(idx)=='2'&&s.charAt(idx+1)<'7'))
//            res+=numDecodings(idx+2,s,mem);
//        return mem[idx]=res;
//    }
}
