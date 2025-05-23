
// Approach: using binary search
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

// Approach: using linear search

class Solution2 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums.length == 1) return i;
            if (i == 0 && nums[i] > nums[i + 1]) return i;
            if (i == nums.length - 1 && nums[i] > nums[i - 1]) return i;
            if (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return -1;
    }
}
