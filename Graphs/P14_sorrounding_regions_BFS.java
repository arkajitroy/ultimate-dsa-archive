package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void solve(char[][] board){
        if(board == null || board.length == 0) return;

        int rows = board.length, cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

         // Perform DFS from 'O's on the border
        for (int i = 0; i < rows; i++) {
            // Check first and last columns
            if (board[i][0] == 'O') bfs(board, i, 0, queue);
            if (board[i][cols - 1] == 'O') bfs(board, i, cols - 1, queue);
        }
        for (int j = 0; j < cols; j++) {
            // Check first and last rows
            if (board[0][j] == 'O') bfs(board, 0, j, queue);
            if (board[rows - 1][j] == 'O') bfs(board, rows - 1, j, queue);
        }

        // Flip all 'O' to 'X' and temporary markers 'T' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private static void bfs(char[][] board, int x, int y, Queue<int[]> queue){
        int rows = board.length, cols = board[0].length;
        queue.offer(new int[]{x,y});
        board[x][y] = 'S';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int[] dir : directions){
                int nX = point[0] + dir[0];
                int nY = point[1] + dir[1];
                if (nX >= 0 && nX < rows && nY >= 0 && nY < cols && board[nX][nY] == 'O') {
                    queue.offer(new int[]{nX, nY});
                    board[nX][nY] = 'S';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);

        // Print the modified board
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
