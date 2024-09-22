package datastructures.greedy;

import java.util.PriorityQueue;
//https://leetcode.com/problems/furthest-building-you-can-reach/
public class FarthestBuilding {
    //Greedy , TC - O(N * log (ladders)), SC - O(ladders)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            int diff = heights[i+1]-heights[i];
            if(diff<=0){
                continue;
            }else{
                if(q.size()<ladders){
                    //use ladder
                    q.add(diff);
                }else{
                    //use brick
                    if(!q.isEmpty() && q.peek()<diff){
                        int head = q.poll();
                        q.add(diff);
                        diff=head;
                    }
                    bricks -= diff;
                    if(bricks<0){
                        return i;
                    }
                }
            }
        }
        return n-1;
    }


    //DP - //TC - O(N * bricks * ladders), SC - O(N * bricks * ladders) - too high of memory req
    // public int furthestBuilding(int[] heights, int bricks, int ladders) {
    //     int n=heights.length;
    //     if(n==0){
    //         return -1;
    //     }
    //     Integer[][][] dp = new Integer[n][bricks+1][ladders+1];
    //     return solve(0,heights, bricks, ladders, n, dp);
    // }

    // int solve(int idx,int[] heights, int bricks, int ladders, int n, Integer[][][] dp){
    //     if(bricks<0 || ladders<0){
    //         return idx-1;
    //     }
    //     if(idx==n-1){
    //         return idx;
    //     }
    //     if(dp[idx][bricks][ladders]!=null){
    //         return dp[idx][bricks][ladders];
    //     }
    //     if(heights[idx+1]<=heights[idx]){
    //         return dp[idx][bricks][ladders]=solve(idx+1, heights, bricks, ladders, n, dp);
    //     }else{//move to greater  height
    //         //brick or //ladder
    //         int diff = heights[idx+1]-heights[idx];
    //         int brick = solve(idx+1, heights, bricks-diff, ladders, n, dp);
    //         int ladder = solve(idx+1, heights, bricks, ladders-1, n, dp);
    //         return dp[idx][bricks][ladders]=Math.max(brick, ladder);
    //     }
    // }
}
