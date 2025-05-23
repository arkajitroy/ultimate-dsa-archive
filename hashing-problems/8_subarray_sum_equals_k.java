import java.util.*;

// Brute Force Approach
// complexity: O(n^2) | O(1)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}

// - Revise the approach, how the prefix sum is working?
// HashMap - Prefix sum Approach
// complexity: O(n) | O(n)

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        // map <prefixSum, count>
        Map<Integer, Integer> map = new HashMap<>();
        
        // initializing the map
        map.put(0, 1);

        for(int num : nums){
            prefixSum += num;
            // check if pSum - k exists in the map or not?
            count += map.getOrDefault(prefixSum - k, 0);
            // add prefix sum to the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}