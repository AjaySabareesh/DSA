package datastructures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode.com/problems/minimum-area-rectangle/solutions/900264/intuitive-with-pictures-c-java-explanation/
//TC - O(N^2), SC- O(N)
public class MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        int min=Integer.MAX_VALUE;
        int n=points.length;

        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int x=points[i][0], y=points[i][1];
            HashSet<Integer> set = map.get(x);
            if(set==null){
                set = new HashSet<>();
                map.put(x, set);
            }
            set.add(y);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n && j!=i;j++){
                int x1=points[i][0], y1=points[i][1];//Point A
                int x2=points[j][0], y2=points[j][1];//Point B
                if(x1 != x2 && y1 != y2) {
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                        int area = Math.abs(x1-x2) * Math.abs(y1-y2);
                        min = Math.min(min,area);
                    }
                }
            }
        }

        return min==Integer.MAX_VALUE?0:min;
    }
}
