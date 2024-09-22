package datastructures.maths;

//https://leetcode.com/problems/sqrtx/solutions/25047/a-binary-search-solution/
public class Sqrt {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int low=1, high=x;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==x/mid){
                return mid;
            }else if(mid>x/mid){
                high=mid-1;
            }else{
                if((mid+1)>x/(mid+1)){
                    return mid;
                }
                low=mid+1;
            }
        }
        return -1;
    }
}
