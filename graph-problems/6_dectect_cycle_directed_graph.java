

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Approach: DFS Traversal

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int currentVertex = 0; currentVertex < V; currentVertex++) {
            if (!visited[currentVertex]) {
                if (computeDFS(currentVertex, visited, recStack, adjacencyList)) return true;
            }
        }
        return false;
    }

    private boolean computeDFS(int currentNode, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[currentNode] = true;
        recStack[currentNode] = true;

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited[neighbor]) {
                if (computeDFS(neighbor, visited, recStack, adjacencyList)) return true;
            }
            else if (recStack[neighbor]) return true;
        }
        return false; // No cycle detected in this path
    }
}

// Approach: BFS Traversal

class Solution2 {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        int[] inDegree = new int[V];

        // Step 1: Calculate in-degree of each node
        for (int node = 0; node < V; node++) {
            for (int neighbor : adjacencyList.get(node)) {
                inDegree[neighbor]++;
            }
        }

        // Step 2: Add all nodes with 0 in-degree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int count = 0;

        // Step 3: Kahn's BFS process
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : adjacencyList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: If not all nodes are processed, there is a cycle
        return count != V;
    }
}