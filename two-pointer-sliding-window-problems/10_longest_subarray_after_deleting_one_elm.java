// Approach: using Two pointer / Sliding window
// TC: O(n)
// SC: O(1)
class Solution {
    public static int slidingWindow(int[] nums) {
        int left = 0, zeros = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            while (zeros > 1) {
                if (nums[left++] == 0) zeros--;
            }
            int currentLen = right - left;
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}

// Approach: using brute force method
// TC: O(n^2)
// SC: O(1)
class Solution2 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxSize = 0;

        for(int i=0; i<n; i++){
            int currLen = 0;
            for(int j=0; j<n; j++){
                if(j == i) continue; // simulating delete function
                if(nums[j] == 1) currLen++;
                else currLen = 0;
                maxSize = Math.max(maxSize, currLen);
            }
        }
        return maxSize;
    }
}