package datastructures.backTracking;

//https://leetcode.com/problems/unique-paths-iii/solutions/1553805/c-simple-and-clean-dfs-solution-explained-0ms-faster-than-100/
public class UniquePaths3 {
    int empty=0;
    public int uniquePathsIII(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visited= new boolean[m][n];
        int srcX=0,srcY=0,desX=0,desY=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    srcX=i;
                    srcY=j;
                    empty++;
                }else if(grid[i][j]==2){
                    desX=i;
                    desY=j;
                }else if(grid[i][j]==0){
                    empty++;
                }
            }
        }
        return findPaths(srcX,srcY,desX,desY,visited,grid, m, n,0);
    }

    int findPaths(int x,int y, int desX,int desY, boolean[][] visited, int[][] grid, int m, int n, int count){
        if(x<0||x>m-1||y<0||y>n-1||visited[x][y]||grid[x][y]==-1){
            return 0;
        }
        if(x==desX &&y==desY ){
            return count==empty ?1:0;
        }
        int res=0;
        visited[x][y]=true;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for(int i=0;i<4;i++){
            res += findPaths(x+dx[i],y+dy[i], desX, desY, visited, grid, m, n, count+1);
        }
        visited[x][y]=false;
        return res;
    }
}

//https://leetcode.com/problems/unique-paths/description/
//Unique Path - I : only down and right movements
//Integer[][] dp;
    // public int uniquePaths(int m, int n) {
    //     dp = new Integer[m][n];
    //     return solve(m-1, n-1, m ,n);
    // }

    // int solve(int x, int y, int m , int n){
    //     if(x<0||x>m-1 || y<0 || y>n-1){
    //         return 0;
    //     }
    //     if(x==0 && y==0 ){
    //         return 1;
    //     }
    //     if(dp[x][y]!=null){
    //         return dp[x][y];
    //     }
    //     return dp[x][y] = solve(x,y-1, m, n) + solve(x-1, y, m, n);
    // }

    //if four directions are allowed, remove dp arr and use vis arr with back tracking
//TC - O(M*N) will chg to 3^(M*N) in 4 direction backtracking
//    public int uniquePaths(int m, int n) {
//        dp = new Integer[m][n];
//        return solve(0, 0, m ,n);
//    }
//
//    int solve(int x, int y, int m , int n){
//        if(x<0||x>m-1 || y<0 || y>n-1){
//            return 0;
//        }
//        if(x==m-1 && y==n-1 ){
//            return 1;
//        }
//        if(dp[x][y]!=null){
//            return dp[x][y];
//        }
//        return dp[x][y] = solve(x,y+1, m, n) + solve(x+1, y, m, n);
//    }