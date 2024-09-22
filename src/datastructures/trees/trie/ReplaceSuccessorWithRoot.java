package datastructures.trees.trie;

import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/replace-words/
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/submissions/1240834435/

//Time complexity:
//O(N+M)
//O(N) to builder the dictionary
//O(M) find and
// replacing the words
//
//Space complexity:
//O(N) to build a dictionary
public class ReplaceSuccessorWithRoot {
    class TrieNode{
        TrieNode[] children;
        boolean eow;
        TrieNode(){
            children= new TrieNode[26];
            eow=false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word:dictionary){
            addNode(root, word);
        }
        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            String res = find(root, arr[i]);
            if(res!=null){
                arr[i]=res;
            }
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(a ->sb.append(a).append(" "));
        return sb.substring(0, sb.length()-1);
    }

    void addNode(TrieNode node, String word){
        for(char ch:word.toCharArray()){
            if(node.children[ch-97]==null){
                TrieNode tn = new TrieNode();
                node.children[ch-97] = tn;
            }
            node = node.children[ch-97];
        }
        node.eow=true;
    }

    String find(TrieNode node, String word){
        StringBuilder sb= new StringBuilder();
        for(char ch:word.toCharArray()){
            if(node.children[ch-97]==null){
                return null;
            }else{
                sb.append(ch);
                node = node.children[ch-97];
                if(node.eow){
                    return sb.toString();
                }
            }
        }
        return null;
    }
}
