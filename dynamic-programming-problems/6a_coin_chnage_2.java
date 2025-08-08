
// Approach: Optimal (1D Bottom-Up DP)
// Complexity: O(n × amount) time | O(amount).
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // One way to make amount 0 (choose nothing)

        for (int coin : coins) {
            for (int index = coin; index <= amount; index++) {
                dp[index] += dp[index - coin];
            }
        }
        return dp[amount];
    }
}

// Better Approach: (Memoized Recursion)
// Complexity: O(n × amount) | O(n × amount).
class Solution2 {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        return memoize(coins, 0, amount, memo);
    }

    private int memoize(int[] coins, int index, int remaining, int[][] memo){
        if(remaining == 0) return 1;
        if(index == coins.length || remaining < 0) return 0; // invalid
        if (memo[index][remaining] != -1) return memo[index][remaining];

        int take = memoize(coins, index, remaining - coins[index], memo);
        int skip = memoize(coins, index+1, remaining, memo);

        // storing the memoized value
        memo[index][remaining] = take + skip;

        return memo[index][remaining];
    }
}

// BF Approach: using nested loop - recursive DFS
// Complexity: O(2^(n×amount)) | O(amount) recursion space.
class Solution3 {
    public int change(int amount, int[] coins) {
        return computeDFS(coins, 0, amount);
    }

    private int computeDFS(int[] coins, int index, int remaining){
        if(remaining == 0) return 1;
        if(index == coins.length || remaining < 0) return 0; // invalid

        // OP1: take the current coin (stay at index)
        int take = computeDFS(coins, index, remaining - coins[index]);
        // OP2: Skip the current coin (move to next index)
        int skip = computeDFS(coins, index+1, remaining);

        return take+skip;
    }
}