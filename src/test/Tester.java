package test;

import datastructures.dynamicProgramming.P01_GoldMine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        String s= "a";
        System.out.println("tets" + s.substring(1));
    }

    public static int maxGold(int n, int m, int M[][]) {
        int[][] maxGold = new int[n][m];
        int maxResult = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j == 0) {
                    maxGold[i][j] = M[i][j];
                } else {
                    int upD1 = (i + 1 < n) ? maxGold[i + 1][j - 1] : 0;
                    int left = maxGold[i][j - 1];
                    int downD1 = (i - 1 >= 0) ? maxGold[i - 1][j - 1] : 0;
                    maxGold[i][j] = Math.max(Math.max(upD1, left), downD1) + M[i][j];
                }
                maxResult = Math.max(maxResult, maxGold[i][j]);
            }
        }
        return maxResult;
    }
}
