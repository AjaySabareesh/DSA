package datastructures.backTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens-ii/solutions/2114337/Java-oror-Two-approaches-with-detailed-explanation/
//Time Complexity: O(N!)
//Time Complexity : O(N!), we have N choices in the first row, N-1 in the second row, N-2 in the next and so on... which brings overall time complexity to O(N!)
public class NQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        dfs(board,0,n);
        return res;
    }

    void dfs(boolean[][] board, int r,int n){
        if(r==n){
            getResult(board);
            return;
        }

        for(int c=0;c<n;c++){
            if(isValid(r,c,board) && !board[r][c]){
                board[r][c]=true;
                dfs(board, r+1, n);
                board[r][c]=false;
            }
        }
    }

    boolean isValid(int r, int c, boolean[][] board){
        int n=board.length;
        for(int i=r;i>=0;i--){
            if(board[i][c]){
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

    void getResult(boolean[][] board){
        List<String> list = new ArrayList<>();
        for(boolean[] row:board){
            String s="";
            for(boolean val:row){
                s += val?"Q":".";
            }
            list.add(s);
        }
        res.add(list);
    }
}

//Approach 2: to check IsValid cell using 3 arrays
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
//class Solution {
//    List<List<String>> res = new ArrayList<>();
//    boolean[] columns, ld, rd;
//    public List<List<String>> solveNQueens(int n) {
//        boolean[][] board=new boolean[n][n];
//        columns = new boolean[n];
//        ld = new boolean[2*n-1];
//        rd = new boolean[2*n-1];
//        dfs(board,0,n);
//        return res;
//    }
//
//    void dfs(boolean[][] board, int r,int n){
//        if(r==n){
//            getResult(board);
//            return;
//        }
//
//        for(int c=0;c<n;c++){
//            if(isValid(r,c, n) && !board[r][c]){
//                board[r][c]=true;
//                columns[c]=true;
//                ld[r-c+n-1]=true; //add(n-1) here to avoid negative values
//                rd[r+c]=true;
//                dfs(board, r+1, n);
//                board[r][c]=false;
//                columns[c]=false;
//                ld[r-c+n-1]=false;
//                rd[r+c]=false;
//            }
//        }
//    }
//
//    boolean isValid(int r, int c, int n){
//        if(columns[c]||ld[r-c+n-1]||rd[r+c]){
//            return false;
//        }
//        return true;
//    }
//
//    void getResult(boolean[][] board){
//        List<String> list = new ArrayList<>();
//        for(boolean[] row:board){
//            String s="";
//            for(boolean val:row){
//                s += val?"Q":".";
//            }
//            list.add(s);
//        }
//        res.add(list);
//    }
//}