import java.util.*;

// Approach: using sliding window and hashset
// TC: O(n)
// SC: O(min(n,m))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}

// Approach: using Hashmap and last seen index
// TC: O(n)
// SC: O(min(n,m))
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, start = 0;

        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            // If any character is present in the map
            // Then we will take that as start
            if(map.containsKey(current)){
                start = Math.max(start, map.get(current) + 1);
            }
            map.put(current, 1);
            maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }
}


// Approach: using nested loop and Hashet
// TC: O(n^3) + O(n) = O(n^3)
// SC: O(S) // size of the set
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(allUnique(s, i, j)) maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }

    private boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }
}