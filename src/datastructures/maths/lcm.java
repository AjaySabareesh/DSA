package datastructures.maths;

//https://www.geeksforgeeks.org/lcm-of-given-array-elements/
//TC- O(N log n)
public class lcm {
    Long numGame(Long n) {
        long gcd = 1;
        long lcm = 1;
        for (int i = 2; i <= n; i++) {
            gcd = findGcd(lcm, i);
            lcm = (i * lcm) / gcd;
            lcm = lcm % (long) (Math.pow(10, 9) + 7);
        }
        return lcm;
    }
    //lcm of two numbers is undefined if one of them is zero

    private long findGcd(long a, int b) {
        int rem = (int) a % b;
        while (rem != 0) {
            a = b;
            b = rem;
            rem = (int) a % b;
        }
        return b;
    }
    //Edge case: if a or b is zero, gcd will be the other number
//    if(A==0){
//        return B;
//    }else if(B==0){
//        return A;
//    }

}
