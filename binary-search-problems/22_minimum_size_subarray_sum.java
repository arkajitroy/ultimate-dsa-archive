import java.util.Arrays;

// Better Approach: Sliding window / Two Pointers
// Complexity: O(n) | O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

// Better Approach: Binary Search + Prefix Sum
// Complexity: O(n log n) | O(1)
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];

        // assigning prefix sum
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int toFind = target + prefix[i];
            int bound = Arrays.binarySearch(prefix, toFind);
            // Finding the intersection point
            if(bound < 0) bound = bound-1;
            if(bound <= n) result = Math.min(result, bound-i);
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

// Brute Force Approach: using nested loop
// Complexity: O(n^2) | O(1)
class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break; // no need to extend further for this i
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}