import java.util.*;

// Approach: using two pointers
// Complexity: O(n + m) | O(n + m)
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int n = a.length, m = b.length;

        while (left < n && right < m) {
            // Skip duplicates in a
            while (left > 0 && left < n && a[left] == a[left - 1]) left++;
            // Skip duplicates in b
            while (right > 0 && right < m && b[right] == b[right - 1]) right++;
            if (left >= n || right >= m) break;

            if (a[left] < b[right]) {
                result.add(a[left++]);
            } else if (a[left] > b[right]) {
                result.add(b[right++]);
            } else {
                result.add(a[left]);
                left++; right++;
            }
        }

        // Adding remaining elements from a
        while (left < n) {
            if (left == 0 || a[left] != a[left - 1]) result.add(a[left]);
            left++;
        }

        while (right < m) {
            if (right == 0 || b[right] != b[right - 1]) result.add(b[right]);
            right++;
        }

        return result;
    }
}

// Approach: using hasset and sorting
// Complexity : O(n+m) + O(n log n + m log m) = O(n + m log m)
class Solution2 {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();

        // Adding elements from both arrays to set
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);

        ArrayList<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}
