import java.util.Arrays;

/*
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
*/

// Approach:  Optimal Approach: Bottom-Up Dynamic Programming (In-place)
// Complexity: O(n^2) | O(1)

class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int leftDiagonal = j > 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = j < n - 1 ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;

                matrix[i][j] += Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Result is min of the first row
        int min = Integer.MAX_VALUE;
        for (int val : matrix[0]) {
            min = Math.min(min, val);
        }

        return min;
    }
}

// Approach 2: Top-Down Recursive DP (Memoization)
// Complexity: O(RC) | O(RC) --> RC = row x col = n^2

class Solution2 {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, computeDFS(matrix, 0, j, memo));
        }

        return min;
    }

    private static int computeDFS(int[][] matrix, int row, int col, int[][] memo){
        int n = matrix.length;

        // edge case
        if(col<0 || col >= n) return Integer.MAX_VALUE;

        // base case
        if(row == n-1) return matrix[row][col];
        if(memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        int down = computeDFS(matrix, row+1, col, memo);
        int down_left = computeDFS(matrix, row+1, col-1, memo);
        int down_right = computeDFS(matrix, row+1, col+1, memo);

        memo[row][col] = matrix[row][col] + Math.min(down, Math.min(down_left, down_right));

        return memo[row][col];
    }
}