// Maximum Subarray

/*

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

*/

// Approach: Dynamic Programming
// Complexity: T-O(n) | S-O(n)

class Solution_DP {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}


// Approach: Kedane's Algorithm
// Complexity : T-O(n) | S-O(1)

class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max_sum = arr[0];
        int curr_sum = arr[0];

        // now looping the array and calculating the current and max sum
        for(int i=1; i<n; i++){
            curr_sum = Math.max(arr[i], curr_sum + arr[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }
}
