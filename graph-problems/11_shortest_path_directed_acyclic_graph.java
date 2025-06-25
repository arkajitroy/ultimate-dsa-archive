import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Shortest Path in Undirected Graph

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // initializing the distance array with infinite

        // creating a queue and assigning the initial variable with 0
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.offer(src);

        // doing bfs
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int vertices : adj.get(node)){
                if(dist[vertices] > dist[node] + 1){
                    dist[vertices] = dist[node] + 1;
                    queue.offer(vertices);
                }
            }
        }
        return dist;
    }
}
