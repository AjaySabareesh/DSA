package datastructures.dynamicProgramming;

public class SubsetSum {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // Arrays.sort(arr);
        boolean[][] res = new boolean[arr.length][sum+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0){
                    res[i][j]=true;
                }
                else if(i==0){
                    res[i][j]= arr[i]==j;
                }else{
                    res[i][j]=res[i-1][j]|| (arr[i]<=j ? res[i-1][j-arr[i]] : false);//Important: res[i-1][j-arr[i]] - this will be res[i][j-arr[i]] when we can have infinite number of same numbers as coin change problem
                }
            }
        }
        return res[arr.length-1][sum];
    }
}
