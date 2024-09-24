package SlidingWindow_TwoPointers;

class P12_minimum_window_substring {
    public static String minWindow(String source, String target){
        if (source == null || target == null || source.length() == 0 || target.length() == 0) return "";

        // creating a frequency array to store all the char-occurances
        int[] targetCharCount = new int[128];
        for (char ch : target.toCharArray()) {
            targetCharCount[ch]++;
        }


        int requiredCount = target.length();
        int leftPointer = 0, rightPointer = 0, validCharCount = 0;

        // Array to store the frequency of characters in the current window
        int[] windowCharCount = new int[128];

        int minLength = Integer.MAX_VALUE, minWindowStart = 0;

        // Expanding the window by moving the right pointer
        while (rightPointer < source.length()) {
            char currentChar = source.charAt(rightPointer);
            windowCharCount[currentChar]++;

            // If the character is part of the target string and its frequency is still valid in the window
            if (targetCharCount[currentChar] > 0 && windowCharCount[currentChar] <= targetCharCount[currentChar]) {
                validCharCount++;
            }

            // When the current window has all required characters (validCharCount == requiredCount)
            while (validCharCount == requiredCount) {
                if (rightPointer - leftPointer + 1 < minLength) {
                    minLength = rightPointer - leftPointer + 1;
                    minWindowStart = leftPointer;
                }

                char leftChar = source.charAt(leftPointer);
                windowCharCount[leftChar]--;

                // If removing the left character makes the window invalid, decrease the validCharCount
                if (targetCharCount[leftChar] > 0 && windowCharCount[leftChar] < targetCharCount[leftChar]) {
                    validCharCount--;
                }
                leftPointer++;  // Shrink the window
            }
            rightPointer++;
        }

        // Return the smallest valid window substring, or an empty string if no such window exists
        return minLength == Integer.MAX_VALUE ? "" : source.substring(minWindowStart, minWindowStart + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
