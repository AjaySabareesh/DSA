package datastructures.arrays.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
//https://leetcode.com/problems/insert-interval/solutions/1327206/99-16-faster-proper-explaination-c-solution-o-n/
//https://leetcode.com/problems/non-overlapping-intervals/description/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int[] prev=intervals[0];
        int i=1;
        while(i<intervals.length){
            int[] curr=intervals[i++];
            if(prev[1]<curr[0]){
                list.add(prev);
                prev=curr;
            }else{
                prev[0]=Math.min(prev[0], curr[0]);
                prev[1]=Math.max(prev[1], curr[1]);
            }
        }
        list.add(prev);
        int n=list.size();
        int[][] res= new int[n][2];
        for(int j=0;j<n;j++){
            res[j]=list.get(j);
        }
        return res;
    }
}
