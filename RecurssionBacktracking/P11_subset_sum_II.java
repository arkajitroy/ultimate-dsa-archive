package RecurssionBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] nums, List<Integer> ds, List<List<Integer>> result){
        result.add(new ArrayList<>(ds));
        for(int i=index; i<nums.length; i++){
            if(i != index && nums[i] == nums[i-1]) continue;
            // add the element in container
            ds.add(nums[i]);
            backtrack(i+1, nums, ds, result);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        System.out.println("Subset Sum II (contains duplicate) : " + subsetsWithDup(nums));
    }
}