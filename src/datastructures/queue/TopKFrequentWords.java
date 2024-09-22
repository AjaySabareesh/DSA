package datastructures.queue;

import java.util.*;
//https://www.youtube.com/watch?v=cupg2TGIkyM
public class TopKFrequentWords {
    //TC-O(N LogK), SC-O(N)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.merge(word, 1, (old, new1) -> old+new1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> map.get(a)==map.get(b)? b.compareTo(a) : map.get(a)-map.get(b));
        for(String word:map.keySet()){
            queue.add(word);
            if(queue.size()>k){//At any time, we have only k elements in the PQ, others will be polled. that's why priority logic is reversed.
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
