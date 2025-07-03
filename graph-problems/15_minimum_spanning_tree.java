// Minimum Spanning Tree
// A tree in which we have n nodes & n-1 edges and all nodes are reachable from each other

// Prime's Algo <-- It is not the optimal way to find the MST

// Time Complexity: O(E log V)
// Space Complexity : O(V + E)

import java.util.*;

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); // [node, weight]

        pq.add(new int[]{0, 0});
        int MSTSum = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if(visited[node]) continue; // if it is visited then we will go to next node
            
            visited[node] = true;
            MSTSum += weight;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (!visited[adjNode]) pq.add(new int[]{adjNode, edgeWeight});
            }
        }
        return MSTSum;
    }

    // Follow up question : A list of edges that form the MST.
    static List<List<Integer>> mstWithEdges(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];        // To store parent of each node in MST
        int[] weights = new int[V];           // To store min edge weights
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // (node, weight)
        
        Arrays.fill(weights, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        weights[0] = 0;
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int wt = neighbor[1];

                if (!visited[v] && wt < weights[v]) {
                    weights[v] = wt;
                    parent[v] = u;
                    pq.add(new int[]{v, wt});
                }
            }
        }

        // Build the result list of edges
        List<List<Integer>> mstEdges = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            mstEdges.add(Arrays.asList(parent[i], i, weights[i]));
        }

        return mstEdges;
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 6;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example graph edges (undirected)
        // Edge: 0-1 (2), 0-3 (6), 1-2 (3), 1-3 (8), 1-4 (5), 2-4 (7)
        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});
        
        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});
        
        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});
        
        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});
        
        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});
        
        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});

        System.out.println("Total weight of MST: " + spanningTree(V, E, adj));

        List<List<Integer>> mst = mstWithEdges(V, E, adj);
        System.out.println("Edges in MST:");
        for (List<Integer> edge : mst) {
            System.out.println("From : " + edge.get(0) + " -> " + edge.get(1) + " : (w) " + edge.get(2));
        }
    }
}