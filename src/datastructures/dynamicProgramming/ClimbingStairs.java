package datastructures.dynamicProgramming;
//TC-O(N), SC-O(1)
public class ClimbingStairs {
    // You are climbing a staircase. It takes n steps to reach the top.
//// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//    The base cases are when we are on the 1st stair (only one way to reach it) and the 2nd stair (two ways to reach it).
//    By summing up the number of ways to reach the (n-1)th and (n-2)th stairs, we can compute the total number of ways to climb the stairs.
    public int climbStairs(int n) {
        //fib(n+1) gives the solution as always (n-1)+(n-2) is the solution
        if (n <= 1) {
            return n;
        }
        int prev2 = 1, prev1 = 1;//Starting with 1, 1 for fib(0) and fib(1) as this is fib(n+1) series
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
//Good DP-problem https://leetcode.com/problems/minimum-cost-for-tickets/
//start from day 0 and pick the min out of the 3 options
//     int solve(idx){

//     if(idx>=size)
//         retunr 0;


//     int op1 = solve(idx+1);

//     idx
//     int temp = idx+1;       // 1 7
//     while(temp < n && arr[temp] < arr[idx] + 7){
//         temp++;
//     }
//     int op2 = solve(temp);


//     int temp = idx+1;       // 1 7
//     while(temp < n && arr[temp] < arr[idx] + 30){
//         temp++;
//     }
//     int op3 = solve(temp);



//     return  Math.min(op1+2, op2+7, op3+15);
// }