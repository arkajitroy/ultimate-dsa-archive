package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int findCircleNum(int[][] provinces){
        boolean[] visited = new boolean[provinces.length];
        int provinceCount = 0;

        for(int i=0; i<provinces.length; i++){
            if(!visited[i]){
                bfs(provinces, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private static void bfs(int[][] provinces, boolean[] visited, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int i=0; i<provinces.length; i++){
                if(provinces[node][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] provinces = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = findCircleNum(provinces);
        System.out.println("Number of provinces: " + result);
    }
}
