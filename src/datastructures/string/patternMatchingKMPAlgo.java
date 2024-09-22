package datastructures.string;

import java.util.ArrayList;

//Runtime complexity - O(m + n) where m is length of text and n is length of pattern
// Space complexity - O(n)

//https://www.youtube.com/watch?v=GTJr8OvyEVQ
//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
public class patternMatchingKMPAlgo {
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int m = txt.length();
        int n = pat.length();
        int[] lps = computeLPS(pat, n);

        int i=0;//txt index
        int j=0;//pat index
        //while((m-i) >= (n-j)){//optimization condition
        while(i<m && j<n){
            if(txt.charAt(i)==pat.charAt(j)){
                //match
                i++;
                j++;

                if(j==n){
                    //pattern fully matched with text
                    res.add(i-n+1);//i-pat length will 0- based index ans
                    j=lps[j-1];
                }
            }else{
                //do not match
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }

        return res;
    }

    //longest proper prefix which is also a suffix
    int[] computeLPS(String pat, int n){
        int[] lps = new int[n];

        int j=0, i=1;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                if(j==0){
                    lps[i]=0;
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
        }

        return lps;
    }
}
