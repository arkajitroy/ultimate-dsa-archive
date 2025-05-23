// Brute Force Approach

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=1; j<s.length(); j++){
                if(allUnique(s, i, j)) maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }

    private boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i=start; i<=end; i++){
            if(set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }
}

// Optimal Approach

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0, end = 0;

        while(end < s.length()){
            char current = s.charAt(end);

            if (map.containsKey(current)) {
                start = Math.max(start, map.get(current) + 1);
            }

            map.put(current, end);
            maxLength = Math.max(maxLength, end - start + 1);

            end++;
        }
        return maxLength;
    }
}