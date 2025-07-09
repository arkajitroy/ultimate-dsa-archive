import java.util.*;

// Question: Leetcode premium
// n nodes (labeled 0 to n-1)
// An edge list edges, where each edge connects two nodes in an undirected graph.
// Return the number of connected components.

// Approach: DFS Approach
// Complexity: O(V + E) | O(V + E)

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}

// Approach: Union Find Algorithm (Disjoin set)
// Complexity: O(E × α(N)) | O(V)  <-- space optimized

class Solution2 {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (union(u, v, parent)) {
                components--; // reduce if merged
            }
        }

        return components;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private boolean union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) return false; // already connected
        parent[py] = px; // merge
        return true;
    }
}