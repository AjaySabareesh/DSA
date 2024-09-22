package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//TC-O(n+edges), SC-O(n+edges) for adj list
//https://www.youtube.com/watch?v=m17yOR5_PpI
//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
//At each of BFS,Check for all unvisited neighbouring nodes and if the direction is outgng, then it requires a rerouting
public class ReOrderRoutes {
    class Node {
        int city;
        boolean outgng;

        Node(int city, boolean b) {
            this.city = city;
            this.outgng = b;
        }
    }

    public int minReorder(int n, int[][] connections) {
        int changes = 0;
        ArrayList<Node>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            adj[a].add(new Node(b, true));
            adj[b].add(new Node(a, false));//to know all the neighbours
        }
        //BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (Node neib : adj[i]) {
                if (!visited[neib.city]) {
                    queue.add(neib.city);
                    visited[neib.city] = true;
                    if (neib.outgng) {
                        changes++;
                    }
                }
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        System.out.println(new ReOrderRoutes().minReorder(3, new int[][]{{1, 2}, {2, 0}}));
    }
}
