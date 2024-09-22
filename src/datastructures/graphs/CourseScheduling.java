package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//Topological sorting using Kahn's algorithm - A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
//https://leetcode.com/problems/course-schedule-ii/
//BFS
public class CourseScheduling {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[] arr:prerequisites){
            int a=arr[1];
            int b=arr[0];
            adjList[a].add(b);
            inDegree[b]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node=queue.poll();
            res.add(node);
            for(int i:adjList[node]){
                if(--inDegree[i]==0){
                    queue.add(i);
                }
            }
        }
        if(res.size()!=numCourses){//to check whether the graph is DAG. If DAG , count will be equal to V
            return new int[0];
        }else{
            int[] op = new int[res.size()];
            for(int i=0;i<res.size();i++){
                op[i]=res.get(i);
            }
            return op;
        }
    }
}
