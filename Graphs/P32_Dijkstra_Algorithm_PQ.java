package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static int[] dijkstra(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0; // initializing the source to 0

        // priority queue to store the vertices
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
        priorityQueue.add(new int[]{source, 0});

        // process the graph
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentDistance > distances[currentNode]) continue;

            // traverse the adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adj.get(currentNode)) {
                int adjacentNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                if (distances[currentNode] + edgeWeight < distances[adjacentNode]) {
                    distances[adjacentNode] = distances[currentNode] + edgeWeight;
                    priorityQueue.add(new int[]{adjacentNode, distances[adjacentNode]});
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        int vertices = 5;
        int source = 0;

        // initial configuration of adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // adding edges to graph - (source, toOtherNode, distance)
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 4)));

        // running the algorithm
        int[] distances = dijkstra(vertices, adj, source);

        // Printing the shortest distances from the source vertex
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t " + distances[i]);
        }
    }
}
