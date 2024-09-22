package datastructures.arrays;

//https://leetcode.com/problems/container-with-most-water/
//https://leetcode.com/problems/trapping-rain-water/description/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int max=0;
        int area=0;
        while(left<right){
            if(height[left]<height[right]){
                area = (right-left) * height[left];
                left++;
            }else{
                area = (right-left) * height[right];
                right--;
            }
            max=Math.max(area,max);
        }
        return max;
    }
}


//https://leetcode.com/problems/trapping-rain-water/
//TC - O(n), SC - O(n)
//Used Monotonous Decreasing Stack to find Next and Previous Largest Element
//public class P36_TrappingRainWater_Sol1 {
//    public int trap(int[] height) {
//        int res = 0;
//        Stack<Integer> stack = new Stack<Integer>();//Decreasing Stack;
//        int i=0;
//        while(i<height.length) {
//            while(!stack.isEmpty() && height[i]>height[stack.peek()]) {
//                int h = height[stack.pop()];
//                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
//                int rightIndex = i;
//                if(leftIndex>-1 && rightIndex>-1) {
//                    res += (Math.min(height[leftIndex], height[rightIndex])-h) * (rightIndex-leftIndex-1);
//                }
//            }
//            stack.push(i);
//            i++;
//        }
//
//        return res;
//    }
//}
//public int trap(int[] height) {
//    int res = 0;
//TC-O(N), SC-O(1)
    // int left =0, right=height.length-1;
    // int leftMax =-1, rightMax = -1;
    // while(left<right) {
    // 	if(height[left]<height[right]) {
    // 		if(leftMax !=-1 && height[leftMax]>height[left]) {
    // 			res += height[leftMax]-height[left];
    // 		}else {
    // 			leftMax=left;
    // 		}
    // 		left++;
    // 	}else {//height[left]>height[right]
    // 		if(rightMax !=-1 && height[rightMax]>height[right]) {
    // 			res += height[rightMax]-height[right];
    // 		}else {
    // 			rightMax=right;
    // 		}
    // 		right--;
    // 	}
    // }

////TC-O(N), SC-O(N)
//    int n=height.length;
//    int[] leftMax = new int[n];
//    leftMax[0]=0;
//    for(int i=1;i<n;i++){
//        leftMax[i]=Math.max(leftMax[i-1], height[i-1]);
//    }
//    int rightMax=height[n-1];
//    for(int i=n-2;i>=0;i--){
//        rightMax = Math.max(rightMax, height[i+1]);
//        int water = Math.min(leftMax[i], rightMax)-height[i];
//        res += water>0?water:0;
//    }
//
//    return res;
//}


//https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
//TC - O(n), SC - O(n)
//Used Monotonous Increasing Stack to find Next and Previous Smallest Element
//class Solution361
//{
//    //Function to find largest rectangular area possible in a given histogram.
//    public static long getMaxArea(long hist[], long n) {
//        long maxArea = 0;
//        Stack<Integer> incrStack = new Stack<Integer>();
//        int i=0;
//        while(i<hist.length) {
//            if(incrStack.isEmpty() || hist[i] >= hist[incrStack.peek()] ) {
//                incrStack.push(i);
//                i++;
//            }else {
//                int index = incrStack.pop();
//                int leftIndex = incrStack.isEmpty() ? -1 : incrStack.peek();
//                long area = (i-leftIndex-1) * hist[index];
//                maxArea = Math.max(maxArea, area);
//            }
//        }
//        while(!incrStack.isEmpty()) {
//            int index = incrStack.pop();
//            int leftIndex = incrStack.isEmpty() ? -1 : incrStack.peek();
//            long area = (n-leftIndex-1) * hist[index];
//            maxArea = Math.max(maxArea, area);
//        }
//        return maxArea;
//    }

//https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/