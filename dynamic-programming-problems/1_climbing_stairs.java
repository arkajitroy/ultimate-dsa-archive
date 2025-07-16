// Approach: DP - Top down
// Complexity: O(n) | O(n)
class Solution3 {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return computeDP(n, memo);
    }
    private static int computeDP(int n, int[] memo){
        if(n <= 1) return 1;
        if(memo[n] != 0) return memo[n];
        
        // analyze the stair count
        memo[n] = computeDP(n-1, memo) + computeDP(n-2, memo);

        return memo[n];
    }
}


// Approach: DP - Bottom up
// Complexity: O(n) | O(n)
class Solution2 {
    public int climbStairs(int n) {
        if(n <= 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        // check uptill n starting from 2nd index
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

// Efficient Approach DP - space efficient - bottom up
// Complexity: O(n) | O(1)
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;

        int a = 1;
        int b = 1;

        // check uptill n starting from 2nd index
        for(int i=2; i<=n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
