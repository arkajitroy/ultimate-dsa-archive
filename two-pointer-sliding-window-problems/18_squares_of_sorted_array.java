import java.util.Arrays;

// Approach: Optimal approach
// Complexity: O(n) | O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // initializing the pointer variables
        int left = 0, right = n-1, position= n-1;

        while (left <= right) {
            int leftSQ = nums[left] * nums[left];
            int rightSQ = nums[right] * nums[right];

            // As we need in non-decreasing / increasing order
            if(leftSQ > rightSQ){
                result[position--] = leftSQ;
                left++;
            }
            else{
                result[position--] = rightSQ;
                right--;
            }
        }
        return result;
    }
}

// Brute Force Approach
// Time Complexity: O(n log n)
// Space Complexity: O(1) (in-place sort)
class Solution2 {
    public int[] sortedSquares(int[] nums) {
        // Calculating the squares of each element
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        // Sorting the resultant array - O(n)
        Arrays.sort(nums);
        return nums;
    }
}