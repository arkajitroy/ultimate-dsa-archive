
import java.util.HashMap;
import java.util.Map;

// Approach: Faster Sliding window solution

class Solution1 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] tCount = new int[128]; // Assuming ASCII characters

        // Populate the tCount array with the count of characters in T
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If the current character is in T, decrement the required count
            if (tCount[rightChar] > 0) {
                requiredChars--;
            }
            
            // Decrement the count for the current character in the window
            tCount[rightChar]--;

            // Check if all characters in T are found in the current window
            while (requiredChars == 0) {
                // Update the minimum window if the current window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                // Increment the count for the character going out of the window
                tCount[leftChar]++;
                
                // If the character going out was in T, increment the required count
                if (tCount[leftChar] > 0) {
                    requiredChars++;
                }

                left++;
            }

            right++;
        }

        // Check if a valid window was found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}

// Approach: Sliding Window + Hashmap
// TC: O(n)
// SC: O(n)

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";

        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int required = targetFreq.size(); // Number of unique characters in t
        int formed = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // If frequency matches the target, increment formed
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink window while valid
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char lChar = s.charAt(left);
                windowFreq.put(lChar, windowFreq.get(lChar) - 1);

                if (targetFreq.containsKey(lChar) && windowFreq.get(lChar) < targetFreq.get(lChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}

// Approach: Brute Force - checking all the characters - 128 chars
// TC: O(n² × 128) ≈ O(n²) for ASCII
// SC: O(1) - 128 fixed size

class Solution2 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";

        int minLen = Integer.MAX_VALUE;
        String result = "";

        // itterating through both the strings
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String substring = s.substring(i, j);

                if(containsAllChar(substring, t)){
                    if(substring.length() < minLen){
                        minLen = substring.length();
                        result = substring;
                    }
                }
            }
        }

        return result;
    }

    private boolean containsAllChar(String substring, String t){
        int SIZE = 128;
        int[] substringCount = new int[SIZE]; // all asci values
        int[] tCount = new int[SIZE];

        // storing all the characters in their respective char count array
        for(char ch : substring.toCharArray()) substringCount[ch]++;
        for(char ch : t.toCharArray()) tCount[ch]++;

        // now checking both the array
        for(int i=0; i<SIZE; i++){
            if(tCount[i] > substringCount[i]) return false;
        }

        return true;
    }
}