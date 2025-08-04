import java.util.*;

// Approach: using hashmap + sliding window
// Complexity: O(n) | O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // map : { 'char' : 0 }
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, maxLen = 0;

        // Itterating throught the string with the right pointer
        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);

            // if char is already in the seen, move the right pointer
            if(seen.containsKey(ch)){
                left = Math.max(left, seen.get(ch)+1);
            }

            // updating the latest index and modifying the maxlen
            seen.put(ch, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}

// Approach: uisng array with constant space - {little optimization}
// Complexity: O(n) | O(128) / O(1)

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // map : { 'char' : 0 }
        int left=0, maxLen=0;
        int[] seenArr = new int[128]; // 128 : for all ascii values
        Arrays.fill(seenArr, -1);

        // Itterating throught the string with the right pointer
        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);

            // if char is already in the seen, move the right pointer
            if(seenArr[ch] >= left) left = seenArr[ch] + 1;

            // updating the latest index and modifying the maxlen
            seenArr[ch] = right;
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}