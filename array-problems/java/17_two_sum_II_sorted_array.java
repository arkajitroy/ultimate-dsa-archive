
// Optimal : using two pointer approach
// complexity: O(n) | O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int left = 0, right = size - 1;

        while (left < right) {
            int sum = numbers[left] - numbers[right];
            // if the target is greater than sum then left++ OR right--;
            if(sum == target) return new int[]{ left-1, right+1 };
            else if(sum < target) left++;
            else right--;
        }
        return new int[]{};
    }
}

// Another approach: using binary search
// complexity: O(n log n) | O(1)
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        
        for(int i=0; i<size; i++){
            int complementary = target - numbers[i];
            int index = computeSearch(complementary, numbers, i+1, size-1);
            if(index != -1){
                return new int[]{ i+1, index+1 };
            }
        }
        return new int[0];
    }

    private int computeSearch(int target, int[] numbers, int left, int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (numbers[mid] == target) return mid;    
            else if (numbers[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}