// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/


class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }       
        return count <= 1;        
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

