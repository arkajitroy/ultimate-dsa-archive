// Basically it is similar to the maximum sum of subarray of k

import java.util.HashSet;
import java.util.Set;

// Approach: Two pointer approach
// Complexity: O(n) | O(k)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        long maxSum = 0, currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (window.contains(nums[right])) {
                window.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            window.add(nums[right]);
            currentSum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // shrink window
                currentSum -= nums[left];
                window.remove(nums[left]);
                left++;
            }
        }
        return maxSum;
    }
}
// Approach: brute force nested loop
// Complexity: O(n * k) | O(k)
class Solution2 {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;

        for(int i=0; i<=nums.length-k; i++){
            Set<Integer> set = new HashSet<>();
            long sum = 0;
            boolean isValid = true;

            for (int j = i; j < i + k; j++) {
                if (set.contains(nums[j])) {
                    isValid = false;
                    break;
                }
                set.add(nums[j]);
                sum += nums[j];
            }
            if (isValid) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}