package datastructures.backTracking;

//https://leetcode.com/problems/word-search/description/
//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/ - related problem
public class WordSearch {
    //Space Complexity: O(L) L- len of word
    //Time Complexity: O(M * N * 3^L)
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(exist(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean exist(char[][] board, String word, int idx, int x, int y){
        if(idx==word.length()){
            return true;
        }
        int m=board.length, n=board[0].length;
        if(x<0||x>m-1||y<0||y>n-1||board[x][y]!=word.charAt(idx)){
            return false;
        }
        char orig=board[x][y];
        board[x][y]='*';//using to indicate visited nodes
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for(int i=0;i<4;i++){
            if(exist(board,word, idx+1,x+dx[i],y+dy[i])){
                return true;
            }
        }
        board[x][y]=orig;
        return false;

    }
}
