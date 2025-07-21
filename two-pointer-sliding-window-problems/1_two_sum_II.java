// Approach: using Two pointer
// Complexity: O(n) | O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // base case : if the target matches the sum
            if(sum == target) return new int[]{ left+1, right+1 };
            else if(sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }
}

// Approach: using binary search
// Complexity: O(n log n) | O(1)
class Solution2{
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0; i<n; i++){
            int complement = target - numbers[i];
            int index = computeBS(numbers, complement, i+1, n);

            if (index != -1) return new int[]{i + 1, index + 1};
        }
        return new int[0];
    }

    private static int computeBS(int[] numbers, int target, int left, int right){
        while (left < right) {
            int mid = left + (right - left)/2;

            if(numbers[mid] == target) return mid;
            else if(numbers[mid] < target) left = mid + 1;
            else right = mid-1;
        }
        return -1;
    }
}