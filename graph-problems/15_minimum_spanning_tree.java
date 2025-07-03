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
            MSTSum += weight;

            for(int[] neighbor: adj.get(node)){
                int adjNode = neighbor[0];
                int edgWeight = neighbor[1];

                if(!visited[adjNode]) pq.add(new int[]{ adjNode, edgWeight });
            }
        }
        return MSTSum;
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
    }
}