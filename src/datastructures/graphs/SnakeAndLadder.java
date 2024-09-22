package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;


//https://www.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
//BFS - directed unweighted graph
public class SnakeAndLadder {
    static int minThrow(int N, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        while(i<arr.length-1){
            map.put(arr[i], arr[i+1]);
            i += 2;
        }
        boolean visited[] = new boolean[31];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1]=true;
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int cell = q.poll();
                if(cell==30){
                    return moves;
                }
                for(int j=1;j<=6;j++){
                    int newCell = cell+j;
                    if(map.containsKey(newCell)){
                        newCell = map.get(newCell);
                    }
                    if(newCell<=30 && !visited[newCell]){
                        q.add(newCell);
                        visited[newCell]=true;
                    }
                }
                size--;
            }
            moves++;
        }
        return 0;

    }
}
