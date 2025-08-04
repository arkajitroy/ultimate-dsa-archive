import java.util.*;

// Approach: using hashing
// Complexity: O(n) | O(n)
class Solution1{
    static int[][] findSymmetricPairs(int[][] arr) {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        
        // HashMap to store pairs
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Traverse all pairs
        for (int i = 0; i < n; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            // If reverse pair exists in hash, it's symmetric
            if (hash.containsKey(second) && 
                hash.get(second) == first) {
                result.add(new int[]{second, first});
            } else {
                // Store the current pair in hash
                hash.put(first, second);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

// Approach: using binary search
// Complexity: O(n (log n)) | O(1)
class Solution2{
    static int[][] findSymmetricPairs(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][2];
        int count = 0;

        // Sort pairs based on the first element
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Traverse all pairs and use binary search
        for (int i = 0; i < n; i++) {
            int key = arr[i][1];

            // Check if key exists as a first element
            if (computeSearch(arr, i + 1, n - 1, key)) {

                // Verify if it's a symmetric pair
                for (int j = i + 1; j < n; j++) {
                    if (arr[j][0] == key && arr[j][1] == arr[i][0]) {
                        result[count++] = arr[i];
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(result, count);
    }

    private static boolean computeSearch(int[][] arr, int low, int high, int key){
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Simple binary search template
            if (arr[mid][0] == key) return true;
            else if (arr[mid][0] < key) low = mid + 1;    
            else high = mid - 1;
        }
        return false;
    }
}

// Approach: using nested loop
// Complexity: O(n (log n)) | O(1)
class Solution3{
    static int[][] findSymmetricPairs(int[][] arr) {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();

        // traversing all the parise using two nested loops
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                // if array[i] and array[j] form a symetric pair
                if (arr[i][0] == arr[j][1] && 
                    arr[i][1] == arr[j][0]) {
                    result.add(arr[i]);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}