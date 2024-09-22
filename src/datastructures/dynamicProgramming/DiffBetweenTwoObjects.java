package datastructures.dynamicProgramming;

import java.util.*;

public class DiffBetweenTwoObjects {
    public Object objDiff(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return new HashMap<>();
        }
        if (obj1 == null || obj2 == null) {
            return Arrays.asList(obj1, obj2);
        }
        if (!getType(obj1).equals(getType(obj2))) {
            return Arrays.asList(obj1, obj2);
        }
        if (!isMap(obj1) && !(obj1 instanceof  List) ) {
            return Objects.equals(obj1, obj2) ? null : Arrays.asList(obj1, obj2);
        }
        if(obj1 instanceof  List ){
            HashMap<String, Object> listMap = new HashMap<>();
            List<Object> list1 = (List)obj1;
            List<Object> list2 = (List)obj2;
            int n= Math.min(list1.size(), list2.size());
            Object indexDiff = null;
            for(int i=0;i<n;i++){
                indexDiff = objDiff(list1.get(i), list2.get(i));
                if(indexDiff !=null){
                    listMap.put(i+"", indexDiff);
                }
            }
            return indexDiff;
        }

        Map<String, Object> diffMap = new HashMap<>();

        Map<String, Object> map1 = (Map)obj1;
        Map<String, Object> map2 = (Map)obj2;

        Set<String> keys = map1.keySet();
        keys.retainAll(map2.keySet());//The retainAll() method of java.util.Set interface is used to retain from this set all of its elements that are contained in the specified collection.

        for(String key:keys){
            Object subDiff = objDiff(map1.get(key), map2.get(key));
            if (subDiff !=null && subDiff instanceof Map && !((Map) subDiff).isEmpty()) {
                diffMap.put( key, subDiff);
                // If subDiff is a List indicating the values are different, add to diff
            } else if (subDiff instanceof List) {
                diffMap.put( key, subDiff);
            }
        }
        return diffMap;
    }

    String getType(Object obj) {
        return obj.getClass().getSimpleName();
    }

    boolean isMap(Object obj){
        return obj instanceof Map;
    }

    public static void main(String[] args) {
        HashMap<String, Object> ob1 = new HashMap<>();
        ob1.put("a", 10);
        ob1.put("b", 20);
        HashMap<String, Object> temp1 = new HashMap<>();
        temp1.put("a", null);
        ob1.put("z", temp1);
        ob1.put("x", Arrays.asList(new int[]{1, 2, 4}));
        System.out.println(ob1.get("a") instanceof List);

        HashMap<String, Object> ob2 = new HashMap<>();
        ob2.put("a", 30);
        ob2.put("b", 20);
        HashMap<String, Object> temp2 = new HashMap<>();
        temp2.put("a", 2);
        ob2.put("z", temp2);
//        ob2.put("x", new int[]{1, 2, 3, 1});
        ob2.put("x", Arrays.asList(new int[]{1, 2, 3}));

        System.out.println(new DiffBetweenTwoObjects().objDiff(ob1,ob2));
    }
}
