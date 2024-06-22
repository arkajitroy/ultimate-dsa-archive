package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static boolean isBipartite(int[][] graph){
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1); // initializing all node as uncolored

        for(int node=0; node<graph.length; node++){
            if(colors[node] == -1){ // if yet not colored
                if(!bfsCheck(graph, colors, node)) return false;
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] graph, int[] colors, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph[node]){
                if(colors[neighbor] == -1){
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                }
                else if(colors[neighbor] == colors[node]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph1)); // Output: true

        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph2)); // Output: false
    }
}
