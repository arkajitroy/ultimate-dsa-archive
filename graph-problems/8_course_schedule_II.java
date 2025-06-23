// COURSE SCEHDULE 2

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        // Build graph and in-degree array
        for (int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph[prereq].add(course);
            inDegree[course]++;
        }

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0) queue.offer(i);
        }

        int[] result = new int[numCourses];
        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[completedCourses++] = current;

            for (int neighbor : graph[current]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return completedCourses == numCourses ? result : new int[0];
    }
}

class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            graph[pre[1]].add(pre[0]);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, graph, visited, visiting, stack))
                return new int[0];
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty())
            result[index++] = stack.pop();

        return result;
    }

    private boolean hasCycle(int node, List<Integer>[] graph, boolean[] visited, boolean[] visiting, Stack<Integer> stack) {
        visiting[node] = true;

        for (int neighbor : graph[node]) {
            if (visiting[neighbor]) return true;  // cycle
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, graph, visited, visiting, stack))
                    return true;
            }
        }

        visiting[node] = false;
        visited[node] = true;
        stack.push(node);

        return false;
    }
}
