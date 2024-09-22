package datastructures.arrays;

import java.util.Arrays;

public class closest3Sum {
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        Arrays.sort(A);
        int closeSum=A[0]+A[1]+A[2];
        int sum=0;
        for(int i=0;i<=N-3;i++){
            int l=i+1,r=N-1;
            while(r>l){
                sum = A[i] + A[l]+A[r];
                if(Math.abs(X-closeSum)>Math.abs(X-sum)){
                    closeSum = sum;
                }
                if(sum==X){
                    return sum;
                }else if(sum > X){
                    r--;
                }else{
                    l++;
                }
            }

        }

        return closeSum;

    }
}
