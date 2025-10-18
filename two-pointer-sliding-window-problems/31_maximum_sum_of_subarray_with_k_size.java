// Approach-1 : using sliding window
// Complexity: O(n) | O(1)

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        // calculate sum of first window
        for(int i=0; i<k; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // remove left, add new right
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}


// Approach 2: Brute Force
// Complexity: O(n * k) | O(1)

class Solution2 {
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;

        // check all subarray of size k
        for(int i=0; i<=arr.length; i++){
            int windowSum = 0;
            for(int j=i; j<i+k; j++){
                windowSum += arr[j];
            }
            // comparing and updating the windowSum and maxSum
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}