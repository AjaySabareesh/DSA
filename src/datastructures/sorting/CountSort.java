package datastructures.sorting;

//https://leetcode.com/problems/height-checker/
public class CountSort {
    public int heightChecker(int[] heights) {
        //TC - O (N Log N), SC - O(N)
        // int[] exp = heights.clone();
        // Arrays.sort(exp);
        // int res = 0;
        // for(int i=0;i<exp.length;i++){
        //     if(exp[i]!=heights[i]){
        //         res++;
        //     }
        // }
        // return res;

        //Using count sort
        //TC - O(N), SC - O(1) constant space
        if(heights.length<2){
            return 0;
        }
        int res=0;
        int[] count = new int[101];
        for(int height:heights){
            count[height]++;
        }
        int index=0;
        for(int i=0;i<heights.length;i++){
            while(count[index]==0){
                index++;
            }
            if(heights[i]!=index){
                res++;
            }
            count[index]--;
        }
        return res;
    }
}
