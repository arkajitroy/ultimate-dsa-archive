
// Works on the Directed Graph
// Doesn't Fails if the graph has negative edges

import java.util.Arrays;

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {

        // Step-1 : Initialize distance array with infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step-2: Relax all edges (V-1) times
        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int node = edge[0];
                int vertices = edge[1];
                int weight = edge[2];

                // Only relax if the node is reachable;
                if(dist[node] != Integer.MAX_VALUE && dist[node] + weight < dist[node]){
                    dist[vertices] = dist[node] + weight;
                }
            }
        }
        // Step-3: Check for the negative
        for (int[] edge : edges) {
            int node = edge[0];
            int vertices = edge[1];
            int weight = edge[2];

            if (dist[node] != Integer.MAX_VALUE && dist[node] + weight < dist[vertices]) {
                return new int[]{-1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int V = 5;
        int[][] edges = {
            {0, 1, -1},
            {0, 2, 4},
            {1, 2, 3},
            {1, 3, 2},
            {1, 4, 2},
            {3, 2, 5},
            {3, 1, 1},
            {4, 3, -3}
        };
        int src = 0;

        int[] result = sol.bellmanFord(V, edges, src);
        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative weight cycle detected.");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            for (int i = 0; i < result.length; i++) {
                System.out.println("To " + i + " -> " + result[i]);
            }
        }
    }
}
