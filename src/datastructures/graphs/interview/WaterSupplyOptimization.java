package datastructures.graphs.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.ca/2019-02-10-1168-Optimize-Water-Distribution-in-a-Village/
//https://wentao-shao.gitbook.io/leetcode/union-find/1168.optimize-water-distribution-in-a-village
//https://leetcode.com/discuss/interview-question/321507/Google-or-Onsite-interview-or-Power-supply
public class WaterSupplyOptimization {
    public static void main(String[] args) {
        int n = 3;
        int[] wells = {1,2,2};
        int[][] pipes = {{1,2,1},{2,3,1}};
        int cost =new WaterSupplyOptimization().minCost(n, wells, pipes);
        System.out.println(cost);
    }

    int minCost(int n, int[] wells, int [][] pipes){
        int cost = 0;
        List<int[]> edges = new ArrayList<>();
        for(int[] pipe:pipes){
            edges.add(pipe);
        }
        for(int i=0;i<wells.length;i++){
            edges.add(new int[]{0, i+1, wells[i]});//use new[] while initializing array directly and adding it to a list
        }
        Collections.sort(edges, (a,b)->a[2]-b[2]);

        int[] par= new int[n+1];
        int[] size=new int[n+1];
        for(int i=0;i<=n;i++){
            par[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            int x= edge[0], y=edge[1], weight=edge[2];
            int pX = find(x, par);
            int pY=find(y,par);
            if(pX!=pY){
                if(size[pX] >size[pY]){
                    par[pY]=pX;
                    size[pX]+=size[pY];
                }else{
                    par[pX]=pY;
                    size[pY]+=size[pX];
                }
                System.out.println(x +" -> "+y + " cost "+ weight);
                cost += weight;
            }
        }
        return cost;
    }

    int find(int p, int[] par){
        while(p!=par[p]){
            p=par[p];
        }
        return p;
    }


}
