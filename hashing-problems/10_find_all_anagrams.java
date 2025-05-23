import java.util.*;

// optimal approach: sliding window + hasmap
// complexity: O(n) | O(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        if (s.length() < len) return result;

        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for (char c : p.toCharArray()) pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }

        if (pCount.equals(sCount)) result.add(0);

        for (int i = len; i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - len);

            sCount.put(newChar, sCount.getOrDefault(newChar, 0) + 1);
            sCount.put(oldChar, sCount.get(oldChar) - 1);
            if (sCount.get(oldChar) == 0) sCount.remove(oldChar);

            if (pCount.equals(sCount)) result.add(i - len + 1);
        }
        return result;
    }
}

// Approach: using sorting
// complexity: O(n) | O(1)

class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        char[] pSorted = p.toCharArray();
        Arrays.sort(pSorted);

        for (int i = 0; i <= s.length() - len; i++) {
            char[] sub = s.substring(i, i + len).toCharArray();
            Arrays.sort(sub);
            if (Arrays.equals(sub, pSorted)) {
                result.add(i);
            }
        }
        return result;
    }
}

// approach: brute force
// complexity: O(n^2) | O(1)


class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = p.length();

        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (isAnagram(sub, p)) result.add(i);
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        for (int val : count) if (val != 0) return false;
        return true;
    }
}