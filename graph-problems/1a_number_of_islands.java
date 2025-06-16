// Approach: using DFS and recursive
// complexity: O(n) | O(n)

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int count = 0, rows = grid.length, cols = grid[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    computeDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void computeDFS(char[][] grid, int row, int col){
        int rows = grid.length, cols = grid[0].length;

        if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') return;

        grid[row][col] = '0';

        computeDFS(grid, rows+1, cols);
        computeDFS(grid, rows-1, cols);
        computeDFS(grid, rows, cols+1);
        computeDFS(grid, rows, cols-1);
    }
}

// Approach: using BFS and itterative
// complexity: O(n) | O(n)

class Solution2 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int count = 0, rows = grid.length, cols = grid[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    computeBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void computeBFS(char[][] grid, int startRow, int startCol){
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{ startRow, startCol });
        grid[startRow][startCol] = '0';

        // direction matrix
        int[][] directions = {{-1,0}, {1, 0}, {0,-1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1'){
                    queue.offer(new int[]{ newRow, newCol });
                    grid[newRow][newCol] = '0';
                }
            }
        }

    }
}