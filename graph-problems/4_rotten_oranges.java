import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize the queue with all rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c, 0}); // row, col, time
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int timeElapsed = 0;

        // Step 2: BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], time = current[2];
            timeElapsed = Math.max(timeElapsed, time);

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check bounds and if cell contains a fresh orange
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    grid[newRow][newCol] == 1) {

                    // Rot the fresh orange and add it to the queue
                    grid[newRow][newCol] = 2;
                    freshCount--;
                    queue.offer(new int[]{newRow, newCol, time + 1});
                }
            }
        }

        // Step 3: If there are still fresh oranges left, return -1
        return freshCount == 0 ? timeElapsed : -1;
    }
}