class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid - 1;
        }
        
        return result;
    }
}

// Approach: Brute Force solution will be - doing linear search algorithm