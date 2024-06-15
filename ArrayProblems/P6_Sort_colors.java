import java.util.Arrays;

class Solution {
    public static void sortColors_countSort(int[] nums) {
        int[] counts = new int[3]; // Array to store counts for colors 0, 1, and 2
        for (int num : nums) {
            counts[num]++;
        }
        int index = 0;
        for (int color = 0; color <= 2; color++) {
            while (counts[color] > 0) {
                nums[index++] = color;
                counts[color]--;
            }
        }
    }

    public static void sortColors_DNF(int nums[]){
        int lo=0, mid=0, hi=nums.length-1;

        while(mid <= hi){
            if(nums[mid] == 0){
                swap(nums, lo, mid);
                lo++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, hi);
                hi--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        
        System.out.println("Original array: " + Arrays.toString(nums));
        sortColors_DNF(nums);

        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}