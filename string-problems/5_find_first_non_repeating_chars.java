import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public char firstNonRepeatingChar(String s) {
        // Use HashMap to store character frequencies
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) return c;
        }
        
        return '_';
    }
}
