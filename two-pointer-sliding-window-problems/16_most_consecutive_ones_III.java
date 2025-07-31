// Approach: Sliding Window
// Complexity: O(n) | O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int start = 0, zeros = 0;

        for(int end=0; end<nums.length; end++){
            // if we encounter a zero, then increase the count
            if(nums[end] == 0) zeros++;
            // Check if the zero count, shrink the window
            while (zeros > k) {
                if(nums[start] == 0) zeros--;
                start++;
            }
            // Update the max length
            int windowSize = end-start+1;
            maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }
}

// Approach: brute force - building the intution for sliding window
// Complexity: O(n^2) | O(1)
class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;

        for(int start=0; start<nums.length; start++){
            int zeros = 0;
            for(int end=start; end<nums.length; end++){
                // Check if the any elements is zero then increase the count
                if(nums[end] == 0) zeros++;
                // Check if the zero count exceeds k then break the loop
                if(zeros > k) break;
                int windowSize = end-start+1;
                maxLen = Math.max(maxLen, windowSize);
            }
        }
        return maxLen;
    }
}

// Approach: Better approach - {Binary Search + Prefix sum} - not recommended
// Complexity: O(n log n) | O(n)
class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] prefixZeros = new int[n+1];

        // calculating the prefix zeroes count
        for(int i=0; i<n; i++){
            prefixZeros[i+1] = prefixZeros[i] + (nums[i] == 0 ? 1 : 0);
        }

        int maxLen = 0;
        // Itterating the array and search for start-index
        for(int right=0; right<n; right++){
            int left = computeSearch(prefixZeros, right+1, k);
            int windowSize = right-left+1;
            maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }

    private int computeSearch(int[] prefix, int end, int k){
        int low = 0, high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefix[end] - prefix[mid] <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}