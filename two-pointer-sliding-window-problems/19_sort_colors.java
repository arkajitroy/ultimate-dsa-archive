// Approach: using the counting sort - two pass
// Complexity: O(2n) | O(1)
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        // Process elements until mid passes high
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the front
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Leave 1 in the middle
                mid++;
            } else {
                // Swap 2 to the end
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Approach: using the counting sort - two pass
// Complexity: O(2n) | O(1)
class Solution2 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        // First pass: Counting the occurance of the elms
        for(int num : nums){
            count[num]++;
        }
        // Second pass: overwrite original array
        int index = 0;
        for(int i=0; i<count[0]; i++){
            nums[index++] = 0;
        }
        for(int i=0; i<count[1]; i++){
            nums[index++] = 1;
        }
        for(int i=0; i<count[2]; i++){
            nums[index++] = 2;
        }
    }
}