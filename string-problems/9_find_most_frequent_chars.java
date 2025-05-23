class Solution {
    public static char getMaxOccuringChar(String s) {
        int[] count = new int[256];
        int maxCount = 0;
        char result = ' ';
        
        for (char c : s.toCharArray()) {
            count[c]++;
            if (count[c] > maxCount) {
                maxCount = count[c];
                result = c;
            }
        }
        
        return result;
    }
}
