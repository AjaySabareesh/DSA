package datastructures.string;

import java.util.ArrayList;
import java.util.List;

//https://neetcode.io/problems/string-encode-and-decode
//https://medium.com/@miniChang8/leetcode-encode-and-decode-strings-4dde7e0efa1c

//https://leetcode.com/problems/decode-string/solutions/87662/python-solution-using-stack/
public class encodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s:strs){
            res.append(s.length()).append('@').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        String size="";
        while(i<str.length()){
            if(str.charAt(i)=='@'){
                int len = Integer.parseInt(size);
                String s = str.substring(i+1, i+len+1);
                res.add(s);
                i=i+len+1;
                size="";
            }else{
                size+=str.charAt(i);
                i++;
            }
        }
        return res;
    }
}
