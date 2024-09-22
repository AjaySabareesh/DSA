package datastructures;

import java.util.*;
import java.lang.*;
import java.io.*;
//class GFG {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =
//                new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine().trim());
//        while (T-- > 0) {
//            String[] s = br.readLine().trim().split(" ");
//            int V = Integer.parseInt(s[0]);
//            int E = Integer.parseInt(s[1]);
//            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
//            for (int i = 0; i < E; i++) {
//                String[] S = br.readLine().trim().split(" ");
//                int u = Integer.parseInt(S[0]);
//                int v = Integer.parseInt(S[1]);
//                adj.get(u).add(v);
//                // adj.get(v).add(u);
//            }
//            Solution obj = new Solution();
//            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
//            for (int i = 0; i < ans.size(); i++)
//                System.out.print(ans.get(i) + " ");
//            System.out.println();
//        }
//    }
//}
class BFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        doBFS(0, adj, visited, res);
        return res;
    }

    private void doBFS(int node, ArrayList<ArrayList<Integer>> adj,boolean[] visited, ArrayList<Integer> res){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            int elem = queue.poll();
            res.add(elem);
            for(Integer next: adj.get(elem)){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }

    }
}