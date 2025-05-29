import java.util.*;

// Approach: using hashing
// complexity: O(n) | O(n)

class Solution2 {
    int maxLen(int arr[], int N) {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            sum += arr[i]; // calculate cumulative sum

            if(sum == 0) maxLen = i+1; // if cumulative sum is 0, update maxLen
            
            if(map.containsKey(sum)) maxLen = Math.max(maxLen, i - map.get(sum));
            else map.put(sum, i);
        }
        return maxLen;
    }
}

// Brute Force Approach
// complexity: O(n^2) | O(1)

class Solution3 {
    int maxLen(int arr[], int N) {
        int maxLen = 0;
        
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                if (sum == 0) maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}