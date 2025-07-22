import java.util.*;

// Approach: using the Two pointer approach
// TC: O(n)
// SC: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int writeIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}

// Approach: using set
// TC: O(n) + O(n) + O(n) = O(3n)
// SC: O(S), S is the set size
class Solution2 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        // Adding all the numbers in the set
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        for (int val : set) {
            nums[index++] = val;
        }
        return set.size();
    }
}