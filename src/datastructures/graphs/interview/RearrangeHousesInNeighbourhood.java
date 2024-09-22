package datastructures.graphs.interview;
/*
You are given a list of houses grouped into neighborhoods. Houses are painted in colors.
The first input is an array representing house numbers in each neighborhood. One sub-array represents one neighborhood. Example:
{{8, 2, 9}, {4, 6, 4}, {4, 5, 1}}

Each house is painted, so the second input is an array representing the color codes for each house. Example:
{{'r', 'g', 'b'}, {'w', 'c', 'b'}, {'x', 'y', 'b'}}

This means that House 8 is painted in color r, House 2 is g, House 9 is b etc.

Imagine that you can move houses, reorganize the neighborhoods such that the houses in each neighborhood are in ascending order, and no house numbers are repeated in a neighborhood.
The neighborhood structure must be preserved, meaning that the number of neighborhoods and the number of houses in each neighborhood should remain the same as given.
Here are a couple of possible outputs of how the houses from the example above could be restructured:
{{1, 2, 4}, {4, 5, 6}, {4, 8, 9}}
{{1, 4, 6}, {2, 4, 8}, {4, 5, 9}}

{{1,2,4},{4,5,6},{4,6,8}}

Return all houses structured in neighborhoods along with their colors in the new order. If printing it, a sample output would look like this:
{{1b, 4b, 6c}, {2g, 4x, 8r}, {4w, 5y, 9b}}

*/

import java.util.*;

//TC - N * (K log K) , N - no of neighbourhoods, K - size of each neighbourhood
//TC - N*K log(N*K)
//SC - N*K
//TreeMap operations like insertion, deletion, and retrieval have a time complexity of O(log n), where n is the number of elements in the TreeMap. This is due to the self-balancing nature of the underlying Red-Black Tree.
public class RearrangeHousesInNeighbourhood {
    public List<List<String>> arrange (List<List<Integer>> houses , List<List<Character>> colors ){
        if(houses == null || houses.size()==0 || houses.get(0).size()==0){
            return null;
        }
        int neighbs = houses.size();
        int size = houses.get(0).size();

        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<neighbs;i++){
            res.add(new ArrayList<>());
        }
        TreeMap<Integer, Integer> houseMap = new TreeMap<>();
        HashMap<Integer, List<Character>> colorMap = new HashMap<>();
        for(int i=0;i<neighbs;i++){
            List<Integer> neib = houses.get(i);
            List<Character> color = colors.get(i);
            for(int j=0;j<size;j++){
                int h=neib.get(j);
                char c= color.get(j);
                houseMap.merge(h,1,(old, new1)->(old+new1));
                if(houseMap.get(h)>size){
                    System.out.println("Invalid inputs , cannot create result without repetition in a single neighbourhood");
                    return null;
                }
                List<Character> list = colorMap.getOrDefault(h, new ArrayList<>());
                list.add(c);
                colorMap.put(h, list);
            }
        }

        int grpIdx =0;
        for(Map.Entry<Integer, Integer> entry:houseMap.entrySet()){
            int hNo = entry.getKey();
            int cnt = entry.getValue();
            while(cnt > 0){
                List<String> grp = res.get(grpIdx);
                List<Character> colorList = colorMap.get(hNo);
                char color = colorList.get(colorList.size()-1);
                colorList.remove(colorList.size()-1);
                grp.add(hNo+""+color);
                cnt--;
                grpIdx= (grpIdx+1)%neighbs;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] houses = {{8, 2, 9}, {4, 6, 4}, {4, 5, 1}};
        char[][] colors = {{'r', 'g', 'b'}, {'w', 'c', 'b'}, {'x', 'y', 'b'}};
        List<List<Integer>> houseList = new ArrayList<>();
        for(int[] house: houses){
            List<Integer> list = new ArrayList<>();
            houseList.add(list);
            for(int i:house){
                list.add(i);
            }
        }
        List<List<Character>> colorList = new ArrayList<>();
        for(char[] color: colors){
            List<Character> list = new ArrayList<>();
            colorList.add(list);
            for(char c:color){
                list.add(c);
            }
        }

        System.out.println(new RearrangeHousesInNeighbourhood().arrange(houseList,colorList));
    }
}
