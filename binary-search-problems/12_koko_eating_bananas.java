// Optimized Approach: Binary Search
// Time Complexity: O(n * log m) => n : piles.length AND m : max(piles[])
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        // computing the max-value / right : can be done using Math.max
        for(int val : piles){
            right = Math.max(val, right);
        }
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(canEat(piles, h, mid)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean canEat(int[] piles, int hrs, int k){
        int time = 0;
        for(int pile : piles){
            time += Math.ceil((double) pile / k);
        }
        return time <= hrs;
    }
}

// Brute Force Approach: Try all possible eating speeds from 1 to max pile size
// Time Complexity: O(n * max(pile)) => O(n^2) in the worst case
// Space Complexity: O(1)

class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        // Find the largest pile (upper bound of eating speed) - O(n)
        int maxPile = Arrays.stream(piles).max().getAsInt();

        // Try all possible eating speeds from 1 to maxPile - O(max(pileSize))
        for (int k = 1; k <= maxPile; k++) {
            int time = 0;

            for (int pile : piles) {
                // Divide each pile by k and round up to the nearest hour
                // (since you can't eat partial bananas)
                time += Math.ceil((double) pile / k);
            }

            if (time <= h) return k;
        }
        return maxPile;
    }
}
