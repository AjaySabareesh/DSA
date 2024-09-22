package datastructures.binary;

//https://leetcode.com/problems/reverse-bits/solutions/54738/sharing-my-2ms-java-solution-with-explanation/
public class ReverseBits {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res = res<<1;//shifting previous ans by 1 digit left
            if((n&1)==1){//if orig number has 1 at last, reverse should have 1 at front //Imp- use braces for binary operations eg:(n&1)
                res = res|1; //res++ this also will work
            }
            n = n>>1;
        }
        return res;
    }
}

//https://leetcode.com/problems/number-of-1-bits/
//Counting 1's //https://leetcode.com/problems/number-of-1-bits/solutions/55099/simple-java-solution-bit-shifting/
//class Solution {
//    public int hammingWeight(int n) {
//        int ans=0;
//        while(n!=0){
//            if((n&1) ==1){
//                ans++;
//            }
//            n=n>>1;
//        }
//        return ans;
//    }
//}