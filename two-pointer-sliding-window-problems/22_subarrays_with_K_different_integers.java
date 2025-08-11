import java.util.HashMap;
import java.util.Map;


// More Optimal approach: using array instead of map
class SolutionB {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k){
        int left = 0, count = 0, distinctCount = 0;
        int[] freq = new int[nums.length + 1];

        for (int right = 0; right < nums.length; right++) {
            int currentElement = nums[right];
            if (freq[currentElement] == 0) distinctCount++; // new distinct
            freq[currentElement]++;

            // Shrink window if distincts > k
            while (distinctCount > k) {
                int leftElement = nums[left];
                freq[leftElement]--;
                if (freq[leftElement] == 0) distinctCount--;
                left++;
            }

            // Count subarrays ending at 'right'
            count += right - left + 1;
        }
        return count;
    }
}

// Approach: Optimal Approach - using sliding window + map
// Time: O(n) — each element enters & exits the sliding window once.
// Space: O(n) — frequency map for counting distincts.
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k){
        int left = 0, count = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            // Add current element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) k--; // New distinct element

            // Shrink window if distincts > k
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) k++; // Lost a distinct
                left++;
            }

            // Count subarrays ending at 'right'
            count += right - left + 1;
        }
        return count;
    }
}

// Approach: Better approach
// Time: O(n²) — Outer loop picks start, inner loop expands end until too many distincts.
// Space: O(n) — Frequency map for tracking distincts in the current subarray.
class Solution2 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int distinctCount = 0;

            for (int end = start; end < n; end++) {
                // Add current element
                freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
                if (freq.get(nums[end]) == 1) distinctCount++; // new distinct

                // Check if exactly K distinct
                if (distinctCount == k) count++;
                else if (distinctCount > k) break; // No point expanding further
            }
        }

        return count;
    }
}
