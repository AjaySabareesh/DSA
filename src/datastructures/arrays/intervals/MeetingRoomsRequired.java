package datastructures.arrays.intervals;

import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=FdzJmTCVyJU
//https://neetcode.io/problems/meeting-schedule-ii
//Finding max overlaps
public class MeetingRoomsRequired {
    public class Interval {
     public int start, end;
     public Interval(int start, int end) {
       this.start = start;
          this.end = end;
      }
  }
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        int[] st=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            st[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int i=0,j=0;
        int res=0, cnt=0;
        while(i<n){
            if(st[i]<end[j]){
                cnt++;
                i++;
            }else{
                j++;
                cnt--;
            }
            res=Math.max(res,cnt);
        }
        return res;
    }
}
