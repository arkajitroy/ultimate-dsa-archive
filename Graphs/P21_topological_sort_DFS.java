package Graphs;

import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static int[] topologicalSort(int numVertices, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        int[] topologicalOrder = new int[numVertices];

        // Perform DFS from each vertex
        for (int node = 0; node < numVertices; node++) {
            if (!visited[node]) {
                performDFS(node, visited, stack, adj);
            }
        }

        int index = 0;
        while (!stack.isEmpty()) {
            topologicalOrder[index++] = stack.pop();
        }

        return topologicalOrder;
    }

    private static void performDFS(int vertex, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[vertex] = true;

        // Recursively call all adjacent vertices
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                performDFS(neighbor, visited, stack, adj);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] topoOrder = topologicalSort(V, adj);
        System.out.print("Topological Sort: ");
        for (int node : topoOrder) {
            System.out.print(node + " ");
        }
    }
}
