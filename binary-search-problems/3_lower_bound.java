// Approach : using binary search
// complexity: O(log n)

class Solution {
    int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < target) low = mid + 1;
            else high = mid;            
        }
        return low;
    }

    int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}

// approach: using the linear search
// complexity: O(log n)

class Solution2 {
    int lowerBound(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) return i;
        }
        return arr.length;
    }

    int upperBound(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) return i;
        }
        return arr.length;
    }
}
