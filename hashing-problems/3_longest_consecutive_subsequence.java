import java.util.*;

// Approahc: Hashing
// complexity: O(n) | O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();

        // add all numbers to the set
        for(int num : nums){
            numSet.add(num);
        }

        int longest = 0;

        for(int num : numSet){
            if(!numSet.contains(num - 1)){ // <---- check if this is the start of sequence
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) { // <-- check for next number
                    currentNum++;
                    currentLength++;                    
                }
                longest = Math.max(currentLength, longest);
            }
        }
        return longest;
    }
}

// Apprach: Better Approach – Sort First
// complexity: O(n log n) | O(1)

class Solution2 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);

        int longest = 1;
        int currentLength = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            // if the current number is not consecutive
            if(nums[i] == nums[i-1] + 1) currentLength++;
            else{
                longest = Math.max(longest, currentLength);
                currentLength = 1; // reset
            }
        }
        return Math.max(longest, currentLength);
    }
}

// Approach: Brute Force
// complexity: O(n^2) | O(1)

class Solution3 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int longest = 0;

        for (int num : nums) {
            int current = num;
            int length = 1;

            // Check if this is the start of a sequence
            boolean isStart = true;
            for (int n : nums) {
                if (n == num - 1) {
                    isStart = false;
                    break;
                }
            }

            if (!isStart) continue;

            while (true) {
                boolean found = false;
                for (int n : nums) {
                    if (n == current + 1) {
                        current++;
                        length++;
                        found = true;
                        break;
                    }
                }
                if (!found) break;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}