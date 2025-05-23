import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Character, Integer> countOccurrences(String s) {
        // Use HashMap to count frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
