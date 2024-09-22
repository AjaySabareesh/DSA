package datastructures.queue.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/single-threaded-cpu/
public class SingleThreadedCPU {
    //TC - O (N log N) , SC - O(N) , N- no of tasks
    public int[] getOrder(int[][] tasks) {

        PriorityQueue<int[]> taskQ = new PriorityQueue<>((a, b)->a[1]-b[1]);//heap by enqueue time
        int[][] processes = new int[tasks.length][3];
        for(int i=0;i<tasks.length;i++){
            processes[i][0]=i;
            processes[i][1]=tasks[i][0];
            processes[i][2]=tasks[i][1];
            taskQ.add(processes[i]);
        }

        PriorityQueue<int[]> processQ = new PriorityQueue<>((a,b)->a[2]==b[2]?a[0]-b[0] : a[2]-b[2]);//heap by process tim, then index
        int currTime = 0 , idx=0;
        int[] res = new int[tasks.length];
        currTime = taskQ.peek()[1];
        while(!taskQ.isEmpty() || !processQ.isEmpty()){

            while(!taskQ.isEmpty() && taskQ.peek()[1]<=currTime){
                processQ.add(taskQ.poll());
            }
            if(!processQ.isEmpty()){
                int[] top = processQ.poll();
                res[idx++]=top[0];
                currTime += top[2];
            }else{
                currTime = taskQ.peek()[1];
            }
        }
        return res;
    }

    //when there are more than one core --> use free and engaged priority queues logic similar to this prob https://leetcode.com/problems/meeting-rooms-iii/solutions/
}
