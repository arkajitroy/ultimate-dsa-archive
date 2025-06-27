//  Question : First and Last Position of Element in Sorted Array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = computeBound(nums, target, true); // left-bound
        int lastIndex = computeBound(nums, target, false); // right-bound
        return new int[]{ firstIndex, lastIndex };
    }

    private int computeBound(int[] nums, int target, boolean isFirst){
        int low = 0, high = nums.length - 1;
        int bound = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                bound = mid;
                // if it is for the left bound
                if(isFirst) high = mid - 1;
                // or it will be for the right bound
                else low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return bound;
    }
}

