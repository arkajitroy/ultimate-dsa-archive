import java.util.HashMap;
import java.util.Map;

// Approach: Brute Force
// TC: O(n)
// SC: O(1)
class Solution {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // Shrink the window until we have at most 2 types
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

// Approach: Brute Force
// TC: O(n^2)
// SC: O(n)
class Solution3 {
    public int totalFruit(int[] fruits) {
        int maxLen = 0;

        for(int i=0; i<fruits.length; i++){
            // map => { fruitType : freq }
            Map<Integer, Integer> basket = new HashMap<>();
            for(int j=i; j<fruits.length; j++){
                basket.put(fruits[i], basket.getOrDefault(fruits[i], 0)+1);
                if(basket.size() > 2) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}