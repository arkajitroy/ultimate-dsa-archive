// Condition is : arr[i-1] < arr[i] > arr[i+1]

// Approach: Binary Search
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // peak is in the left half
            if(nums[mid] > nums[mid + 1]) right = mid;
            // peak is in the right half
            else right = mid + 1;
        }
        return left;
    }
}

// Approach2 : Linear Scan
class Solution2 {
    public int findPeakElement(int[] nums) {
        for(int i=0; i<nums.length; i++){
            boolean leftSmaller = (i == 0 || nums[i] > nums[i-1]);
            boolean rightSmaller = (i == nums.length-1 || nums[i] > nums[i+1]);
            
            if(leftSmaller && rightSmaller) return i;
        }
        return -1;
    }
}