import java.util.*;

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();

        // Step 1: Convert adj list to edge list
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0], wt = neighbor[1];
                if (u < v) { // avoid duplicate edges (undirected)
                    edges.add(new int[]{u, v, wt});
                }
            }
        }

        // Step 2: Sort edges by weight
        edges.sort(Comparator.comparingInt(a -> a[2]));

        // Step 3: Initialize DSU
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        // Step 4: Kruskal's MST Construction
        int mstWeight = 0, count = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (find(u, parent) != find(v, parent)) {
                union(u, v, parent);
                mstWeight += wt;
                count++;
                if (count == V - 1) break; // MST complete
            }
        }

        return mstWeight;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    static void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py) parent[py] = px;
    }
}
