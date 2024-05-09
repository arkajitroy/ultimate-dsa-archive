package TwoPointers;

import java.util.Arrays;

class Main {
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0) return 0;

        int[] checkIndex = new int[128];

        Arrays.fill(checkIndex, -1);

        int maxLength = 0, start = 0;

        for(int end=0; end < s.length(); end++){
            char ch = s.charAt(end);
            start = Math.max(start, checkIndex[ch]+1);
            maxLength = Math.max(maxLength, end - start + 1);
            checkIndex[ch] = end;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(input));
    }   
}
