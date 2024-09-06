class P22_Coin_Change {
    // Approach 01: Using 1D Array - O(n * amount) | O(amount)
    public static int change_better(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    // Approach 02: Using 2D Array - O(n * amount) | O(amount)
    public static int change(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }

        for(int i=1; i<= n; i++){
            for(int j=1; j<= amount; j++){
                if(j >= coins[i-1]) dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int result = change(amount, coins);
        System.out.println("Number of combinations: " + result);
    }    
}
