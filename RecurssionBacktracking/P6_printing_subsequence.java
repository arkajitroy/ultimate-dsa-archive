package RecurssionBacktracking;

import java.util.ArrayList;
import java.util.List;

class Main{
    public static void printingSubsequences(int[] nums, List<Integer> ds, int index){
        if (index == nums.length) {
            if(!ds.isEmpty()) System.out.println("SubSQ : "+ds);
            return;
        }

        // Include current element in the subsequence
        ds.add(nums[index]);
        printingSubsequences(nums, ds, index + 1);

        // Exclude current element from the subsequence
        ds.remove(ds.size() - 1);
        printingSubsequences(nums, ds, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        List<Integer> ds = new ArrayList<>();
        printingSubsequences(nums, ds, 0);
    }
}