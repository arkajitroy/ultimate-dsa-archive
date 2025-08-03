import java.util.*;

// Approach: using sliding window approach
// Complexity: O(n) | O(n)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // Shrink the window if any element exceeds frequency k
            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

// Approach: using hashmap + sliding window approach
// Complexity: O(n^2) | O(n)
class Solution2 {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                if (freq.get(nums[j]) > k) break;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
