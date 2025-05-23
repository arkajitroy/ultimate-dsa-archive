import java.util.*;

// Brute Force Approach
// complexity: O(n log n) | O(n)

class Solution3{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) return false;
        }
        return true;
    }
}

// Optimal Approach
// complexity: O(n) | O(k) <-- k = 26 , so it is constant, so O(1) 

class Solution2{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int freq : count) {
            if (freq != 0) return false;
        }

        return true;
    }
}

// Better Approach
// complexity : O(n) | O(n)

class Solution{
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // count frequency of each character in string
        for (char ch : s.toCharArray()) {
            int freq = map.getOrDefault(ch, 0);
            map.put(ch, freq + 1);
        }

        // check if frequency of each character in string
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) map.remove(ch);
        }
        return true;
    }
}