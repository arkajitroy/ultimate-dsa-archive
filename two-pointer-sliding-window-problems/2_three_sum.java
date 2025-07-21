import java.util.*;

// Approach: using two pointer
// Complexity: O(n + n) = O(2n) == O(n)| O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(n)
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue; // skipping duplicate elements

            int left = i+1, right = nums.length-1;
            int target = nums[i];

            // performing the comparison and calculating the result
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

// Approach: using set
// Complexity: O(n + n)| O(2s), s = set size

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);  // Sort the array to avoid duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicate elements

            Set<Integer> seen = new HashSet<>();
            int target = -nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (seen.contains(complement)) {
                    resultSet.add(Arrays.asList(nums[i], nums[j], complement));
                } else {
                    seen.add(nums[j]);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}