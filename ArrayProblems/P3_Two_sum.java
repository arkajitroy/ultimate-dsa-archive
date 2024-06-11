package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main{
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])) {
                return new int[] { map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4}; 
        int target = 6;
        System.out.println("Two sum - indexes: "+ Arrays.toString(twoSum(nums, target)));
    }
}

// TCs
// [3,2,4] : 6
// [2,7,11,15] : 9