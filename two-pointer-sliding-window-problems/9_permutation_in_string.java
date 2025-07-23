import java.util.*;

// Approach: Sliding Window + Frequency Count
// TC: O(n) where n is the length of s2
// SC: O(1) (because character set is constant size 26)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];   
        int[] windowCount = new int[26];

        // Step 1: Count character frequency of s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Step 2: Check if initial window is a permutation
        if (Arrays.equals(s1Count, windowCount)) return true;

        // Step 3: Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Shifting the window
            windowCount[s2.charAt(i) - 'a']++;   // Include next character 
            windowCount[s2.charAt(i - s1.length()) - 'a']--; // Remove the prev-character

            // After sliding, check again
            if (Arrays.equals(s1Count, windowCount)) return true;
        }

        return false; // No matching permutation found
    }
}

// Approach: Brute force all permutations
// TC: O((n - m + 1) * m log m)
// SC: O(m)
class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Sort the string s1 for easy comparison
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String sortedS1 = new String(s1Chars);

        // Traverse each substring of s2 with length equal to s1
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String sub = s2.substring(i, i + s1.length());
            char[] subChars = sub.toCharArray();
            Arrays.sort(subChars);
            String sortedSub = new String(subChars);

            if (sortedS1.equals(sortedSub)) return true;
        }

        return false;
    }
}
