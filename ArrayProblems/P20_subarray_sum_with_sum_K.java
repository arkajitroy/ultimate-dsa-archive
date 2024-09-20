package ArrayProblems;

import java.util.HashMap;

class P20_subarray_sum_with_sum_K {
    // ========================== (BRUTE FORCE : O(n^2) | O(1)) ==========================
    public static int subarraySum_brute(int[] nums, int k){
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=0; j<nums.length; j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }

    // ========================== (BETTER FORCE : O(n) | O(n)) ==========================
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int currentSum = 0, count = 0;

        for(int num : nums){
            currentSum += num;

            // check if there's a prefix sum that matches currentSum - k
            if(prefixSum.containsKey(currentSum - k)){
                count += prefixSum.get(currentSum - k);
            }

            // update the count of current prefix sum
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Subarrays with sum " + k + ": " + subarraySum(nums, k));
    }
}
