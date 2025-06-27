// Approach: using Binary Search

class Solution {
    int countFreq(int[] arr, int target) {
        int first = computeBound(arr, target, true);
        if (first == -1) return 0; // target not found
        int last = computeBound(arr, target, false);
        return last - first + 1;
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

// Approach: Sliding windows <-- (not applicable but doable)
class Solution2 {
    int countFreq(int[] arr, int target) {
        int index = 0, count = 0;
        while (index < arr.length) {
            if(arr[index] == target){
                while (index < arr.length && arr[index] == target) {
                    count++;
                    index++;
                }
                break;
            }
            index++;
        }
        return count;
    }
}

// Approach: Brute Force using the linear search
class Solution3 {
    int countFreq(int[] arr, int target) {
        int count = 0;
        for(int num : arr){
            if(num == target) count++;
        }
        return count;
    }
}