// Approach: Two pointer sliding window
// TC: O(n)
// SC: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if(n == 0) return 0;

        int leftPt = 0, rightPt = n-1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (leftPt < rightPt) {
            // Computing leftward section with window size
            if(height[leftPt] < height[rightPt]){
                if(height[leftPt] >= leftMax) leftMax = height[leftPt];
                else totalWater += leftMax - height[leftPt];
                leftPt++;
            }
            // Computing rightward section with window size
            else{
                if(height[rightPt] >= rightMax) rightMax = height[rightPt];
                else totalWater += rightMax - height[rightPt];
                rightPt--;
            }
        }

        return totalWater;
    }
}


// Approach: Precompute LeftMax and RightMax
// TC: O(n + n + n) = O(3n) , nearabout O(n)
// SC: O(2n) , nearabout O(n)

class Solution2 {
    public int trap(int[] height) {
        int n = height.length;

        if(n == 0) return 0;

        int[] leftMax = new int[n], rightMax = new int[n];
        int totalWater = 0;

        leftMax[0] = height[0];

        // Computing the leftmax
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // Computing the rightmax using the reverse loop
        rightMax[n-1] = height[n-1];
        for(int i=n-1; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        // Computing the total water collecting left and right section
        for(int i=0; i<n; i++){
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}

// Approach: Brute force with nested loop
// TC: O(n * (2n)) = O(n^2)
// SC: O(1)

class Solution3 {
    public int trap(int[] height) {
        int n = height.length;

        if(n == 0) return 0;
        
        int totalWater = 0;

        for(int outer=0; outer<n; outer++){
            int leftMax = 0, rightMax = 0;

            // finding the left max computed value
            for(int inner = 0; inner <= outer; inner++){
                leftMax = Math.max(leftMax, height[inner]);
            }

            // finding the right max computed value
            for(int inner = 0; inner <= outer; inner++){
                rightMax = Math.max(rightMax, height[inner]);
            }

            int computedValue = Math.max(leftMax, rightMax) - height[outer];

            totalWater += computedValue;
        }

        return totalWater;
    }
}