import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Approach: Optimal Approach - hashet
// Complexity: O(n) | O(n)
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for(int num : arr){
            if(seen.contains(2 * num) || //num x 2 == element present in the set or not
            (num % 2 == 0 && seen.contains(num/2)) // if any num % 2 == 0 is present in the set
            ) {
                return true;
            }
            // or else we will add
            seen.add(num);
        }
        return false;
    }
}

// Another one approach: using binary search
// Complexity: O(n log n) | O(n)
class Solution2 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr); // O(n)
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int target = 2 * arr[i];
            int left = 0, right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid != i && arr[mid] == target) {
                    return true;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

// Approach: brute force - linear search
// Complexity: O(n^2) | O(1)
class Solution3 {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // Check both index should not be similar and multiples condition
                if (i != j && arr[i] == 2 * arr[j]) return true;
            }
        }
        return false;
    }
}
