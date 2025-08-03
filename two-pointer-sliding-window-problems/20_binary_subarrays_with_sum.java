import java.util.*;

// Approach: using sliding window and prefix sum
// Complexity: O(n) | O(1)

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink the window if the sum exceeds the goal
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // Add the number of subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}

// Better Approach: using hashmap - similar to prefix sum / binary subarray sum problem
// Complexity: O(n) | O(n)
class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int currentSum = 0, result = 0;

        countMap.put(0, 1); // Initializing with sum 0

        // Itterating through the array
        for(int num : nums){
            currentSum += num;
            int targetSum = currentSum - goal;
            // if the target sum exists in the map, add its count to result
            if(countMap.containsKey(targetSum)){
                result += countMap.get(targetSum);
            }
            // Updating the count map with the current sum
            countMap.put(currentSum, countMap.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}