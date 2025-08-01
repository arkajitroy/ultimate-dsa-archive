// Optimal Approach
// Complexity: O(O(n log(max bloomDay)) | O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        long total = (long) m * k;
        if (total > n) return -1; // Not enough flowers

        int left = 1;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                answer = mid; // try to minimize
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}


// Brute force approach
// Complexity: O((maxDay - minDay) * n) | O(1)
class Solution2 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long total = (long) m * k;

        if (total > n) return -1; // Not enough flowers in total

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // First we need to know the upper and lower range
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        // Now we will loop into the specific range and search
        for (int currentDay = min; currentDay <= max; currentDay++) {
            if (canMake(bloomDay, m, k, currentDay)) {
                return currentDay;
            }
        }
        return -1; // Not possible at any day
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
