import java.util.*;

// Approach: Better - using Hashmap
// complexity: O(n) | O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complementary = target - nums[i];
            if(map.containsKey(complementary)) return new int[]{map.get(complementary)};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

// Approach: Optimal wway - two pointer
// complexity: O(n) | O(1)

class Solution2 {
    public int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);

        int leftPt = 0, rightPt = nums.length-1;

        while(leftPt < rightPt){
            int sum = nums[leftPt] + nums[rightPt];

            if(sum == target) return new int[]{ leftPt, rightPt };
            else if(sum < target) leftPt++;
            else rightPt--;
        }

        return new int[]{};
    }
}