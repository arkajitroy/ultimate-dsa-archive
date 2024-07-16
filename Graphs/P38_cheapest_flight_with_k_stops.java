package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Main {

    static class Flight {
        int destination;
        int cost;
        int stops;

        Flight(int dest, int cost, int stops) {
            this.destination = dest;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int cities, int[][] flights, int src, int dst, int K){
        int[] cost = new int[cities];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int i=0; i<=K; i++){
            int[] temp = Arrays.copyOf(cost, cities);
            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if(cost[u] != Integer.MAX_VALUE) temp[v] = Math.min(temp[v], cost[u]+w);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    // DJikstras with Priority Queue
    public static int findCheapestPrice_DJ(int cities, int[][] flights, int src, int dst, int K){
        Map<Integer, List<Flight>> graph = new HashMap<>();
        for(int[] flight : flights){
            graph.computeIfAbsent(flight[0], (k) -> 
                new ArrayList<>()
            ).add(new Flight(flight[1], flight[2], 0));
        }

        PriorityQueue<Flight> PQ = new PriorityQueue<>(
            Comparator.comparing((f) -> f.cost)
        );
        PQ.add(new Flight(src, 0, 0));

        while (!PQ.isEmpty()) {
            Flight current = PQ.poll();
            if(current.destination == dst) return current.cost;
            if(current.stops > K) continue;

            for(Flight next : graph.getOrDefault(current.destination, new ArrayList<>())){
                PQ.add(new Flight(next.destination, current.cost + next.cost, current.stops + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0;
        int dst = 2;
        int K = 1;
        int result = findCheapestPrice(n, flights, src, dst, K);
        System.out.println("Cheapest Price: " + result); // Output: 200
    }
}
