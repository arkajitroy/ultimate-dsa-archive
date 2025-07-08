import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: prefix sum 0 at index -1

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as +1
            sum += (nums[i] == 0) ? -1 : 1;

            // If this sum has been seen before
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(sum, i); // Store first occurrence of this sum
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 1, 1, 0, 0};

        System.out.println("Max length of subarray with equal 0s and 1s: " + sol.findMaxLength(nums));
    }
}
