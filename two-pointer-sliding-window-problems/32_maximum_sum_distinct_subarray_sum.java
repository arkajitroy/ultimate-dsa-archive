import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Approach-1: using the sliding window technique
// complexity: O(n) | O(k)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0, windowSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int left = 0;
        for(int right = 0; right < n; right++){
            int num = nums[right];
            windowSum += num;
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            // shrink window if size exceeds k
            if(right - left + 1 > k){
                int leftSum = nums[left++];
                windowSum -= leftSum;
                freqMap.put(leftSum, freqMap.get(leftSum)-1); // remove from the map
                if(freqMap.get(leftSum) == 0) {
                    freqMap.remove(leftSum);
                }
            }
            // if window size is == k and all elements are distinct
            if(right - left + 1 == k && freqMap.size() == k){
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }
}


// Approach-2: using brute force approach
// Complexity: O(n * k) | O(k)
class Solution2 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;

        // checking all the elements putting into a hashet
        for(int i=0; i<=n-k; i++){
            HashSet<Integer> set = new HashSet<>();
            long windowSum = 0;
            boolean valid = true;
            
            for (int j = i; j < i + k; j++) {
                if (set.contains(nums[j])) {
                    valid = false;
                    break;
                }
                set.add(nums[j]);
                windowSum += nums[j];
            }
            // if the hashset has valid status then only we will update the maxSum
            if (valid) maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}