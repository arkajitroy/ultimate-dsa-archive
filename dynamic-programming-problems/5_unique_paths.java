import java.util.*;

// OP Approach: using combinatorics - using Maths
// Complexity: O(m) | O(1)
class Solution {
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int movesDown = m - 1;
        long result = 1;
        
        // Calculate C(totalMoves, movesDown)
        for (int i = 1; i <= movesDown; i++) {
            result = result * (totalMoves - movesDown + i) / i;
        }
        return (int) result;
    }
}

// Approach: Space optimized DP - recommend
// Complexity: O(mxn) | O(n)
class Solution2_2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // Initialize dp array with 1s for the first row
        Arrays.fill(dp, 1);

        // Calculate the number of ways for each cell in the grid
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}

// Approach: using the 2D DP table
// Complexity: O(mxn) | O(mxn)
class Solution2_1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill first row and column with 1 (only 1 way to reach)
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

// BF Approach: using DFS
// Complexity: O(2^(m+n)) time, O(m+n) space (recursion stack).
class Solution3{
    public int uniquePaths(int m, int n) {
        return computeDFS(0, 0, m, n);
    }
    private int computeDFS(int i, int j, int row, int col){
        // index out of bound
        if(i >= row || j >= col) return 0;
        // Reached destination
        if(i == row-1 && j == col-1) return 1;
        // Move pointer : down + right
        return computeDFS(i+1, j, row, col) + computeDFS(i, j+1, row, col);
    }
}