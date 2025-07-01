import java.util.*;

// Djikstras algorithm helps to find the shortest path in a graph!
// Fails : When the graph has negative edges
// Fails : Goes to TLE if the graph has negative cycles

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

        // Step 4: Traversing the nodes
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int currentDist = current.weight;

            for (Pair neighbor : adj.get(node)) {
                int v = neighbor.node;
                int weight = neighbor.weight;
                int newDistance = currentDist + weight;

                if (newDistance < dist[v]) {
                    dist[v] = newDistance;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}