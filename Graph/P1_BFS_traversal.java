package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V){
        // Initial configuration for the traversal
        ArrayList<Integer> traversal = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Starting from vertex 0 and initially marking as 1
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            traversal.add(currentVertex);

            // iterating through all the adjacency vertex
            for(int adjacencyVertex : adj.get(currentVertex)){
                if(!visited[adjacencyVertex]){
                    visited[adjacencyVertex] = true;
                    queue.add(adjacencyVertex);
                }
            }
        }
        return traversal;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 4;

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        ArrayList<Integer> result = bfs(adj, V);
        System.out.println("BFS Traversal: "+ result);
    }
}
