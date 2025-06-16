import java.util.LinkedList;
import java.util.Queue;

// Approach: using DFS and recursive
// complexity : O(n) | O(n)

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                computeDFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void computeDFS(int index, int[][] isConnected, boolean[] visited){
        visited[index] = true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
            if(isConnected[index][neighbor] == 1 && !visited[neighbor]){
                computeDFS(neighbor, isConnected, visited);
            }
        }
    }
}

// Approach: using BFS and itterative
// complexity : O(n) | O(n)

class Solution2{
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                computeBFS(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void computeBFS(int start, int[][] isConnected, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        // initially putting the value in the queue and marking as visited
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor=0; neighbor < isConnected.length; neighbor++){
                if(isConnected[node][neighbor] == 1 && !visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}