package ArrayProblems;

import java.util.Arrays;

class Main {
    public static int[] twoSumII(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            int complementory = target - nums[i];
            int left = i+1, right = nums.length - 1;
            int index = search(nums, complementory, left, right);

            if (index != -1) return new int[]{i + 1, index + 1};
        }
        return new int[0];
    }

    private static int search(int[] nums, int target, int left, int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;    
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15};
        int target = 9;
        System.out.println("Two Sum 2 : " + Arrays.toString(twoSumII(nums, target)) + " target : " + target);
    }
}
