package datastructures.dynamicProgramming;

//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
public class P01_GoldMine {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of cases:");
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            System.out.println("Enter matrix size values");
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for (int i = 0; i < n * m; i++) {
                M[i / m][i % m] = Integer.parseInt(inline1[i]);
            }

            P01_GoldMine ob = new P01_GoldMine();
            System.out.println(ob.maxGold(n, m, M));
        }
    }

    int res = 0;
    int maxGold(int m, int n, int M[][])
    {
        Integer[][] max =  new Integer[m][n];
        for(int i=0;i<m;i++){
            int val = solve(i,0,M,max, m , n);
            res = Math.max(res,val);
        }
        return res;
    }

    int solve(int x, int y, int[][] ip, Integer[][] max, int m, int n){
        if(x<0 || x>=m || y<0 || y>=n){
            return 0;
        }
        if(max[x][y]!=null){
            return max[x][y];
        }
        int up = solve(x-1,y+1, ip, max, m, n);
        int right = solve(x,y+1, ip, max, m, n);
        int down = solve(x+1,y+1, ip, max, m, n);

        return max[x][y] = ip[x][y]
                + Math.max(up, Math.max(right, down));
    }

    //Bottom-Up approach
//
//    public int maxGold(int n, int m, int M[][]) {
//        int[][] maxGold = new int[n][m];
//        int maxResult = 0;
//        for (int j = 0; j < m; j++) {
//            for (int i = 0; i < n; i++) {
//                if (j == 0) {
//                    maxGold[i][j] = M[i][j];
//                } else {
//                    int upD1 = (i + 1 < n) ? maxGold[i + 1][j - 1] : 0;
//                    int left = maxGold[i][j - 1];
//                    int downD1 = (i - 1 >= 0) ? maxGold[i - 1][j - 1] : 0;
//                    maxGold[i][j] = Math.max(Math.max(upD1, left), downD1) + M[i][j];
//                }
//                maxResult = Math.max(maxResult, maxGold[i][j]);
//            }
//        }
//        return maxResult;
//    }
}
