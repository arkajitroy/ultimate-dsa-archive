// Approach: Two pointer // sliding window
// TC: O(n)
// SC: O(26) = O(1) constant space
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        // itterating the string
        for(int right=0; right<s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']++);

            int windowLen = right-left+1; // +1 is for 0 based indexing

            // Check if the condition for changing the element satisfies
            // If not then shrink down window size
            if(windowLen-maxCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, windowLen);
        }
        return maxLen;
    }
}


// Approach: Brute Force
// TC: O(n^2) * O(n) = O(n^3)
// SC: O(1)
class Solution3 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            int[] freq = new int[26];
            for (int end = start; end < n; end++) {
                freq[s.charAt(end) - 'A']++;
                int maxFreq = getMax(freq);
                int windowLen = end - start + 1;

                // Number of elements need to change : windowLen - maxFreq
                if (windowLen - maxFreq <= k) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            }
        }
        return maxLen;
    }
    private static int getMax(int[] freq) {
        int max = 0;
        for (int f : freq) max = Math.max(max, f);
        return max;
    }
}