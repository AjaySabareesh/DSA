package datastructures.dynamicProgramming;

public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] res=new int[n+1];
        for(int i=0;i<n+1;i++){
            if(i<=1){
                res[i]=0;
            }else{
                res[i]=Math.min(res[i-1]+cost[i-1], res[i-2]+cost[i-2]);
            }
        }
        return res[n];
    }
}
