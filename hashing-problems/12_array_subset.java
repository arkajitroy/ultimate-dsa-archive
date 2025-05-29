// Q. Check if an array is subset of another array

import java.util.*;

// using hashmap
// complexity: O(m + n) | O(m)

class Solution {
    public boolean isSubset(int a[], int b[]) {
        if(b.length > a.length) return false;

        // map<element, frequency>
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies in array a[]
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check if all elements of b[] are present in freqMap
        for (int num : b) {
            if (!freqMap.containsKey(num) || freqMap.get(num) == 0) {
                return false;
            }
            freqMap.put(num, freqMap.get(num) - 1); // use the element
        }

        return true;
    }
}

// using Hashset - (if duplicates are not allowed)
// complexity: same

class Solution2 {
    public boolean isSubset(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : a){
            set.add(num);
        }

        for(int num : b){
            if(!set.contains(num)) return false;
        }

        return true;
    }
}