package RecurssionBacktracking;

import java.util.ArrayList;
import java.util.List;

// Problem : Printing all the subsequence whose sum is equal to K
class Main {
    public static void printingSubsequencesSumK(int[] nums, List<Integer> ds, int sum, int index, int targetSum) {
        if (index == nums.length) {
            if (!ds.isEmpty() && sum == targetSum) {
                System.out.println("SubSQ with sum " + targetSum + " => " + ds);
            }
            return;
        }
        // Include current element in the subsequence
        ds.add(nums[index]);
        printingSubsequencesSumK(nums, ds, sum + nums[index], index + 1, targetSum);

        // Exclude current element from the subsequence
        ds.remove(ds.size() - 1);
        printingSubsequencesSumK(nums, ds, sum, index + 1, targetSum);
    }

    // print the count of all the subsequence
    public static int countSubsequencesSumK(int[] nums, List<Integer> ds, int sum, int index, int targetSum) {
        if (index == nums.length) {
            if (!ds.isEmpty() && sum == targetSum) return 1;
            return 0;
        }
        // Include current element in the subsequence
         ds.add(nums[index]);
        int include = countSubsequencesSumK(nums, ds, sum + nums[index], index + 1, targetSum);

        // Exclude current element from the subsequence
        ds.remove(ds.size() - 1);
        int exclude = countSubsequencesSumK(nums, ds, sum, index + 1, targetSum);

        return include + exclude;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        List<Integer> ds = new ArrayList<>();
        int sum = 5;

        printingSubsequencesSumK(nums, ds, 0, 0, sum);
        System.out.println("Count of the subsequence of given K sum : " + countSubsequencesSumK(nums, ds, 0, 0, sum));
    }
}
