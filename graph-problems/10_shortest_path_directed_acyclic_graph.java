import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Build an adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int node = edge[0], vertices = edge[1], weight = edge[2];
            graph.get(node).add(new int[]{ vertices, weight });
        }

        // Step 2: Topological Sort using DFS
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, graph, visited, stack);
            }
        }

        // Step 3: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Source node

        // Step 4: set the nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : graph.get(node)) {
                    int adj = neighbor[0];
                    int weight = neighbor[1];
                    if (dist[node] + weight < dist[adj]) {
                        dist[adj] = dist[node] + weight;
                    }
                }
            }
        }

         // Step 5: Mark unreachable nodes as -1
         for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private void topoSort(int node, List<List<int[]>> graph, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(int[] neighbor : graph.get(node)){
            if(!visited[neighbor[0]]) topoSort(neighbor[0], graph, visited, stack);
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
            {0, 1, 2}, {0, 4, 1},
            {1, 2, 3}, {4, 2, 2},
            {2, 3, 6}, {4, 5, 4}, {5, 3, 1}
        };
        int[] result = new Solution().shortestPath(V, edges.length, edges);
        System.out.println(Arrays.toString(result));
    }
}