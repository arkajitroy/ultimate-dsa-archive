import java.util.Arrays;

// Binary search approach
// Time complexity: O(n log n + n log(max distance))
// Space complexity: O(1)

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Step 1: Sort stall positions
        
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;       // try for larger distance
                low = mid + 1;
            } else {
                high = mid - 1;     // try for smaller distance
            }
        }
        return result;
    }

    // Check if we can place k cows with at least 'distance' between them
    private boolean canPlaceCows(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];

                if (count == k) return true;
            }
        }

        return false;
    }
}