import java.util.*;

// Approach: DFS Approach
// Complexity : O(n + e) | O(n + e) ==> n : number of nodes, e : number of edges
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // parent array is to track the parent of each nodes
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Union Find Algorithm
        for (int[] edge : edges) {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);

            if (root1 == root2) return false; // cycle detected

            parent[root1] = root2; // union
        }

        return true;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }
}


// Approach: BFS Approach
// Complexity : O(n + e) | O(n + e) ==> n : number of nodes, e : number of edges
class Solution2 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // map structure : { node -> [neighbors] }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Construct the graph
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        // BFS Traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (visited[neighbor]) continue;

                visited[neighbor] = true;
                queue.offer(neighbor);

                // Remove reverse edge to prevent revisiting parent
                graph.get(neighbor).remove((Integer) node);
            }
        }
        // Check if all nodes are visited or not (if not then graph is disconnected)
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
