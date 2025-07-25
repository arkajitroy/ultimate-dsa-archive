import java.util.*;

class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency map for string p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            // Add current character to the window
            windowFreq[s.charAt(i) - 'a']++;

            // Remove the character that's no longer in the window
            if (i >= windowSize) {
                windowFreq[s.charAt(i - windowSize) - 'a']--;
            }

            // If frequency matches, it's an anagram
            if (Arrays.equals(windowFreq, pFreq)) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p)); // Output: [0, 6]
    }
}

// Approach: Brute Force
// TC: O(n^2)
// SC: O(n)
class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        char[] sortedP = p.toCharArray();
        Arrays.sort(sortedP);

        // Itterating 
        for(int i=0; i<=s.length()-len; i++){
            char[] substring = s.substring(i, i+len).toCharArray();
            Arrays.sort(substring);
            // Checking the substring with the initial P string
            if(Arrays.equals(substring, sortedP)){
                result.add(i);
            }
        }
        return result;
    }
}