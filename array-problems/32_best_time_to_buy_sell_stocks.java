// - Recomended Approach: Greedy
// complexity : O(n) | O(1)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int minPrice = prices[0], profit = 0, cost = 0;

        // Itterating the prices array - starting from 2nd index
        for(int idx = 1; idx < prices.length; idx++){
            minPrice = Math.min(minPrice, prices[idx]);
            cost = prices[idx] - minPrice;
            profit = Math.max(profit, cost);
        }

        return profit;
    }
}

// - More Optimized Greedy Solution

class Solution1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for(int price : prices){
            if(price < minPrice) minPrice = price;
            else maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}

// ! Other Approach: Dynamic Programming
// complexity : O(n) | O(n)

class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int cost=0, n = prices.length;
        int[] minPrice = new int[n], profit = new int[n];

        // assigning initial values
        minPrice[0] = prices[0];
        profit[0] = 0;

        // Itterating the prices array - starting from 2nd index
        for(int i = 1; i < prices.length; i++){
            minPrice[i] = Math.min(minPrice[i-1], prices[i]);
            cost = prices[i] - minPrice[i-1];
            profit[i] = Math.max(profit[i-1], cost);

        }

        return profit[n-1];
    }
}