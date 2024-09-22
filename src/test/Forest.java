package test;

import java.util.*;

public class Forest {

    public static void main(String[] args) {
        List<String> animals = Arrays.asList("cat", "tiger", "cat", "tiger", "elephant", "eagle", "cat", "fox",
                "lion", "tiger", "rabbit", "elephant", "rabbit", "tiger", "lion", "xyz", "xyz");
        Forest forest = new Forest();
        System.out.println(forest.getExtinctAnimals(animals).toString());
    }

    private List<String> getExtinctAnimals(List<String> animals) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String animal : animals) {
            map.merge(animal, 1, (old, new1) -> old + new1);
        }
        System.out.println(map);

        PriorityQueue<Animal> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (String key : map.keySet()) {
            queue.add(new Animal(key, map.get(key)));
            if (queue.size() > 3) {
                queue.poll();
            }
        }

        List<String> extinct = new ArrayList<>();
        for (Animal animal : queue) {
            extinct.add(animal.name);
        }
        Collections.reverse(extinct);
        return extinct;
    }

    class Animal {
        String name;
        int count;

        Animal(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }


}
