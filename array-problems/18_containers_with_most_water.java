// Approach: Optimal Approach
// Complexity: O(n^2) + O(2n) | O(1)

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        // Running a single loop, comparing left and right pointer
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            // tweeking the pointers as per the height
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}

// Approach: Brute Force
// Complexity: O(n^2) + O(2n) | O(1)

class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        // traversing the array with 2 loops
        for(int left=0; left<height.length; left++){
            for(int right=left+1; right<height.length; right++){
                int h = Math.max(height[left], height[right]);
                int w = right-left;
                maxArea = Math.max(maxArea, h * w);
            }
        }
        return maxArea;
    }
}