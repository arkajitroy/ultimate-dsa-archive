import java.util.*;

// Approach : Optimal - Sliding window + Hashmap
// complexity: O(n) | O(k)

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // map<number, freq>

        // looping first window
        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        // Now looping the whole array
        for(int i=k; i<arr.length; i++){
            int out = arr[i - k];
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) map.remove(out);

            int in = arr[i];
            map.put(in, map.getOrDefault(in, 0) + 1);

            result.add(map.size());
        }
        return result;
    }
}

// Approach: Brute - using hashet - looping multiple time
// complexity: O(n * k) | O(k)

class Solution2 {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();

        // looping in a wind of k size
        for(int i=0; i <= arr.length-k; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j < i+k; j++){
                set.add(arr[j]);
            }
            result.add(set.size());
        }
        return result;
    }
}