package datastructures.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/description/
//https://leetcode.com/problems/4sum/editorial/
//TC-O(9^K), SC-O(K), can be reduced to 9^k-1 by using 2 pointer logic
public class KSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        kSum(k, n, 1, new LinkedList<Integer>());
        return res;
    }

    void kSum(int k, int sum, int start, List<Integer> list){
        if(k==0 && sum==0){
            res.add(new LinkedList<>(list));//create a new list with the values
            return;
        }
        if(k==0 || sum<0){
            return;
        }
        for(int i=start;i<=9 && i<=sum;i++){
            list.add(i);
            kSum(k-1,sum-i, i+1, list);
            list.remove(list.size()-1);
        }
    }

    //Optimized using two pointer
//    void kSum(int k, int sum, int start, List<Integer> list){
//        if(k==0 && sum==0){
//            res.add(new LinkedList<>(list));//create a new list with the values
//            return;
//        }
//        if(k==0 || sum<0){
//            return;
//        }
//        if(k==2){
//            twoPointer(sum,start, list);
//            return;
//        }
//        for(int i=start;i<=9 && i<=sum;i++){
//            list.add(i);
//            kSum(k-1,sum-i, i+1, list);
//            list.remove(list.size()-1);
//        }
//    }
//
//    void twoPointer(int sum, int start, List<Integer> list){
//        int left=start,right=9;
//        while(left<right){
//            int sum1=left+right;
//            if(sum1==sum){
//                LinkedList<Integer> newList = new LinkedList<>(list);
//                newList.add(left);
//                newList.add(right);
//                res.add(newList);
//                left++;
//                right--;
//            }
//            else if(sum1<sum){
//                left++;
//            }else{
//                right--;
//            }
//        }
//    }
}
