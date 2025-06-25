import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// Approach : most common using the Priority Queue

class Solution {
    static class Pair {
        int node, weight;
        Pair(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // creating an adjacency list with empty list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        // Step 1: Build adjacency list
        for(int[] edge : edges){
            int node = edge[0];
            int vertices = edge[1];
            int weight = edge[2];

            adj.get(node).add(new Pair(vertices, weight));
            adj.get(vertices).add(new Pair(node, weight));
        }

        // Step 2: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Min-heap: stores {distance, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int currentDist = current.weight;

            for (Pair neighbor : adj.get(node)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (currentDist + weight < dist[v]) {
                    dist[v] = currentDist + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}