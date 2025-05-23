// https://leetcode.com/problems/move-zeroes/description/

// Approach: using extra space
// Complexity: O(3n) time and O(n) space

import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> nonZeroList = new ArrayList<>();

        // Collecting all the non-zero elements
        for(int num : nums){
            if(num != 0) nonZeroList.add(num);
        }

        // adding zeroes to the list
        while(nonZeroList.size() < nums.length){
            nonZeroList.add(0);
        }

        // copying to the original array
        for(int i = 0; i < nums.length; i++){
            nums[i] = nonZeroList.get(i);
        }
    }
}

// Approach: Two Pointers
// Complexity: O(n) time and O(1) space

class Solution2 {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0; // Index of last non-zero element found

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i]; // Move non-zero element to the front
            }
        }
        // Fill the remaining positions with zeros
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
