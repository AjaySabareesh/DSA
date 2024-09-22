package datastructures;

import java.util.Arrays;
import java.util.List;

//https://www.javatpoint.com/flatmap-method-in-java-8#:~:text=In%20Java%208%20Streams%2C%20the,into%20a%20single%20resultant%20stream.

public class FlatMapTest {
    public static void main(String[] args) {
//        List<String> list1 = List.of("A", "B","C");
//        List<String> list2 = List.of("X", "Y","Z");
//        List<String> list3 = List.of("F", "B","D");
//        List<List<String>> listOfLists = List.of(list1,list2,list3);
//
//        listOfLists.stream().flatMap(i -> i.stream()).distinct().forEach(i->System.out.println(i));

        String s="a/b";
        String[] arr= s.split("/");
        System.out.println(Arrays.deepToString(arr));
        String[] arr2=new String[]{"a","b"};
        System.out.println(Arrays.deepToString(arr2));
    }
}
