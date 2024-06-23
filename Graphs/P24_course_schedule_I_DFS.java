package Graphs;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pair : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }
        for(int node=0; node<numCourses; node++){
            if(!dfsCheck(node, adj, visited)) return false;
        }
        return true;
    }

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited){
        if(visited[node] == 1) return false;
        if(visited[node] == 2) return true;

        visited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(!dfsCheck(neighbor, adj, visited)) return false;
        }
        visited[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        
        // Using DFS approach
        boolean canFinishDFS = canFinish(numCourses, prerequisites);
        System.out.println("Can we schedule the course - DFS: " + canFinishDFS);
    }
}
