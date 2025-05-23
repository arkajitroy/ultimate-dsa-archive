import java.util.*;

// Complexity : TC - O(n_log_n) + O(n^2) = O(n^2), SC - O(1)

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int result = 1, n = arr.length;

        for (int i = 1; i < n; i++) {
            int count = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] <= dep[j]) {
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        return result;
    }
}

// Complexity : TC - O(2 n_log_n) + O(n) = O(n_log_n), SC - O(1)

class Solution2 {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform_needed = 1, max_platforms = 1, n = arr.length;;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform_needed++;
                i++;
            } else {
                platform_needed--;
                j++;
            }

            max_platforms = Math.max(max_platforms, platform_needed);
        }

        return max_platforms;
    }
}