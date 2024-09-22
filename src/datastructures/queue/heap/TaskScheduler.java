package datastructures.queue.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/task-scheduler/solutions/104501/java-priorityqueue-solution-similar-problem-rearrange-string-k-distance-apart/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int cycles=0;
        int[] counts = new int[26];
        for(char c:tasks){
            counts[c-'A']++;
        }
        Queue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        for(int i=0;i<26;i++){
            if(counts[i]>0){
                q.add(counts[i]);
            }
        }

        while(!q.isEmpty()){
            int interval = n+1;//1 + cooling time
            List<Integer> tmp = new ArrayList<>();
            while(interval>0 && !q.isEmpty()){
                int cnt = q.poll();//picking most freq element
                cycles++;
                interval--;
                tmp.add(--cnt);
            }
            for(int i:tmp){
                if(i>0){
                    q.add(i);
                }
            }

            //idle if interval > 0 while q is not empty
            cycles += !q.isEmpty() ? interval : 0;
        }

        return cycles;
    }
}


//If we want the task name for ordering as well
//public int leastInterval(char[] tasks, int n) {
//    int cycles=0;
//    int[] counts = new int[26];
//    for(char c:tasks){
//        counts[c-'A']++;
//    }
//    Queue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
//    for(int i=0;i<26;i++){
//        if(counts[i]>0){
//            q.add(new int[]{i+'A' , counts[i]});
//        }
//    }
//
//    while(!q.isEmpty()){
//        int interval = n+1;
//        List<int[]> tmp = new ArrayList<>();
//        while(interval>0 && !q.isEmpty()){
//            int[] cnt = q.poll();
//            cycles++;
//            interval--;
//            cnt[1]--;
//            tmp.add(cnt);
//        }
//        for(int[] i:tmp){
//            if(i[1]>0){
//                q.add(i);
//            }
//        }
//
//        //idle if interval > 0
//        cycles += !q.isEmpty() ? interval : 0;
//    }
//
//    return cycles;
//}