// Variable size sliding window problem, as we will traverse the array it need to be modified as per requirment

// Approach: using the sliding window
// TC: O(n)
// SC: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0, sum = 0;

        for (int end = 0; end < n; end++) {
            // computing the current sum and increase the window
            sum += nums[end];

            // Trying to reduce the window size after calculating
            while (sum >= target) {
                int currentWindowSize = end - start;
                // update the minimum length of window
                minLength = Math.min(minLength, currentWindowSize+1);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

// Approach: using Binary Search with Prefix sum
// TC: 0(n log n)
// SC: O(1)
class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int[] prefixSum = new int[n+1];

        // 1. Computing the prefix sum : 0 -> n-1 ===> O(n)
        for(int i=0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // 2. Itterating through all the possible starting points
        for(int j=0; j<=n; j++){
            // condtion will be like this prefixSums[j] >= target + prefixSums[i]
            int targetSum = target + prefixSum[j];

            // 3. Perform Binary Search for the smallest index in prefix sum
            int low = j+1, high = n;
            int smallestIndex = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if(prefixSum[mid] >= targetSum){
                    smallestIndex = mid;
                    high = mid-1; // try to find smallest
                }
                else{
                    low = mid + 1;
                }
            }
            // if the smallest index was found update the length
            if(smallestIndex != -1) minLength = Math.min(minLength, smallestIndex-j);
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}

// Approach: Brute Force
// TC: O(n^2)
// SC: O(1)
class Solution2 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // No need to check longer subarrays
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
