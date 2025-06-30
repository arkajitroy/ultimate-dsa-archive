
// Approach: Recursive Binary Search
class Solution {
    public int singleNonDuplicate(int[] nums) {
        return computeBS(nums, 0, nums.length - 1);
    }

    private static int computeBS(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Check if mid is even
        if (mid % 2 == 0) {
            if (nums[mid] == nums[mid + 1]) {
                return computeBS(nums, mid + 2, right);
            } else {
                // If not equal, the single element lies in the left half (including mid)
                return computeBS(nums, left, mid);
            }
        } else {
            // If mid is odd
            // If nums[mid] == nums[mid - 1], the single element is in the right half
            if (nums[mid] == nums[mid - 1]) {
                return computeBS(nums, mid + 1, right);
            } else {
                // Otherwise, the single element is in the left half (excluding mid)
                return computeBS(nums, left, mid - 1);
            }
        }
    }
}


// Approach: Binary Search Operation
class Solution2 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2; // high = n-2 to prevent out-of-bound access

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is even or odd and compare with the right neighbor
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low];
    }
}

// Approach: XOR operator
class Solution3 {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}

class Solution4 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // traverse in steps of 2 to check for pairs
        for(int i=0; i<n-1; i++){
            if(nums[i] != nums[i+1]) return nums[i];
        }
        // if not found in loop, it must be the last element
        return nums[n-1];
    }
}