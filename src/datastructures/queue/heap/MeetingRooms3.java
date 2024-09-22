package datastructures.queue.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-iii/
public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> unused = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            unused.add(i);
        }

        int[] cnt= new int[n];
        PriorityQueue<int[]> engaged = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);// roomNo endTime , sort by endTime
        Arrays.sort(meetings, (a, b)->a[0]-b[0]);//sort by start time
        for(int[] meeting:meetings){
            int start = meeting[0], end=meeting[1];
            while(!engaged.isEmpty() && engaged.peek()[1] <=  start){
                unused.add(engaged.poll()[0]);
            }
            if(!unused.isEmpty()){
                int room = unused.poll();
                cnt[room]++;
                engaged.add(new int[]{room, end});
            }else{
                int[] top = engaged.poll();
                int newStart = top[1];//end of prev meeting
                int newEnd = newStart+(end-start);
                top[1]=newEnd;
                engaged.add(top);
                cnt[top[0]]++;
            }
        }

        int max=0;
        for(int i=1;i<n;i++){
            if(cnt[i]>cnt[max]){
                max=i;
            }
        }
        return max;
    }
}
