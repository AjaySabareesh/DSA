package datastructures.sorting;

import java.util.Arrays;

public class FindTriplets {
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean findTriplets(int arr[] , int n)
    {
        //add code here.(
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            int sum=0;
            while(l<r){
                sum = arr[i]+arr[l]+arr[r];
                if(sum==0){
                    return true;
                }else if(sum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return false;
    }
}
