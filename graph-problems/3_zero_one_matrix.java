// Similar question: (GFG) Distance of nearest cell having 1

import java.util.LinkedList;
import java.util.Queue;

// BFS Approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Enqueue all the 0s and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    // Initialize non-zero cells with max value (infinity)
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                    result[nr][nc] = result[row][col] + 1;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return result;
    }
}

// DP-based

class Solution2 {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // A safe upper bound for initial distance (max possible distance in matrix)
        int MAX_DISTANCE = rows + cols;

        // First Pass: Top-Left to Bottom-Right
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) continue; // Already at distance 0 to a zero

                int minDistance = MAX_DISTANCE;

                // Check top neighbor
                if (row > 0) minDistance = Math.min(minDistance, matrix[row - 1][col]);

                // Check left neighbor
                if (col > 0) minDistance = Math.min(minDistance, matrix[row][col - 1]);

                matrix[row][col] = minDistance + 1;
            }
        }

        // Second Pass: Bottom-Right to Top-Left
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == 0) continue; // Already at distance 0 to a zero

                int minDistance = matrix[row][col];

                // Check bottom neighbor
                if (row < rows - 1) {
                    minDistance = Math.min(minDistance, matrix[row + 1][col] + 1);
                }

                // Check right neighbor
                if (col < cols - 1) {
                    minDistance = Math.min(minDistance, matrix[row][col + 1] + 1);
                }

                matrix[row][col] = minDistance;
            }
        }

        return matrix;
    }
}
