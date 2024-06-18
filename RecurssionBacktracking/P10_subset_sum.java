package RecurssionBacktracking;

import java.util.ArrayList;

class Main {
    public static int subsetSum(int[] nums) {
        ArrayList<Integer> subsets = new ArrayList<>();
        backtrack(0, 0, nums, subsets);
        return subsets.size();
    }

    private static void backtrack(int index, int sum, int[] nums, ArrayList<Integer> subsets) {
        if (index == nums.length) {
            subsets.add(sum);
            return;
        }
        // pick element
        backtrack(index + 1, sum + nums[index], nums, subsets);
        // not-pick element
        backtrack(index + 1, sum, nums, subsets);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        System.out.println("Number of subset sums: " + subsetSum(nums));
    }
}
