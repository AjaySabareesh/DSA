package datastructures.binary;

//https://leetcode.com/problems/sum-of-two-integers/solutions/132479/simple-explanation-on-how-to-arrive-at-the-solution/
public class Sum {
    public int getSum(int a, int b) {
        int carry;
        while(b!=0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
