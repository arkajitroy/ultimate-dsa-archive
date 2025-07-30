// Approach: using the Brute force method
// Complexity: O(n) | O(1)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        int left = 0, product = 1;

        // Itterating over the array right pointer
        for(int right=0; right<nums.length; right++){
            product *= nums[right];

            // if the product is not valid, shrink window size
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            // All subarrays ending at right and starting from left to right are valid
            count += (right - left+1);
        }
        return count;
    }
}



// Approach: using the Brute force method
// Complexity: O(n^2) | O(1)

class Solution2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int product = 1;
            for (int end = start; end < nums.length; end++) {
                product *= nums[end];
                // if product is within range then we will increase counter
                // if its not then we will break the inner loop
                if (product < k) count++;
                else break;
            }
        }
        return count;
    }
}

