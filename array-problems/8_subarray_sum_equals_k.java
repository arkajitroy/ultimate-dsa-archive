import java.util.*;

// Approach: Brute Force
// Complexity: T-O(n^2) | S-O(1)

class Solution1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

// Approach: Prefix Sum
// Complexity: T-O(n) | S-O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // Map <prefix_sum, freq>
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize with sum 0 to handle the case when subarray starts from index 0
        map.put(0, 1);

        for (int num : nums) {
            sum += num; // Update the prefix sum
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // Increment count by the number of times (sum - k) has occurred
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Update the frequency of the current prefix sum
        }
        return count;
    }
}

