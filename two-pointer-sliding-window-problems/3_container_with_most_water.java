// Approach: using the sliding window
// TC: O(n) + O(n) + O(n) = O(3n) which is nearabout to O(n)
// SC: O(1)

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;

        // Running a single loop comparing the left and right position
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h*w;
            maxArea = Math.max(maxArea, area);

            // Tweaking the pointers as per the weight
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}

// Approach: Brute force with nested loop
// TC: O(n^2) + O(2n) = O(n^2)
// SC: O(1)

class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        // Looping into the array with 2 loops
        for(int outer = 0; outer<height.length; outer++){
            for(int inner = outer+1; inner < height.length; inner++){
                int h = Math.min(height[outer], height[inner]);
                int w = inner - outer;
                int area = h*w;

                // recalculating the max area by comparing with current area
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}