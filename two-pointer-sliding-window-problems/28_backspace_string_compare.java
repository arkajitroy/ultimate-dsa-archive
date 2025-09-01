import java.util.Stack;

// Optimal Approach : using the two pointer approach
// Compllexity : O(n + m) | O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // Process backspaces in s
            while (i >= 0) {
                if (s.charAt(i) == '#') { skipS++; i--; }
                else if (skipS > 0) { skipS--; i--; }
                else break;
            }

            // Process backspaces in t
            while (j >= 0) {
                if (t.charAt(j) == '#') { skipT++; j--; }
                else if (skipT > 0) { skipT--; j--; }
                else break;
            }

            // Compare current chars
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false; // one string ended

            i--;
            j--;
        }

        return true;
    }
}

// Better Approach : using the StringBuilder
// Compllexity : O(n + m) | O(n + m)
class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        String computed = buildString(s);
        return computed.equals(t);
    }

    private String buildString(String str){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}

// Brute Approach : using the StringBuilder
// Compllexity : O(n + m) | O(n + m)
class Solution3 {
    public boolean backspaceCompare(String s, String t) {
        String computed = buildString(s);
        return computed.equals(t);
    }

    private String buildString(String str){
        Stack<Character> stack = new Stack<>();
        // only insert the non deleted chars
        for(char ch : str.toCharArray()){
            if(ch != '#') stack.push(ch);
            else if(!stack.isEmpty()) stack.pop();
        }

        // Build the final string
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);

        return sb.toString();
    }
}