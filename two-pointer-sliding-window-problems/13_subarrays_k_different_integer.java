import java.util.*;

// Approach: Sliding Window + Hashmap
// Complexity: O(n) | O(k)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return computeAtMostK(nums, k) - computeAtMostK(nums, k-1);
    }

    private int computeAtMostK(int[] nums, int k){
        int left = 0, result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Itterating the array in a window manner
        for(int right=0; right < nums.length; right++){
            int num = nums[right];

            // If Its a new number, then decrease the allowed disctinct count
            if(freqMap.getOrDefault(num, 0) == 0) k--;

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // Shrink window from left if more than k distinct
            while (k < 0) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    k++;
                }
                left++;
            }

            // All subarrays ending at "RIGHT" with valid left give (right - left+1) new subarrays
            result += right - left+1;
        }
        return result;
    }
}

// Approach: using nested loop with set
// Complexity: O(n^2) | O(n)
class Solution2 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i; j<nums.length; j++){
                set.add(nums[j]);
                if(set.size() == k) count++;
                else if(set.size() > k) break;
            }
        }
        return count;
    }
}