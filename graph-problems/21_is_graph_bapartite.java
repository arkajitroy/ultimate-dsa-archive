import java.util.*;

/*
- 🧠 What is a Bipartite Graph?
A graph is bipartite if:You can split the nodes into two groups (say, A and B), So that no edge connects two nodes within the same group.

🎨 Real-life analogy:
Think of coloring the graph with two colors — no two connected nodes should have the same color.
*/

// Approach: BFS Approach { RECOMMENDED }
// Complexity: O(n+e) | O(n+e)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        // BFS Traversal
        for(int i=0; i<n; i++){
            if (colors[i] != 0) continue;

            // Queue : to perform BFS
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1; // color the first node with 1
            
            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) {
                        // Color opposite
                        colors[neighbor] = -colors[node];
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        // Same color neighbor → not bipartite
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

// Approach: DFS Approach
// Complexity: O(n+e) | O(n+e)
class Solution2 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        // DFS Traversal
        for (int i = 0; i < n; i++) {
             if (colors[i] == 0 && !computeDFS(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean computeDFS(int[][] graph, int[] colors, int node, int color) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            // if the neighbor is not colored, color it with the opposite color
            if (colors[neighbor] == 0) {
                if (!computeDFS(graph, colors, neighbor, -color)) return false;
            } 
            // if the neighbor has same color, then return false
            else if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }
}

