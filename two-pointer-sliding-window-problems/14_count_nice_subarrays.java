class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return computeAtMostK(nums, k) - computeAtMostK(nums, k-1);
    }

    private int computeAtMostK(int[] nums, int k){
        int left = 0, result = 0;

        // Itterating the array in a window manner
        for(int right=0; right < nums.length; right++){
            if(nums[right] % 2 == 1) k--;

            // Shrink window from left if more than k distinct
            while (k < 0) {
                if(nums[left] % 2 == 1) k++;
                left++;
            }
            result += right - left+1;
        }
        return result;
    }
}