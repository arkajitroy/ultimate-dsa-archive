package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    // Better: O(n^3)
    public static List<List<Integer>> threeSum_better(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                int third = -(nums[i] + nums[j]);

                // find the element in the set
                if(hashset.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    set.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        // storing the set in the result
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    // OPTIMAL : O(n^2)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements
            }
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicate elements
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicate elements
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("Three Sum : " + threeSum(nums));
    }
}
