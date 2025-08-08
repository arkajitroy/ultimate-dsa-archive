import java.util.Arrays;

// Better : DP - Bottom up
// Complexity: O(n x amount) | O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // large initial value
        dp[0] = 0;

        // Build up solutions for all amounts
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// Better : Memoize the recusive approach
// Complexity: O(n x amount) time, O(amount) recursion space.
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount+1];
        return memoize(coins, amount, memo);
    }

    private int memoize(int[] coins, int rem, int[] memo){
        if(rem < 0) return -1; // invalid path
        if(rem == 0) return 0; // no coins needed
        if(memo[rem] != rem+1) return memo[rem];

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int result = memoize(coins, rem-coin, memo);
            if(result >= 0) min = Math.min(min, result+1);
        }
        memo[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem];
    }
}

// BF Approach: recursive
// Complexity: O(n^amount) time, O(amount) recursion space.
class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int ans = helper(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int helper(int[] coins, int rem){
        if(rem < 0) return Integer.MAX_VALUE; // invalid path
        if(rem == 0) return 0; // no coins needed

        int min = Integer.MAX_VALUE;
        // itterating over the coin choices
        for(int coin : coins){
            int result = helper(coins, rem-coin);
            // if the computed result is lesser than min then update
            if(result != Integer.MAX_VALUE){
                min = Math.min(min, result+1);
            }
        }
        return min;
    }
}

