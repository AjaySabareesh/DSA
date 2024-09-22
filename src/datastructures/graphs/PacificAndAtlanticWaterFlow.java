package datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/pacific-atlantic-water-flow/description/
public class PacificAndAtlanticWaterFlow {
    //TC-O(M*N), SC-O(M*N)
    boolean[][] pacific , atlantic;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r=heights.length, c=heights[0].length;
        pacific= new boolean[r][c];
        atlantic= new boolean[r][c];
        for(int i=0;i<r;i++){
            dfs(i,0,pacific,heights, heights[i][0], r, c);
            dfs(i,c-1,atlantic,heights, heights[i][c-1], r, c);
        }
        for(int i=0;i<c;i++){
            dfs(0,i,pacific,heights, heights[0][i],r,c);
            dfs(r-1,i,atlantic,heights, heights[r-1][i], r,c);
        }
        return res;
    }

    void dfs(int x, int y, boolean[][] visited, int[][] heights, int prevHeight, int rows, int cols){
        if(x<0||x>rows-1||y<0||y>cols-1||visited[x][y]||heights[x][y]<prevHeight){
            return;
        }
        visited[x][y]=true;
        if(pacific[x][y]&& atlantic[x][y]){
            res.add(Arrays.asList(x,y));
        }
        int[] dx= {-1,1,0,0};
        int[] dy= {0,0,-1,1};
        for(int i=0;i<4;i++){
            int x1=x+dx[i], y1=y+dy[i];
            dfs(x1,y1,visited,heights,heights[x][y], rows, cols);
        }

    }
}
