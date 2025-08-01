import java.util.*;

// Approach : Most optimal one
class SolutionOptimal {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];  // assuming nums[i] in 0..100
        int maxFreq = 0;
        int total = 0;

        for (int num : nums) {
            freq[num]++;
            // check for the freq
            if (freq[num] > maxFreq) {
                maxFreq = freq[num];
                total = freq[num];
            } else if (freq[num] == maxFreq) {
                total += freq[num];
            }
        }
        return total;
    }
}

// Approach: using the nested loop - double pass
// Complexity: O(n + n + n) = O(3n) | O(n)
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the max frequency
        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 3: Count how many elements have that frequency
        int total = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                total += freq;
            }
        }

        return total;
    }
}

// When the range is small use the array approach - check the constraints first
class Solution1 {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFreq = 0;

        // Count frequency
        for (int num : nums) {
            count[num]++;
            maxFreq = Math.max(maxFreq, count[num]);
        }

        // Count how many elements have max frequency
        int total = 0;
        for (int freq : count) {
            if (freq == maxFreq) {
                total += freq;
            }
        }
        return total;
    }
}

// Approach: using the nested loop
// Complexity: O(n^2) | O(1)
class Solution2 {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int freq = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    freq++;
                }
            }

            if (freq > maxFreq) {
                maxFreq = freq;
                total = freq;
            } else if (freq == maxFreq) {
                total += freq;
            }
        }

        return total / maxFreq * maxFreq;
    }
}
