// COURSE SCHEDULE 1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Approach-1: Topological Sort

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // inDegree[i] represents the number of prerequisites for course i
        int[] inDegree = new int[numCourses];
        // adjacency list to represent the course dependency graph
        List<List<Integer>> graph = new ArrayList<>();

        // Initialize the graph with empty lists for each course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and populate inDegree array
        // For each prerequisite pair [a, b], we add an edge from b to a (b → a),
        // and increment the inDegree of course 'a' by 1
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course); // b -> a
            inDegree[course]++;
        }

        // Add all courses with no prerequisites (inDegree 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int completedCourses = 0;

        // Process the queue using BFS (Kahn's Algorithm)
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // For each course dependent on the current one, reduce its inDegree
            for (int next : graph.get(course)) {
                inDegree[next]--;
                // If inDegree becomes 0, it means all prerequisites are satisfied
                queue.offer(next);
            }
        }

        // If we've completed all courses, return true; else there's a cycle
        return completedCourses == numCourses;
    }
}

// Approach: DFS - Recursive

class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] visited){
        if(visited[node] == 1) return false;
        if(visited[node] == 2) return true;

        visited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(!dfsCheck(neighbor, adj, visited)) return false;
        }
        visited[node] = 2;
        return true;
    }
}