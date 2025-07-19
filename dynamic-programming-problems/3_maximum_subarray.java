// Approach: Dynamic Programming
// Complexity: T-O(n) | S-O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int index = 1; index < nums.length; index++) {
            dp[index] = Math.max(nums[index], nums[index] + dp[index - 1]);
            maxSum = Math.max(maxSum, dp[index]);
        }

        return maxSum;
    }
}


// Approach: Kedane's Algorithm
// Complexity : T-O(n) | S-O(1)
class Solution2 {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max_sum = arr[0];
        int curr_sum = arr[0];

        // now looping the array and calculating the current and max sum
        for(int index=1; index<n; index++){
            curr_sum = Math.max(arr[index], curr_sum + arr[index]);
            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }
}
