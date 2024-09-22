package datastructures.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    //https://leetcode.com/problems/lru-cache/solutions/45939/laziest-implementation-java-s-linkedhashmap-takes-care-of-everything/
    LinkedHashMap<Integer, Integer> map;
    final int MAX;
    public LRUCache(int capacity) {
        MAX=capacity;
        //In the constructor, the third boolean parameter specifies the ordering mode. If we set it to true, it will be in access order.false- insertion order
        //constructor - initial capacity, load factor, accessOrder https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
        map = new LinkedHashMap<Integer, Integer>(capacity+1,1.0f, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > MAX;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
//Interview expected solution - custom built of Doubly Linked list
//public class LRUCache {
//    private class Node{
//        int key, value;
//        Node prev, next;
//        Node(int k, int v){
//            this.key = k;
//            this.value = v;
//        }
//        Node(){
//            this(0, 0);
//        }
//    }
//    private int capacity, count;
//    private Map<Integer, Node> map;
//    private Node head, tail;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.count = 0;
//        map = new HashMap<>();
//        head = new Node();
//        tail = new Node();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        Node n = map.get(key);
//        if(null==n){
//            return -1;
//        }
//        update(n);
//        return n.value;
//    }
//
//    public void set(int key, int value) {
//        Node n = map.get(key);
//        if(null==n){
//            n = new Node(key, value);
//            map.put(key, n);
//            add(n);
//            ++count;
//        }
//        else{
//            n.value = value;
//            update(n);
//        }
//        if(count>capacity){
//            Node toDel = tail.prev;
//            remove(toDel);
//            map.remove(toDel.key);
//            --count;
//        }
//    }
//
//    private void update(Node node){
//        remove(node);
//        add(node);
//    }
//    private void add(Node node){
//        Node after = head.next;
//        head.next = node;
//        node.prev = head;
//        node.next = after;
//        after.prev = node;
//    }
//
//    private void remove(Node node){
//        Node before = node.prev, after = node.next;
//        before.next = after;
//        after.prev = before;
//    }
//}