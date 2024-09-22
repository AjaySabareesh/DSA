package datastructures.deque;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/solutions/65884/java-o-n-solution-using-deque-with-explanation/
//https://www.youtube.com/watch?v=TCHSXAu5pls
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n-k+1];
        int idx=0;

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){//rem before window range elems
                deque.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.add(i);

            if(i>=k-1){
                res[idx++]=nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
