// Approach: DFS Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[V];

        for (int currentVertex = 0; currentVertex < V; currentVertex++) {
            if (!visited[currentVertex]) {
                if (computeDFS(currentVertex, -1, visited, adjacencyList)) return true;
            }
        }
        return false;
    }

    private boolean computeDFS(int currentNode, int parentNode, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[currentNode] = true;

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited[neighbor]) {
                if (computeDFS(neighbor, currentNode, visited, adjacencyList)) return true;
            }
            else if (neighbor != parentNode) return true;
        }
        return false; // No cycle detected in this path
    }
}

// Approach: BFS Traversal

class Solution2 {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[V];

        for (int currentVertex = 0; currentVertex < V; currentVertex++) {
            if (!visited[currentVertex]) {
                if (computeBFS(currentVertex, visited, adjacencyList)) return true;
            }
        }
        return false;
    }

    private boolean computeBFS(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for(int neighbor : adjacencyList.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(new int[]{ neighbor, node });
                }
                else if(neighbor != parent) return true;
            }
        }
        return false;
    }
}