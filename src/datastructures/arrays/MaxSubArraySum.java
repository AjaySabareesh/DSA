package datastructures.arrays;

//https://leetcode.com/problems/maximum-subarray/
//using DP logic here
public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int prev=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            int sum=(prev<0)?num:prev+num;
            prev=sum;
            max=Math.max(max, sum);
        }
        return max;
    }
}
//Max Product Sub Array
//  long maxProduct(int[] arr, int n) {
//    long max = Long.MIN_VALUE;
//    long product = 1;
//    for(int i=0;i<arr.length;i++) {
//        product *= arr[i];
//        max = Math.max(max, product);
//        if(product==0) {
//            product = 1;
//        }
//    }
//    product = 1;
//    for(int i=arr.length-1;i>=0;i--) {
//        product *= arr[i];
//        max = Math.max(max, product);
//        if(product==0) {
//            product = 1;
//        }
//    }
//    return max;
//}
//
//    //Same approach using single loop
//    long maxProduct1(int[] arr, int n) {
//        long max = Long.MIN_VALUE;
//        long leftProd = 1, rightProd = 1;
//        for(int i=0;i<arr.length;i++) {
//            leftProd *= arr[i];
//            rightProd *= arr[n-1-i];
//            max = Math.max(max, Math.max(leftProd, rightProd));
//
//            if(leftProd==0) {
//                leftProd = 1;
//            }
//            if(rightProd==0) {
//                rightProd = 1;
//            }
//        }
//        return max;
//    }