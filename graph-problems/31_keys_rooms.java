import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Approach : using the DFS approach
// complexity: O(N + E) | O(S + V) { S : stack size , V : visited array size }

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        computeDFS(0, rooms, visited);

        // now searching for the locked room
        for(boolean unlocked : visited){
            if(!unlocked) return false;
        }

        return true;
    }

    private void computeDFS(int room, List<List<Integer>> rooms, boolean[] visited){
        visited[room] = true;
        for(int key : rooms.get(room)){
            if(!visited[key]) computeDFS(key, rooms, visited);
        }
    }
}

// Approach: using the BFS approach
// complexity: O(N + E) | O(Q + V) { S : queue size , V : visited array size }

class Solution2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();

        computeBFS(0, queue, rooms, visited);

        // now searching for the locked room
        for(boolean unlocked : visited){
            if(!unlocked) return false;
        }

        return true;
    }

    private void computeBFS(int room, Queue<Integer> roomsQ, List<List<Integer>> rooms, boolean[] visited){
        roomsQ.add(room); // initially adding the first room
        visited[room] = true;

        while (!roomsQ.isEmpty()) {
            int roomInstance = roomsQ.poll();
            for(int key : rooms.get(roomInstance)){
                if(!visited[key]){
                    visited[key] = true;
                    roomsQ.add(key);
                }
            }
        }
    }
}