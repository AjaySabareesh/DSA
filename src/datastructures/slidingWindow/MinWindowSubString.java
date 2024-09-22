package datastructures.slidingWindow;

//https://leetcode.com/problems/minimum-window-substring/solutions/
//https://www.youtube.com/watch?v=U1q16AFcjKs&list=PLtQWXpf5JNGLGkKSGYW6KA0Q71t__6CgQ&index=36
public class MinWindowSubString {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minStart = 0, left=0, right=0;
        int count = t.length();
        if(count==0 || count > s.length()){
            return "";
        }
        int[] arr = new int[58];// A-65, z-122.total - 58
        for(char c:t.toCharArray()){
            arr[c-'A']++;
        }

        while(right<s.length()){
            if(arr[s.charAt(right)-'A'] > 0){
                count--;
            }
            arr[s.charAt(right)-'A']--;
            while(count==0){
                if(minLen> (right-left+1)){
                    minStart=left;
                    minLen = right-left+1;
                }
                arr[s.charAt(left)-'A']++;
                if(arr[s.charAt(left)-'A']>0){
                    count++;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "":s.substring(minStart, minStart+minLen);
    }
}
