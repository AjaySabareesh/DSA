package datastructures.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinationsOfPhoneNumber {
    //TC-O(4^N), SC-O(N)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = createPhoneMap();
        combinations("",digits, map, res);
        return res;
    }

    void combinations(String s,String digits,HashMap<Character, String> map, List<String> res){
        if(digits.isEmpty()){
            if(!s.isEmpty())
                res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(0));
        for(char letter:letters.toCharArray()){
            combinations(s+letter, digits.length()==1 ? "":digits.substring(1), map, res);
        }
    }

    HashMap<Character, String> createPhoneMap(){
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return map;
    }
}
