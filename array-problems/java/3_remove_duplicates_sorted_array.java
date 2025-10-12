// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Approach 1: HashSet
// Complexity : O(3n) | O(n)

import java.util.HashSet;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        // adding all elements to set
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        int idx = 0;

        // adding elements to array
        for(int num : set){
            nums[idx++] = num;
        }

        // filling the rest of the array with 0
        for(int i=idx; i<n; i++){
            nums[i] = 0;
        }
        
        return idx;
    }
}

// Approach 2: Two Pointers
// Complexity : O(n) | O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int dupIndex = 0, n = nums.length;

        for(int i=1; i<n; i++){
            if(nums[dupIndex] != nums[i]){
                dupIndex++;
                nums[dupIndex] = nums[i];
            }
        }
        return dupIndex + 1;
    }
}