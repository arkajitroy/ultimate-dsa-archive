
// Approach: Hashmap + Prefix Sum
// Complexity: O(n) | O(n)

import java.util.HashMap;
import java.util.Map;

class Solution {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        // Converting 0s with 1s
        for(int i=0; i<n; i++){
            if(arr[i] == 0) arr[i] = -1;
        }

        // Initializing Hashmap and prefix sum
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);

        // Traverse and count
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }
}


// Approach: Brute Force
// Complexity: O(n^2) | O(1)

class Solution2 {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        int count = 0;

        for(int i=0; i<n; i++){
            int zeroCount = 0, oneCount = 0;
            for(int j=i; j<n; j++){
                if(arr[j] == 0) zeroCount++;
                else oneCount++;
                // increase overall subarray count
                if(zeroCount == oneCount) count++;
            }
        }
        return count;
    }
}
