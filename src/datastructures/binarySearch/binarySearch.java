package datastructures.binarySearch;

//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
//https://leetcode.com/problems/split-array-largest-sum/
//https://www.youtube.com/watch?v=gYmWHvRHu-s
//TC - O(N log N), SC- O(1)

//Refer this just for backtracking reference - not the best approach for this problem
//https://leetcode.com/problems/fair-distribution-of-cookies/solutions/2140918/easy-c-backtracking/
public class binarySearch {
    //Function to find minimum number of pages.
    public int findPages(int[]A,int N,int M)
    {
        if(M > N){
            return -1;
        }
        int low =0, high=0;
        for(int num:A){
            low = Math.max(low, num);
            high += num;
        }

        //do bs
        int ans =0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isValid(A, mid, M, N)){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean isValid(int[] A, int limit, int M, int N){
        int reqStudents = 1, pages = 0;
        for(int val:A){
            if(val > limit){
                return false;
            }
            if(pages+val <=limit){
                pages +=val;
            }else{
                reqStudents++;
                pages=val;
            }
            if(reqStudents>M){
                return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/discuss/interview-question/352743/Google-or-Onsite-or-Guaranteed-Binary-Search-Numbers
// https://leetcode.com/discuss/interview-question/352743/Google-or-Onsite-or-Binary-Searchable-Numbers
//public class Main {
//
//    public static int binarySearchable(int... nums) {
//        int n = nums.length;
//        int count = 0;
//
//        int[] maxLeft = new int[n];
//        maxLeft[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
//        }
//
//        int minRight = Integer.MAX_VALUE;
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] <= minRight && nums[i] >= maxLeft[i]) {
//                count++;
//            }
//            minRight = Math.min(minRight, nums[i]);
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        test(binarySearchable(1, 3, 2), 1);
//        test(binarySearchable(2, 1, 3, 5, 4, 6), 2);
//        test(binarySearchable(1, 5, 7, 11, 12, 18), 6);
//        test(binarySearchable(3, 2, 1), 0);
//        test(binarySearchable(5, 4, 6, 2, 8), 1);
//        test(binarySearchable(1, 3, 2, 4, 5, 7, 6, 8), 4);
//        test(binarySearchable(-100, -98, -94, -97, -93, -88, -83, -78, -67, -58, -51, -49, -48, -72, -46, -43, -33, -31, -29, -26, -27, -25, -23, -13, -11, -9, 4, 8, 16, 25, 24, 53, 62, 68, 74, 78, 81, 82, 89, 90, 97, 98), 30);
//        test(binarySearchable(-9682, -8974, -8983, -6614, -8766, -8535, -8212, -8574, -7950, -5235, -9891, -4194, -5253, -4956, -7001, -1668, -4292, -6747, -4186, -2922, -1797, -2353, 265, -3304, -4365, -1629, -1476, 3507, 3402, 1595, 1128, 936, 1837, 1706, 3391, 6773, -3639, 4841, 6109, 9659, 5001, 6408, 6240, 6436, 2171, 6917, 8993, 8999, 9682, 5752), 0);
//        test(binarySearchable(-250, -240, -230, -220, -210, -200, -190, -180, -170, -160, -150, -140, -130, -120, -100, -90, -80, -70, -60, -110, -50, -40, -30, 30, 40, 50, 60, -20, -10, 0, 10, 20, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240), 35);
//    }
//
//    private static void test(int actual, int expected) {
//        if (actual == expected) {
//            System.out.println("PASSED!");
//        } else {
//            System.out.println(String.format("FAILED! Expected %d, but got %d", expected, actual));
//        }
//    }
//}
