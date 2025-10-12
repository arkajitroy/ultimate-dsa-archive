import java.util.Arrays;

// Optimal Approach - Greedy algorithm
// complexity: O(n) | O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]; // take every upward profit
            }
        }
        return profit;
    }
}

// Better Approach: using DP
// Complexity: O(n) | O(n)
class Solution2 {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2]; // [day][buy/sell]
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(prices, 0, 1); // 1 means we can buy
    }

    private int solve(int[] prices, int i, int canBuy) {
        if (i >= prices.length) return 0;
        if (dp[i][canBuy] != -1) return dp[i][canBuy];
        
        if (canBuy == 1) {
            int buy = -prices[i] + solve(prices, i + 1, 0);
            int skip = solve(prices, i + 1, 1);
            return dp[i][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(prices, i + 1, 1);
            int skip = solve(prices, i + 1, 0);
            return dp[i][canBuy] = Math.max(sell, skip);
        }
    }
}

// Brute Force Approach
// Complexity: O(2^n) | O(1)
class Solution3 {
    public int maxProfit(int[] stockPrices) {
        return getMaxProfit(stockPrices, 0, true);
    }

    private int getMaxProfit(int[] stockPrices, int dayIndex, boolean canBuy) {
        if (dayIndex >= stockPrices.length) return 0;

        if (canBuy) {
            // Option 1: Buy at this day (subtract cost)
            int buyToday = -stockPrices[dayIndex] + getMaxProfit(stockPrices, dayIndex + 1, false);
            // Option 2: Skip this day
            int skipToday = getMaxProfit(stockPrices, dayIndex + 1, true);
            return Math.max(buyToday, skipToday);
        } else {
            // Option 1: Sell at this day (add profit)
            int sellToday = stockPrices[dayIndex] + getMaxProfit(stockPrices, dayIndex + 1, true);
            // Option 2: Skip this day
            int skipToday = getMaxProfit(stockPrices, dayIndex + 1, false);
            return Math.max(sellToday, skipToday);
        }
    }
}