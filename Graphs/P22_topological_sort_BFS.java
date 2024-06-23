package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological Sort : Kahn's Algorithm / BFS

class Main {
    public static int[] topologicalSort (int numVertices, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[numVertices];
        int[] topologicalOrder = new int[numVertices];

        // calculating in-degrees of all vertices
        for(int i=0; i<numVertices; i++){
            for(int neighbor : adj.get(i)){
                inDegree[neighbor]++;
            }
        }

        // storing the vertices into the queue
        Queue<Integer> vertices = new LinkedList<>();

        // taking all the vertices out from queue
        for(int i=0; i<numVertices; i++){
            if(inDegree[i] == 0) vertices.offer(i);
        }

        int index = 0;

        // processing the verrtices
        while (!vertices.isEmpty()) {
            int currentVertex = vertices.poll();
            topologicalOrder[index++] = currentVertex;

            // reducing the indegree
            for(int neighbor : adj.get(currentVertex)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) vertices.offer(neighbor);
            }
        }

        // checking for the cyclic pattern
        if(index != numVertices) throw new IllegalStateException("Graph contains a cycle therefor Topological sort is not possible!");

        return topologicalOrder;
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
