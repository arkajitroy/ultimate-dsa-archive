// Max Sum Subarray of size K

// Approach: Two pointer
// Complexity: O(n) | O(1)
class Solution {
    public int maximumSumSubarray(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[i - k + 1]; // remove leftmost element
            }
        }
        return (int) maxSum;
    }
}