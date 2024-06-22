package Graphs;

import java.util.ArrayList;

class Main {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        // initial visited and recursiveStack arrays
        boolean[] visited = new boolean[V];
        boolean[] recursiveStack = new boolean[V];
        
        // perform dfs from each vertex
        for(int index = 0; index<V; index++){
            if(cycleDFSCheck(index, visited, recursiveStack, adj)) return true;
        }

        return false;
    }

    private static boolean cycleDFSCheck(int vertex, boolean[] visited, boolean[] recursiveStack, ArrayList<ArrayList<Integer>> adj){
        // if node is found in both visited and recStack, cycle is detected
        if(recursiveStack[vertex]) return true;

        // if node is already visited, no need to explore
        if(visited[vertex]) return false;

        // marking the current-node as visited + add to recursion stack
        visited[vertex] = true;
        recursiveStack[vertex] = true;

        // recursively call the adjacent vertext
        for(int neighbor : adj.get(vertex)){
            if(cycleDFSCheck(neighbor, visited, recursiveStack, adj)) return true;
        }

        // remove the vertex from the recursive-stack
        recursiveStack[vertex] = false;
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        // Create a GraphCycleDetection object
        
        boolean hasCycle = isCyclic(V, adj);
        System.out.println("Graph has cycle: " + hasCycle);
    }
}
