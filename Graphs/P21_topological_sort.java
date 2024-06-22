package Graphs;

import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        int[] topologicalOrder = new int[V];

        // performing DFS from each vertex
        for(int node=0; node<V; node++){
            if(!visited[node]) dfsCheck(node, visited, stack, adj);
        }
        int index = 0;
        while (!stack.isEmpty()) {
            topologicalOrder[index++] = stack.pop();
        }

        return topologicalOrder;
    }

    private static void dfsCheck(int V, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        visited[V] = true;

        // recursively call all the adjacent vertices
        for(int neighbor : adj.get(V)){
            if(!visited[neighbor]) dfsCheck(neighbor, visited, stack, adj);
        }
        stack.push(V);
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
