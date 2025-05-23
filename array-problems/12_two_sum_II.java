// Approach: Brute Force
// Complexity: O(n^2) | O(1)

import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(numbers[i] + numbers[j] == target) return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }
}

// Approach: uisng the HashMap
// Complexity: O(n) | O(n)

class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        // map<index, value>
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int comp = target - numbers[i];
            // if the complement is already in map, return indices
            if(map.containsKey(comp)) return new int[]{map.get(comp)+1, i+1};

            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}

// Approach: Two Pointers
// Complexity: O(n) | O(1)

class Solution3 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int left = 0 , right = n-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target) return new int[]{left+1, right+1};
            else if(sum < target) left++;
            else right--;
        }
        return new int[] {};
    }
}