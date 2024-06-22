package Graphs;

import java.util.Arrays;

class Main{
    public static boolean isBipartite(int[][] graph){
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1); // Initialize all nodes as uncolored

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfsCheck(graph, colors, i, 0)) return false;
            }
        }
        return true;
    }

    private static boolean dfsCheck(int[][] graph, int[] colors, int node, int color){
        colors[node] = color; // Color the current node

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) { // If the neighbor is not colored
                if (!dfsCheck(graph, colors, neighbor, 1 - color)) return false;
            } else if (colors[neighbor] == colors[node]) return false;
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