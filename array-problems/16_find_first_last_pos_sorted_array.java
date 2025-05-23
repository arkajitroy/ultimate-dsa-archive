
// Approach: Linear Search
// complexity: O(n) | O(1)

class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = -1, lastIndex = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                if(firstIndex == -1) firstIndex = i;
                lastIndex = i;
            }
        }
        return new int[]{ firstIndex, lastIndex };
    }
}

// Approach: Binary Search
// complexity: O(log n) | O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = computeBound(nums, target, true);
        int lastIndex = computeBound(nums, target, false);
        return new int[]{ firstIndex, lastIndex };
    }

    private int computeBound(int[] nums, int target, boolean isFirst){
        int low = 0, high = nums.length - 1;
        int bound = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                bound = mid;
                if(isFirst) high = mid - 1;
                else low = mid + 1;
            }
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return bound;
    }
}