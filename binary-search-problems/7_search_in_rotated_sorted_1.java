// Approach: using Binary Search

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(mid == target) return mid;

            // check if the left half is sorted
            if(nums[left] <= nums[mid]){
                // if the target is on the left half
                if(nums[left] <= target && target < mid){
                    right = mid - 1;
                }
                else{ // condition fails search in the right half
                    left = mid + 1;
                }
            }else{ // if the right half is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}