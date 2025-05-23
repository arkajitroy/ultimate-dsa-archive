import java.util.*;

// Approach: using Hashset
// complexity: O(n) | O(n)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // itterating over each element
        for(int num : nums){
            if(!set.add(num)) return true;
        }
        return false;
    }
}

// Approach: using sorting
// complexity: O(n log n) | O(1)

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}

// Approach: using brute force
// complexity: O(n^2) | O(1)

class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}