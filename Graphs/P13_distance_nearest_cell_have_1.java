package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Main{

    public static int[][] updateMatrix(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Storing all the initials in the visited-array
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(matrix[row][col] == 0) queue.add(new int[]{row, col});
                else dist[row][col] = Integer.MAX_VALUE; // infinite
            }
        }

        // initial config for bfs
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS Traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for(int[] dir : directions){
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (dist[nr][nc] > dist[row][col] + 1) {
                        dist[nr][nc] = dist[row][col] + 1;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }

        return dist;
    }

    public static void printMatrix(int[][] result){
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        System.out.println("Base Matrix");
        printMatrix(mat);
        int[][] result = updateMatrix(mat);

        System.out.println("\nResultant Matrix");
        printMatrix(result);
    }
}