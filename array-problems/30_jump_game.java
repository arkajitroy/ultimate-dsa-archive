
// - Optimal Approach : Greedy
//  complexity: O(n) | O(1)
class Solution {
    public static boolean canJump(int[] nums) {
        int maxReachable = 0;

        for(int i=0; i<nums.length; i++){
            if(i > maxReachable) return false;
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}


// *  Approach:  Top-Down DP approach - memoized
//  complexity: O(n^2) | O(n)

class Solution2 {
    private static Boolean[] memo;

    public static boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return compute(0, nums);
    }

    private static boolean compute(int position, int[] nums){
        if(position >= nums.length-1) return true;
        if(memo[position] != null) return memo[position];

        int currentJump = position + nums[position];
        int furthest = Math.min(currentJump, nums.length - 1);

        for(int next = position+1; next <= furthest; next++){
            if(compute(next, nums)){
                memo[position] = true;
                return true;
            }
        }
        memo[position] = false;
        return false;
    }
}


//  ! Approach: Recursive Bruteforce
// complexity: O(2^n) | O(n)

class Solution3 {
    public static boolean canJump(int[] nums) {
        return compute(0, nums);
    }

    private static boolean compute(int position, int[] nums){
        if(position >= nums.length-1) return true;

        int currentJump = position + nums[position];
        int furthest = Math.min(currentJump, nums.length - 1);

        for(int next = position+1; next <= furthest; next++){
            if(compute(next, nums)) return true;
        }
        return false;
    }
}