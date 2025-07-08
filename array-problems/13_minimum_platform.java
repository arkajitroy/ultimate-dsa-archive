
// Optimal Approach: using sorting + two pointers
// complexity: 2(n log n) + O(n) = O(2n)| O(1)

import java.util.Arrays;

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        // sorting the arrival and dept arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxPlatform = 1, platform = 1;
        int i=0, j=0, n = arr.length;

        // Looping through both the arrays
        while (i < n && j < n) {
            // If someone is arriving then we will platform++
            if(arr[i] <= dep[j]){
                maxPlatform++;
                i++;
            }
            // if someone is leaving then we will do clearing
            else{
                maxPlatform--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform, platform);
        }
        return maxPlatform;
    }
}

// Brute Force: using two pointers
// complexity: O(n^2) | O(1)
class Solution2 {
    static int findPlatform(int arr[], int dep[]) {
        int maxPlatform = 0;

        for(int i=0; i<arr.length-1; i++){
            int platform = 1;
            for(int j=0; j<arr.length; j++){
                // ignore same index, j will increase
                if(i == j) continue;
                // if the app time is greater than next train
                if(arr[i] >= arr[j] && arr[i] <= dep[j]){
                    platform++;
                }
            }
            maxPlatform = Math.max(maxPlatform, platform);
        }
        return maxPlatform;
    }
}