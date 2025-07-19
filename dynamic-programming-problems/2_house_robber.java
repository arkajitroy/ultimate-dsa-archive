import java.util.Arrays;

// Approach: Recursion
// Complexity: O(n) | O(n)
class Solution3 {
    public int rob(int[] nums) {
        int size = nums.length;
        return compute(0, nums, size);
    }
    private static int compute(int index, int[] nums, int size){
        if(index >= size) return 0;

        int rob = nums[index] + compute(index+2, nums, size);
        int skip = compute(index+1, nums, size);

        return Math.max(rob, skip);
    }
}

// Approach: Recursion
// Complexity: O(n) | O(n)
class Solution2 {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return compute(0, nums, memo);
    }
    private static int compute(int index, int[] nums, int[] memo){
        if(index >= nums.length) return 0;

        if(memo[index] != -1) return memo[index];

        int rob = nums[index] + compute(index+2, nums, memo);
        int skip = compute(index+1, nums, memo);

        memo[index] = Math.max(rob, skip);

        return memo[index];
    }
}

// Approach: Tabulation
// Complexity: O(n) | O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length - 1];
    }
}