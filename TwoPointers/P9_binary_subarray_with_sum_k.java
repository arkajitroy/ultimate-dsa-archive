package TwoPointers;

class Main {

    public static int numberOfSubarrays(int[] nums, int k){
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) k--;

            while (k < 0) {
                if (nums[left] % 2 == 1) k++;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println("Number of nice subarrays - Sliding Window: " + numberOfSubarrays(nums, k));
    }
}
