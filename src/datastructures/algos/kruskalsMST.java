package datastructures.algos;

import java.util.Arrays;

/*
Time Complexity: O(E * logE) or O(E * logV)

Sorting of edges takes O(E * logE) time.
After sorting, we iterate through all edges and apply the find-union algorithm. The find and union operations can take at most O(logV) time.
So overall complexity is O(E * logE + E * logV) time.
The value of E can be at most O(V2), so O(logV) and O(logE) are the same. Therefore, the overall time complexity is O(E * logE) or O(E*logV)
Auxiliary Space: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 */

//Here, we are using Disjoint Set / Union Find data structure with Union by size (path compression optimization)
public class kruskalsMST {
    int spanningTree(int V, int E, int edges[][]) {
        int[] parent = new int[V];
        int[] size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int weight = 0;
        int edgeCount=0;
        for (int[] row : edges) {
            int st = row[0];
            int end = row[1];
            int stParent = getParent(st, parent);
            int endParent = getParent(end, parent);
            if (stParent != endParent) {
                if (size[stParent] > size[endParent]) {
                    size[stParent] += size[endParent];
                    parent[endParent] = stParent;
                } else {
                    size[endParent] += size[stParent];
                    parent[stParent] = endParent;
                }
                weight += row[2];
                //Maintain a result array and add the edge here if we want to print the MST edges
                if(++edgeCount == V-1){//optional, pruning optimization
                    return weight;
                }
            }
        }

        return weight;
    }

    int getParent(int i, int[] parArr) {
        int parent = parArr[i];
        while (parent != parArr[parent]) {
            parent = parArr[parent];
        }
        return parent;
    }
}
