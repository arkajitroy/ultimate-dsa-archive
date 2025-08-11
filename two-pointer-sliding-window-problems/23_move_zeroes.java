import java.util.ArrayList;
import java.util.List;

// Approach: Two pointers swap
// Complexity: O(n) | O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

// Approach: Two pointers
// Complexity: O(2n) | O(1)
class Solution2 {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

// Brute Force
// Complexity: O(n) | O(n)
class Solution3 {
    public void moveZeroes(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();
        // step-1: filling all the non-zero integers
        for(int num : nums){
            if(num != 0) nonZeroElements.add(num);
        }

        // step-2 : re-assigning elements to the array - {non-zeros, zeroes}
        for(int num = 0; num < nonZeroElements.size(); num++){
            nums[num] = nonZeroElements.get(num);
        }
        for(int num = nonZeroElements.size(); num < nums.length; num++){
            nums[num] = 0; // rest elements assign them 0
        }
    }
}