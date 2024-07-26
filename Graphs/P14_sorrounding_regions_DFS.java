package Graphs;

import java.util.Arrays;

class Main {
    // Main function to solve the problem
    private static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length, cols = board[0].length;

        // Perform DFS from 'O's on the border
        for (int i = 0; i < rows; i++) {
            // Check first and last columns
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            // Check first and last rows
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        // Flip all 'O' to 'X' and temporary markers 'T' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    // Helper function to perform DFS
    private static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;

        // Mark current 'O' as a temporary marker 'T'
        board[x][y] = 'T';

        // Perform DFS in all four directions
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
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
